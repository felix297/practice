package com.company;

/**
 * 主类
 * @author felix
 * @since 2025.5.22
 */
public class CommentPractice {
    public static void main (String[] args) {
        // 这是一个单行注释

        /*
        这是多行注释
        这是多行注释
         */

        addNum(1,2);

    }

    /**
     * 两数相加
     * @param number1 第一个数
     * @param number2 第二个数
     * @return 两数之和
     */
    public static int addNum (int number1, int number2) {
        return number1 + number2;
    }
}