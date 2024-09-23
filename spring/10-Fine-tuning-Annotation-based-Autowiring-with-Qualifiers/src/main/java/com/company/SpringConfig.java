package com.company;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean(value="info")
    public Info getInfo () {
        return new Info();
    }

    @Bean
    @Genre("main")
    public User getUser1 () {
        return new User("tom", 10);
    }

    @Bean
    public User getUser2 () {
        return new User("jerry", 3);
    }
}
