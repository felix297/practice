package com.company;

import java.util.Scanner;

public class Main {
    private static int tolCol;
    private static int tolRow;

    public static void main (String[] args) {
        // read data
        Scanner scanner = new Scanner(System.in);
        tolRow = scanner.nextInt();
        tolCol = scanner.nextInt();

        String[] rows = new String[tolRow];
        for (int row = 0; row < tolRow; row++) {
            rows[row] = new String(scanner.nextLine());
        }

        // algorithm
        int res = 0;
        for (int row = 0; row < tolRow; row++) {
            for (int col = 0; col < tolCol; col++) {
                // horizontal dir
                boolean isResChanged = false;
                // 是否贯穿
                if (rows[row].charAt(col + 1) == '.' || rows[row].charAt(col - 1) == '.' || col == 0 || col == tolCol - 1) {
                    for (int index = 0; index < tolCol; index++) {
                        if (rows[row].charAt(index) == '#') {
                            res++;
                            isResChanged = true;
                            break;
                        }
                    }
                }
                if (isResChanged) {
                    // 是否划分为两块湖
                    if (row == 0 || !rows[row - 1].contains("#") || row == tolRow - 1 || !rows[row + 1].contains("#")) {
                        res++;
                    }
                }

                // vertical dir
                isResChanged = false;
                if (row == 0 || rows[row - 1].charAt(col) == '.' || row == tolRow - 1 || rows[row + 1].charAt(col) == '.') {
                    for (int index = 0; index < tolRow; index++) {
                        if (rows[index].charAt(col) == '#') {
                            res++;
                            isResChanged = true;
                            break;
                        }
                    }
                }
                if (isResChanged) {
                    // 是否划分为两块湖
                    if (col == 0 || col == tolCol - 1) {
                        res++;
                    }
                    boolean hasBlock = false;
                    for (int subRow = 0; subRow < tolRow; subRow++) {
                        for (int subCol = 0; subCol < col; subCol++) {
                            if (rows[subRow].charAt(subCol) == '#') {
                                hasBlock = true;
                                break;
                            }
                        }
                        if (hasBlock) {
                            break;
                        }
                    }
                    if (!hasBlock) {
                        res++;
                    }
                    hasBlock = false;
                    for (int subRow = 0; subRow < tolRow; subRow++) {
                        for (int subCol = col; subCol < tolCol; subCol++) {
                            if (rows[subRow].charAt(subCol) == '#') {
                                hasBlock = true;
                                break;
                            }
                        }
                        if (hasBlock) {
                            break;
                        }
                    }
                    if (!hasBlock) {
                        res++;
                    }
                }

                //
            }
        }

        System.out.println(res);
    }
}