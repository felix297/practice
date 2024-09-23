package com.company;

import com.company.dao.ApplicationConfig;
import com.company.dao.Info;
import com.company.dao.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main (String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//        UserService userService = context.getBean("userService", UserService.class);
//        userService.printUserStringInfo();
//        userService.printUserIntInfo();

        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        Info info = context.getBean("info", Info.class);
        System.out.println(info.toString());

    }

}