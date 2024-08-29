package com.company;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanDefinitionInheritancePractice {
    @Test
    public void beanDefinitionInheritance () {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
//        ParentClass parentClass = context.getBean("parentBean", ParentClass.class);
        ChildClass childClass = context.getBean("childBean", ChildClass.class);
        System.out.println(childClass.toString());
    }
}