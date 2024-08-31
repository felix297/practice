package com.company;

import com.company.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main (String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        ApplicationContextAwareImpl awareImpl = context.getBean("applicationContextAwareImpl", ApplicationContextAwareImpl.class);
        User user = awareImpl.getApplicationContext().getBean("user", User.class);
        System.out.println(user.toString());

        BeanNameAwareImpl beanNameAwareImpl = context.getBean("beanNameAwareImpl", BeanNameAwareImpl.class);
        System.out.println(beanNameAwareImpl.getBeanName());
    }
}