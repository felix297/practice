package com.org;

import com.org.entity.Info;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ResourceApplication {
    public static void main (String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Info info = context.getBean("info", Info.class);
        System.out.println(info.toString());


    }
}