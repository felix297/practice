package com.company.dao;

import org.springframework.stereotype.Component;

@Component
public class UserInfoIntImpl implements UserInfo<Integer> {
    @Override
    public Integer getUserInfo (User user) {
        return user.getAge();
    }
}