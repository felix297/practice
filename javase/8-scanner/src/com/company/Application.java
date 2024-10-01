package com.company;

import java.util.Scanner;

public class Application {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = 0;
        scanner.close();
        while (scanner.hasNext()) {
            System.out.println(scanner.next());
            System.out.println(++count);
        }
    }
}