package com.company;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main (String [] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        TestBean testBean = applicationContext.getBean("testBean", TestBean.class);
        System.out.println(testBean.TYPE);


    }
}