package com.company;

public class Dog extends Animal {
    @Override
    public void bark () {
        System.out.println(this.getClass().getSimpleName() + " " + this.getName() + " is barking...");
    }
}
