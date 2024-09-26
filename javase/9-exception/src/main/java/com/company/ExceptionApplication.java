package com.company;

import org.junit.Test;

import java.util.Objects;

public class ExceptionApplication {
    public static void main (String[] args) {
        try {
            int[] nums = new int[2];
            System.out.println(nums[2]);
        } catch (Exception e) {
            // 哄骗毕业设计
            // e.printStackTrace();
            System.out.println("message: " + e.getMessage());
            System.out.println("cause: " + e.getCause().getMessage());
        }
    }

    @Test
    public void nullPointerException () {
        int[] nums = null;
        Objects.requireNonNull(nums, "you're referring a null object");
//        System.out.println(nums.length);

    }
}