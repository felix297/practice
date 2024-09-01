package com.company;

public class Dog extends Animal {
    private String name;
//    private int age;
//    private String gender;
    public Dog () {
        super();
    }

    public Dog(String name, int age, String gender) {
        super(name, age, gender);
    }

    public void eat() {
        System.out.println(this.getName() + " is eating...");
    }

    @Override
    public String getName () {
        System.out.println("this is in class Dog");
        return this.name;
    }
    @Override
    public void setName (String name) {
        this.name = name;
    }

}