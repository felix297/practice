package com.company;

import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        // first line
        int steps = scanner.nextInt();
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        scanner.nextLine();

        // second line
        int x = scanner.nextInt(); x--;
        int y = scanner.nextInt(); y--;
        scanner.nextLine();

        // third line
        String route = scanner.nextLine();

        // matrix
        int[][] students = new int[rows][columns];
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                students[row][column] = scanner.nextInt();
            }
            scanner.nextLine();
        }

        for (int step = 0; step < steps; step++) {
            char action = route.charAt(step);
            switch (action) {
                case 'F':
                    x--;
                    break;
                case 'B':
                    x++;
                    break;
                case 'L':
                    y--;
                    break;
                case 'R':
                    y++;
                    break;
                default:
                    break;
            }
            int chocolate = students[x][y];
            System.out.println(chocolate);
        }
    }
}