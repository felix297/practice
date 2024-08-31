package com.company;

import org.springframework.beans.factory.BeanNameAware;

public class BeanNameAwareImpl implements BeanNameAware {
    private String beanName;

    @Override
    public void setBeanName (String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName () {
        return this.beanName;
    }
}