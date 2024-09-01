package com.company.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

public class User {
    private String name;
    private int age;
    private String gender;

    public User () {

    }

    public User (String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

//    @Required
    public void setName (String name) {
        this.name = name;
    }

    public String getName () {
        return this.name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}