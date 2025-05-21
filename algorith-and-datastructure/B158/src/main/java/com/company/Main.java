package com.company;

import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        // read data
        int N = scanner.nextInt();
        int[][] example = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                example[i][j] = scanner.nextInt();
            }
        }

        // algorithm
        // get left up 1/4 part of base array
        int[][] midArr = new int[N][N];
        int largestNum = (N + 1)/2;
        for (int i = 0; i < largestNum; i++) {
            for (int j = 0; j <= i; j++) {
                midArr[i][j] = j + 1;
            }
            for (int j = i + 1; j < largestNum; j++) {
                midArr[i][j] = midArr[i][i];
            }
        }
        // get right up 1/4 part
        for (int i = 0; i < largestNum; i++) {
            for (int j = largestNum; j < N; j++) {
                midArr[i][j] = midArr[i][N - j - 1];
            }
        }
        // get the bottom half
        for (int i = largestNum; i < N; i++) {
            for (int j = 0; j < N; j++) {
                midArr[i][j] = midArr[N - i - 1][j];

            }
        }

        // get the res
        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                res += (example[i][j] - midArr[i][j]);
            }
        }

        System.out.println(res);
    }
}