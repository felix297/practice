package com.company.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("userService")
public class UserService {
    private UserInfoIntImpl userInfoIntImpl;
    private UserInfoStringImpl userInfoStringImpl;
    private User user;

//    @Autowired
    public void UserService (User user, UserInfoIntImpl userInfoIntImpl, UserInfoStringImpl userInfoStringImpl) {
        this.user = user;
        this.userInfoIntImpl = userInfoIntImpl;
        this.userInfoStringImpl = userInfoStringImpl;
    }

    public void printUserIntInfo () {
        System.out.println(userInfoIntImpl.getUserInfo(this.user));
    }

    public void printUserStringInfo () {
        System.out.println(userInfoStringImpl.getUserInfo(this.user));
    }
}