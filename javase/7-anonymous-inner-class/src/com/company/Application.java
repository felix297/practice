package com.company;

public class Application {
    public static void main (String[] args) {
        // 1. 匿名内部类实现接口
        People chinese = new People () {
            @Override
            public void eat () {
                System.out.println("eating");
            }

            @Override
            public void walk () {
                System.out.println("walking");
            }
        };

        chinese.eat();

        // 2. 匿名内部类继承父类
        Dog zhangDog = new Dog () {
            @Override
            public void bark() {
                System.out.println("zhangDog is barking...");

            }
        };

        zhangDog.bark();
    }
}