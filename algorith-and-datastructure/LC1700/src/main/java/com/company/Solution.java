package com.company;

public class Solution {
    public int countStudent(int[] students, int[] sandwiches) {
        for (int sandwich: sandwiches) {
            if (hasSandwich(sandwich, students)) {
                return stuNum(students);
            }
        }
        return 0;
    }

    public int stuNum (int[] students) {
        int res = 0;
        for (int student: students) {
            if (student == 0 || student ==1) {
                res++;
            }
        }
        return res;
    }

    public boolean hasSandwich (int sandwich, int[] students) {
        for (int index = 0; index < students.length; index++) {
            if (students[index] == sandwich) {
                students[index] = 3;
                return true;
            }
        }
        return false;
    }
}