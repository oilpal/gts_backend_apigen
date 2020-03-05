package com.neofect.gts.core.config.database;

import com.neofect.gts.core.config.properties.LegacyDatabaseProperties;
import com.unvus.config.database.UnvusDatabaseConfiguration;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * 추가 데이터 소스 설정.
 */
@Configuration
@EnableTransactionManagement
@ConditionalOnProperty(prefix="application.datasource.legacy", name = "url")
@EnableConfigurationProperties(LegacyDatabaseProperties.class)
class LegacyDatabaseConfig extends UnvusDatabaseConfiguration {


    @Autowired
    private LegacyDatabaseProperties databaseProperties;

    public HikariDataSource realDataSource() {
        HikariConfig config = configureDataSource(databaseProperties);
        return new HikariDataSource(config);
    }

    @Bean(name = "legacyDataSource")
    public DataSource dataSource() {
        return wrapWithLog4jdbc();
    }

    @Bean(name = "legacyTx")
    public PlatformTransactionManager transactionManager(@Qualifier("legacyDataSource") DataSource legacyDataSource) {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(legacyDataSource);

        return transactionManager;
    }
}
