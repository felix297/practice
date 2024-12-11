package com.company;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class TestBean {
    public final int TYPE = 1;

    @PostConstruct
    public void afterBeanInitialization () {
        System.out.println("bean initialization....");
    }

    @PreDestroy
    public void afterBeanDestroy () {
        System.out.println("bean destroyed...");
    }
}