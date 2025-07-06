package com.company;

import java.util.Stack;

public class Solution {
    public String clearDigits (String s) {
        char[] sArr = s.toCharArray();
        Stack<Character> restChar = new Stack<>();
        for (char currChar: sArr) {
            if (Character.isDigit(currChar)) {
                if (!restChar.empty()) {
                    restChar.pop();
                }
            } else {
                restChar.push(currChar);
            }
        }

        StringBuilder restString = new StringBuilder();
        while (!restChar.empty()) {
            restString.append(restChar.pop());
        }

        return restString.reverse().toString();
    }
}