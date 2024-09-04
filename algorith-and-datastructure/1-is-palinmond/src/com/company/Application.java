package com.company;

public class Application {
    public static void main (String[] args) {
        longestPalindrome("ccd");
    }

    public static int longestPalindrome(String s) {
        int[] counts = new int[26];
        char[] letters = s.toCharArray();
        int res = 0;

        for (char ele: letters) {
            counts[ele - 'a']++;
        }

        for (int ele: counts) {
            if (ele % 2 == 0) {
                res = res + ele;
            }
        }

        boolean flag = false;
        for (int ele: counts) {
            if (ele == 1) {
                res++;
                break;
            }
            flag = true;
        }

        for (int ele: counts) {
            if (ele % 2 == 1) {
                res = res + ele - 1;

                if (flag) {
                    res++;
                    flag = false;
                }
            }
        }

        return res;
    }
}