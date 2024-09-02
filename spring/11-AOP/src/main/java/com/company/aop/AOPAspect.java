package com.company.aop;

import org.springframework.stereotype.Component;

@Component("aop")
public class AOPAspect {
    public void before () {
        System.out.println("before...");
    }

    public void after () {
        System.out.println("after...");
    }
}
