package com.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
public class LogServiceImpl implements Service {
    @Autowired
//    @Qualifier("main")
    private ServiceImpl service;

    @DependsOn
    public void setService (ServiceImpl service) {
        this.service = service;
    }

    @Override
    public void select () {
        log("log...select");
        service.select();
    }

    @Override
    public void update () {
        log("log...update");
        service.update();
    }

    @Override
    public void create () {
        log("log...create");
        service.create();
    }

    @Override
    public void delete () {
        log("log...delete");
        service.delete();
    }


    private void log (String msg) {
        System.out.println(msg);
    }
}