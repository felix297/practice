package com.company;

import java.util.Stack;

public class Solution {
    public int minLength (String s) {
        Stack<Character> restEle = new Stack<>();
        char[] sArr = s.toCharArray();
        int sLen = s.length();
        for (char currChar: sArr) {
            if (restEle.empty()) {
                restEle.push(currChar);
            } else {
                if ((restEle.peek() == 'A' && currChar == 'B') || (restEle.peek() == 'C' && currChar == 'D')) {
                    restEle.pop();
                } else {
                    restEle.push(currChar);
                }
            }
        }

        return restEle.size();
    }
}