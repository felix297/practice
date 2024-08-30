package com.company.pojo;

public class Info {
    private User user;

    public User getUser () {
        return user;
    }

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
