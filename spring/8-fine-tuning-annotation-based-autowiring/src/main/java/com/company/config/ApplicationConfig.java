package com.company.config;

import com.company.pojo.Info;
import com.company.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ApplicationConfig {
    @Bean
    public Info getInfo () {
        Info info = new Info ();
        return info;
    }

    @Bean
    public User getUser1 () {
        User user1 = new User("tom", 20, "male");
        return user1;
    }

    @Bean
    @Primary
    public User getUser2 () {
        User user2 = new User("mary", 23, "female");
        return user2;
    }
}