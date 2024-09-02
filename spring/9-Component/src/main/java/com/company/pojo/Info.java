package com.company.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Info {
    @Autowired
    private User user;
//
//    public User getUser () {
//        return this.user;
//    }
//
//    public void setUser (User user) {
//        this.user = user;
//    }
//
//    @Override
//    public String toString() {
//        return "Info{" +
//                "user=" + user +
//                '}';
//    }
}