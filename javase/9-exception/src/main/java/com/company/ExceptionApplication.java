package com.company;

import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class ExceptionApplication {
    public static void main (String[] args) throws NullPointerException {
//        try {
//            int[] nums = new int[2];
//            System.out.println(nums[2]);
//        } catch (Exception e) {
//            // 哄骗毕业设计
//             e.printStackTrace();
//        }

        int[] nums = new int[2];
        for (int index = 0; index <= nums.length; index++) {
            if (index == nums.length) {
                throw new NullPointerException();
            }
            nums[index] = index;
            System.out.println(nums[index]);
        }
    }

    @Test
    public void nullPointerException () throws IOException {
        int[] nums = null;
        Objects.requireNonNull(nums, "you're referring a null object");
        throw new IOException();

    }

    @Test
    public void convertStringToDataTest () {
        try {
            int a = 1;
            int b = 0;
            int c = a + b;
            convertStringToDate1("sf", null);
        } catch (ParseException e) {
            System.out.println(e);

        }
    }

    @Test
    public void convertStringToDataTest2 () throws ParseException {
        convertStringToDate1("sf", null);
    }

    public static Date convertStringToDate1(String dateString, String format) throws ParseException {
        if (format == null) {
            format = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.parse(dateString);
    }

    public static Date convertStringToDate2(String dateString, String format) {
        if (format == null) {
            format = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            return sdf.parse(dateString);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }
}