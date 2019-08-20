package com.csx.demo2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@MapperScan("com.csx.demo2.dao")
@SpringBootApplication
public class Messageboard2Application {

    public static void main(String[] args) {
        SpringApplication.run(Messageboard2Application.class, args);
    }
}
