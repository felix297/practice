package com.company;

import com.company.pojo.Info;
import com.company.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main (String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beanx.xml");
        Info info = context.getBean("info", Info.class);
        Info info2 = context.getBean("info", Info.class);
        System.out.println(info == info2);

    }

}