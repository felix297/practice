package com.org.entity;

public class User {
    private String name;
    private int age;

    public void setName(String name){
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

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}