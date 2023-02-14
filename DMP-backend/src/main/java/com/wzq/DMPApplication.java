package com.wzq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;

/**
 * 启动类
 *
 * @author wzq
 * @create 2023-02-13 15:20
 */
@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class
})
public class DMPApplication {

    public static void main(String[] args) {
        // 启动SpringBoot应用
        SpringApplication.run(DMPApplication.class, args);
    }

}
