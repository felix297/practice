package com.company;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        // read data
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[][] arr = new int[n][n];
        boolean[][] match = new boolean[n][n];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                arr[row][col] = scanner.nextInt();
            }
        }

        HashSet<Integer> cards = new HashSet<>();
        for (int index = 0; index < k; index++) {
            cards.add(scanner.nextInt());
        }

        int res = countRow(n, k, arr, match, cards) + countCol(n, match) + countMainDiag(n, match) + countAntiDiag(n, match);

        System.out.println(res);
    }

    public static int countRow (int n, int k, int[][] arr, boolean[][] match , HashSet<Integer> cards) {
        boolean hasUnpleasedEle;
        int res = 0;

        for (int row = 0; row < n; row++) {
            hasUnpleasedEle = false;
            for (int col = 0; col < n; col++) {
                if (cards.contains(arr[row][col]) || (row == n/2 && col == n/2)) {
                    match[row][col] = true;
                } else {
                    match[row][col] = false;
                    hasUnpleasedEle = true;
                }
            }
            if (!hasUnpleasedEle) {
                res++;
            }
        }

        return res;
    }

    public static int countCol (int n, boolean[][] match) {
        boolean hasUnpleasedEle;
        int res = 0;

        for (int col = 0; col < n; col++) {
            hasUnpleasedEle = false;
            for (int row = 0; row < n; row++) {
                if (!match[row][col]) {
                    hasUnpleasedEle = true;
                    break;
                }
            }
            if (!hasUnpleasedEle) {
                res++;
            }
        }

        return res;
    }

    public static int countMainDiag (int n, boolean[][] match) {
        boolean hasUnpleasedEle = false;
        int res = 0;

        for (int index = 0; index < n; index++) {
            if (!match[index][index]) {
                hasUnpleasedEle = true;
                break;
            }
        }
        if (!hasUnpleasedEle) {
            res++;
        }

        return res;
    }

    public static int countAntiDiag (int n, boolean[][] match) {
        boolean hasUnpleasedEle = false;
        int res = 0;

        for (int index = 0; index < n; index++) {
            if (!match[index][n - 1 - index]) {
                hasUnpleasedEle = true;
                break;
            }
        }
        if (!hasUnpleasedEle) {
            res++;
        }

        return res;
    }
}