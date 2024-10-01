package com.company.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Info {
    private User user;

    public Info () {

    }

    @Autowired
    public Info(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Info{" +
                "user=" + user.toString() +
                '}';
    }
}