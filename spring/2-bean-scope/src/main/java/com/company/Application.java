package com.company;

import com.company.pojo.Info;
import com.company.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main (String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        
        // singleton bean
        User user1 = context.getBean("user", User.class);
        User user2 = context.getBean("user", User.class);
        User user3 = context.getBean("user", User.class);
        System.out.println(user1.hashCode());
        System.out.println(user2.hashCode());
        System.out.println(user3.hashCode());

        // prototype bean
        User user4 = context.getBean("user2", User.class);
        User user5 = context.getBean("user2", User.class);
        User user6 = context.getBean("user2", User.class);
        System.out.println(user4);
        System.out.println(user5);
        System.out.println(user6);

        // singleton beans with prototype-bean dependencies
        Info info = context.getBean("info", Info.class);
        System.out.println(info.toString());

        Info info2 = context.getBean("info", Info.class);
        System.out.println(info2.toString());
    }
}