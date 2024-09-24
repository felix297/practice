package com.company.config;

import com.company.annotation.Genre;
import org.springframework.beans.factory.annotation.CustomAutowireConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;

@ComponentScan("com.company.dao")
@Configuration
public class ApplicationConfig {
    @Bean
    public CustomAutowireConfigurer customAutowireConfigurer () {
        CustomAutowireConfigurer customAutowireConfigurer = new CustomAutowireConfigurer();
        Set<Class> qualifierTypes = new HashSet<>();
        qualifierTypes.add(Genre.class);
        customAutowireConfigurer.setCustomQualifierTypes(qualifierTypes);
        return customAutowireConfigurer;
    }
}