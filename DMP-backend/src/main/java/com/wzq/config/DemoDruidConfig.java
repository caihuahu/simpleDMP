package com.wzq.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author wzq
 * @create 2023-02-13 21:36
 */
@Configuration
@MapperScan(basePackages = "com.wzq.demo.dao",sqlSessionTemplateRef = "demoSqlSessionTemplate")
public class DemoDruidConfig {



    @Bean(name = "demoSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("demoDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mappers/demo/**/*Mapper.xml"));
        return bean.getObject();
    }

    @Bean(name = "demoTransactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("demoDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "demoSqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("demoSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }


}
