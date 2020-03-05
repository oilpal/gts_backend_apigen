package com.neofect.gts.core.config.database;

import com.neofect.gts.core.config.properties.DefaultDatabaseProperties;
import com.unvus.config.database.UnvusDatabaseConfiguration;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * 기본 데이터 소스 설정.
 */
@Configuration
@EnableTransactionManagement
@EnableConfigurationProperties(DefaultDatabaseProperties.class)
class DefaultDatabaseConfig extends UnvusDatabaseConfiguration {


    @Autowired
    private DefaultDatabaseProperties databaseProperties;

    public DataSource realDataSource() {
        HikariConfig config = configureDataSource(databaseProperties);
        return new HikariDataSource(config);
    }

    @Primary
    @Bean(name = "defaultDataSource")
    public DataSource dataSource() {
        return wrapWithLog4jdbc();
    }

    @Primary
    @Bean(name = "defaultTx")
    public PlatformTransactionManager transactionManager(@Qualifier("defaultDataSource") DataSource defaultDataSource) {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(defaultDataSource);

        return transactionManager;
    }
}
