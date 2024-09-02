package com.company;

import com.company.config.ApplicationConfig;
import com.company.pojo.Info;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main (String[] args) {
        // xml-based application context
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Info info = context.getBean("info", Info.class);
        System.out.println(info.toString());

        // class-based application context
        ApplicationContext context_annotation = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        Info info_annotation = context_annotation.getBean("getInfo", Info.class);
        System.out.println(info_annotation.toString());

    }
}