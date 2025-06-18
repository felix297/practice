package com.company;

import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = "abcdef";
        char ch = 'f';
        Solution solution = new Solution();
        System.out.println(solution.reversePrefix(word, ch));
    }
}