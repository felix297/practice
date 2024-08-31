package com.company.pojo;

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

    public void init () {
        if (name == null) {
            throw new IllegalArgumentException("please input the name!");
        }
    }

    public String getName () {
        return this.name;
    }

    public void setName (String name) {
        this.name = name;
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
}