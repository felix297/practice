package com.company;

public class Application {
    public static void main (String[] args) {

        // 向上转型
        Animal animal = new Dog();
        // 这样访问拿到的是父类的信息
        System.out.println(animal.name);
        System.out.println(animal.age);
        // 这样拿的是子类的信息
        System.out.println(animal.getName());
        System.out.println(animal.getAge());
    }
}