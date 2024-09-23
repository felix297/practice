package com.company.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.company.dao"})
public class ApplicationConfig {
    @Bean
    public User getUser1 () {
        return new User("jerry", 3);
    }

    @Bean
    public User getUser2 () {
        return new User("jack", 1);
    }
}
