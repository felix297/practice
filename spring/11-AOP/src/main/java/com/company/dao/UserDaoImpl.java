package com.company.dao;

import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
    public void create () {
        System.out.println("creating...");
    }

    public void delete () {
        System.out.println("deleting");
    }

    public void update () {
        System.out.println("updating");
    }

    public void select () {
        System.out.println("selecting");
    }
}
