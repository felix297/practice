package com.org.entity;

import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class Info {
    // 1. 根据名称注入
    // 用在字段上
    // @Resource(name="user")
//    private User user;

    // 用在 setter 方法
//    @Resource(name="user")
//    public void setUser (User user) {
//        this.user = user;
//    }

    // 2. 根据类型注入
    // 不给 @Resource 添加 name 的值，并且把 user 的那个 bean 的名字也改了，
    // 依旧可以注入成功
//    @Resource
    private User user;

    @Resource
    public void setUser (User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Info{" +
                "user=" + user.toString() +
                '}';
    }
}