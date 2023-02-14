package com.wzq.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * druid配置类
 *
 * @author wzq
 * @create 2023-02-13 21:34
 */
@Configuration
public class DataSourceConfig {

    @Bean
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }

    @Primary
    @Bean(name = "adminDataSource")
    @ConfigurationProperties("spring.datasource.druid.admin")
    public DataSource admin() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "demoDataSource")
    @ConfigurationProperties("spring.datasource.druid.demo")
    public DataSource demo() {
        return DruidDataSourceBuilder.create().build();
    }
}
