package com.company;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("main")
public class ServiceImpl implements Service {
    @Override
    public void select () {
        System.out.println("select method");
    }

    @Override
    public void delete () {
        System.out.println("delete method");
    }

    @Override
    public void update () {
        System.out.println("update method");
    }

    @Override
    public void create () {
        System.out.println("create method");
    }
}
