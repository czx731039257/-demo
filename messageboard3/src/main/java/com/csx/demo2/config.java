package com.csx.demo2;

import com.csx.demo2.handler.MyHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class config extends WebMvcConfigurerAdapter {

    @Bean
    public MyHandler myHandler() {
        return new MyHandler();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myHandler()).addPathPatterns("/SelectPersonMessageController")
                .addPathPatterns("/SelectGroupMessageController")
                .addPathPatterns("/SelectOtherGroupMessageController")
                .addPathPatterns("/SelectAllMessageController")
                .addPathPatterns("/CreateMessageController")
                .addPathPatterns("/PersonInfoController")
                .addPathPatterns("/SelectGroupUserInfoController")
                .addPathPatterns("/SelectOtherGroupUserInfoController")
                .addPathPatterns("/SelectAllUserInfoController")
                .addPathPatterns("/allocationcontroller")
                .addPathPatterns("/EditPersonInfoSuccessController");

    }
}
