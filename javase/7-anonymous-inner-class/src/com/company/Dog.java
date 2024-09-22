package com.company;

public class Dog {
    private String name;
    private int age;

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

    public void bark () {
        System.out.println("dog" + " is barking...");
    }
}