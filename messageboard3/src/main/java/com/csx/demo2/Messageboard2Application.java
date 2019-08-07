package com.csx.demo2;

import com.csx.demo2.filter.MyFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;

@ServletComponentScan
@MapperScan("com.csx.demo2.dao")
@SpringBootApplication
public class Messageboard2Application {

    public static void main(String[] args) {
        SpringApplication.run(Messageboard2Application.class, args);
    }
}
