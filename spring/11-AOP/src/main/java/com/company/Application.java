package com.company;

import com.company.dao.UserDao;
import com.company.dao.UserDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main (String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        UserDao userDao = context.getBean("userDao", UserDao.class); // 动态代理 代理的是接口！
        userDao.create();
    }
}
