package com.company;

import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        // read data
        Scanner scanner = new Scanner(System.in);
        String msg = scanner.nextLine();

        // algorithm
        int msgLen = msg.length();
        StringBuilder res = new StringBuilder();
        for (int index = 0; index < msg.length(); index = index + 2) {
            res.append(msg.charAt(index));
        }

        System.out.println(res.toString());
    }
}