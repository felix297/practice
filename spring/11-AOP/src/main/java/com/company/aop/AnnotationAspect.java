package com.company.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component("annotationAOP")
public class AnnotationAspect {
    @Before("execution(* com.company.dao.UserDaoImpl.*(..))")
    public void before () {
        System.out.println("annotation before...");
    }

    @After("execution(* com.company.dao.UserDaoImpl.*(..))")
    public void after () {
        System.out.println("annotation after...");
    }
}
