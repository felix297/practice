package com.company.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserInfoStringImpl implements UserInfo<String> {
    @Override
    public String getUserInfo (User user) {
        return user.getName();
    }
}
