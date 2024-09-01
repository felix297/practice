package com.company;

import org.junit.Test;

public class Application {
    @Test
    public void test () {
        // 能调用父亲的方法和属性
        Dog zhangDog = new Dog("xiao zhang", 2, "male");
//        zhangDog.setName("xiao zhang");
//        zhangDog.setAge(2);
//        zhangDog.setGender("male");
        zhangDog.eat();
        System.out.println(zhangDog.toString());

        // 能调用爷爷的方法和属性
//        TianYuan zhangDog = new TianYuan();
//        zhangDog.setName("tian yuan quan");
//        zhangDog.setAge(1);
//        zhangDog.setGender("male");
//        zhangDog.eat();
//        System.out.println(zhangDog.toString());

    }
}