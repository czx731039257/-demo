package com.csx.demo2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@EnableAsync(proxyTargetClass = true)
@ServletComponentScan
@MapperScan("com.csx.demo2.dao")
@SpringBootApplication
@EnableCaching
public class Messageboard2Application {

    public static void main(String[] args) {
        SpringApplication.run(Messageboard2Application.class, args);
    }
}
