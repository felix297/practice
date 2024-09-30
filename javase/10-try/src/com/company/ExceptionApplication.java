package com.company;

import java.io.IOException;

public class ExceptionApplication {
    public static void main (String[] args) {
        try {
            method();
            method1();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void method1 () throws IOException {
        throw new IOException ("method 1");
    }

    public static void method () {
        try {
            System.out.println(1);
            System.out.println(1);
            System.out.println(1);
            System.out.println(1);
            System.out.println(1);
            System.out.println(1);
            System.out.println(1);
            System.out.println(1);
            System.out.println(1);
            int[] nums = new int[1];
            System.out.println(nums.length);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}