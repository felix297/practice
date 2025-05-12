package com.company;

import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        run();

    }

    public static void run () {
        // read data
        Scanner scanner = new Scanner(System.in);
        int tolRow = scanner.nextInt();
        int tolCol = scanner.nextInt();

        int[][] scores = new int[tolRow][tolCol];
        for (int rowNum = 0; rowNum < tolRow; rowNum++) {
            for (int colNum = 0; colNum < tolCol; colNum++) {
                scores[rowNum][colNum] = scanner.nextInt();
            }
        }

        // algorithm
        for (int rowNum = 1; rowNum < tolRow; rowNum++) {
            for (int colNum = 0; colNum < tolCol; colNum++) {
                if (colNum == 0) {
                    scores[rowNum][colNum] = scores[rowNum][colNum] + Math.max(scores[rowNum - 1][colNum], scores[rowNum - 1][colNum + 1]);
                } else if (colNum == tolCol - 1) {
                    scores[rowNum][colNum] = scores[rowNum][colNum] + Math.max(scores[rowNum - 1][colNum], scores[rowNum - 1][colNum - 1]);
                } else {
                    scores[rowNum][colNum] = scores[rowNum][colNum] + Math.max(Math.max(scores[rowNum - 1][colNum], scores[rowNum - 1][colNum - 1]), scores[rowNum - 1][colNum + 1]);
                }
            }
        }

        int max = 0;
        for (int index = 0; index < tolCol; index++) {
            max = Math.max(max, scores[tolRow - 1][index]);
        }
        System.out.println(max);
    }
}