package com.neofect.gts.web.cms.config;

import com.unvus.config.mybatis.UnvusMyBatisConfig;
import com.unvus.config.mybatis.interceptor.AuditingInterceptor;
import com.unvus.config.mybatis.interceptor.PreventInjectionInterceptor;
import com.unvus.config.mybatis.pagination.PaginationInterceptor;
import com.unvus.config.mybatis.support.DefaultMapper;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.io.IOException;


/**
 * Created by guava on 16.6.19.
 */
public abstract class MyBatisConfig extends UnvusMyBatisConfig {

    public static final String BASE_PACKAGE = "com.neofect.gts.core";
    public static final String TYPE_ALIASES_PACKAGE = "com.neofect.gts.core";
    public static final String TYPE_HANDLER_PACKAGE = "com.unvus.config.mybatis.type, com.neofect.gts.core.config.mybatis.type";
    public static final String MAPPER_LOCATIONS_PATH = "classpath*:mybatis/sql/**/*.xml";

    protected void configureSqlSessionFactory(SqlSessionFactoryBean sessionFactoryBean, DataSource dataSource) throws IOException {
        super.configureSqlSessionFactory(sessionFactoryBean, dataSource, TYPE_ALIASES_PACKAGE, TYPE_HANDLER_PACKAGE, MAPPER_LOCATIONS_PATH);
    }
}

@Configuration
@MapperScan(basePackages = MyBatisConfig.BASE_PACKAGE, annotationClass = DefaultMapper.class, sqlSessionFactoryRef = "defaultSqlSessionFactory")
class DefaultMyBatisConfig extends MyBatisConfig {
    @Primary
    @Bean
    public SqlSessionFactory defaultSqlSessionFactory(@Qualifier("defaultDataSource") DataSource defaultDataSource) throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();

        configureSqlSessionFactory(sessionFactoryBean, defaultDataSource);

        return sessionFactoryBean.getObject();
    }

	@Override
	protected Interceptor[] getInterceptors() {
		return new Interceptor[]{new PaginationInterceptor(), new AuditingInterceptor(), new PreventInjectionInterceptor()};
	}
}


