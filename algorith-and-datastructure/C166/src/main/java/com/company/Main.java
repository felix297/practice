package com.company;

import java.util.*;

public class Main {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amount = scanner.nextInt();

        // 500 coin
        int count4fiveHundred = amount/500;
        amount = amount%500;

        // 100 coin
        int count4oneHundred = amount/100;
        amount = amount%100;

        // 50 coin
        int count4fifty = amount/50;
        amount = amount%50;

        // 10 coin
        int count4ten = amount/10;
        amount = amount%10;

        // 5 coin
        int count4five = amount/5;
        amount = amount%5;

        System.out.println(count4fiveHundred + count4oneHundred + count4fifty + count4ten + count4five + amount);
    }
}
