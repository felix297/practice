package com.company;

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
}