package com.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

public class Info {
    @Autowired
    @Genre("main")
    private User user;

    @Override
    public String toString() {
        return "Info{" +
                "user=" + user.toString() +
                '}';
    }
}