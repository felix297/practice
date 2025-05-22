package com.company;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int supNum = scanner.nextInt();
        int goodNum = scanner.nextInt();

        int[][] arr = new int[supNum][goodNum];
        for (int supSeq = 0; supSeq < supNum; supSeq++) {
            for (int goodSeq = 0; goodSeq < goodNum; goodSeq++) {
                arr[supSeq][goodSeq] = scanner.nextInt();
            }
        }

        HashSet<Integer> supSet = new HashSet<>();
        for (int goodSeq = 0; goodSeq < goodNum; goodSeq++) {
            int supWithLeastPrice = 0;
            int leastPrice = 1001;
            for (int supSeq = 0; supSeq < supNum; supSeq++) {
                int priceInSup = arr[supSeq][goodSeq];
                if (priceInSup < leastPrice) {
                    leastPrice = priceInSup;
                    supWithLeastPrice = supSeq;
                }
            }
            supSet.add(supWithLeastPrice);
        }

        System.out.println(supSet.size());
    }
}