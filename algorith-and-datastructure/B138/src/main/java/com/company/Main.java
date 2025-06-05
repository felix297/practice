package com.company;

import java.util.Scanner;

public class Main {
    private static String[] strings;
    private static int rows;
    private static int cols;

    public static void main (String[] args) {
        // read data
        Scanner scanner = new Scanner(System.in);
        rows = scanner.nextInt();
        cols = scanner.nextInt();
        scanner.nextLine();
        strings = new String[rows];
        for (int index = 0; index < rows; index++) {
            strings[index] = scanner.nextLine();
        }

        // algorithm
        int res = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (strings[row].charAt(col) == '.') {
                    if (isDona(row, col)) {
                        res++;
                    }
                }
            }
        }

        System.out.println(res);
    }

    /**
     * 判断是不是找到了一个 dona
     * @param x . 的横坐标
     * @param y . 的纵坐标
     * @return true —— 是 dona; false —— 不是 dona
     */
    public static boolean isDona (int x, int y) {
        // 判断边界
        if (cols - y >= 2 && y >= 1 && rows - x >= 2 && x >= 1) {
            return isAllNum(strings[x - 1].substring(y - 1, y + 2)) && isOneDot(strings[x].substring(y - 1, y + 2)) && isAllNum(strings[x + 1].substring(y - 1, y + 2));
        }

        return false;
    }

    public static boolean isAllNum (String string) {
        return !string.contains(".") ;
    }

    public static boolean isOneDot (String string) {
        return string.contains(".") && string.startsWith("#") && string.endsWith("#");
    }
}