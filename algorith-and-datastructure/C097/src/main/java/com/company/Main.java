package com.company;

import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        // read data
        int tolCan = scanner.nextInt();
        int A = scanner.nextInt();
        int B = scanner.nextInt();

        for (int index = 1; index <= tolCan; index++) {
            // AB
            if (index % A == 0) {
                if (index % B == 0) {
                    System.out.println("AB");
                    continue;
                } else {
                    System.out.println("A");
                    continue;
                }
            }

            if (index % B == 0) {
                System.out.println("B");
                continue;
            }

            System.out.println("N");
        }
    }
}