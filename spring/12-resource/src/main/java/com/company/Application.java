package com.company;

import com.company.dao.Info;
import com.company.config.ApplicationConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main (String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        Info info = context.getBean("info", Info.class);
        System.out.println(info.getUser().toString());
    }
}