package com.company;

import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Solution solution = new Solution();
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(solution.maxDepth(s));
    }
}