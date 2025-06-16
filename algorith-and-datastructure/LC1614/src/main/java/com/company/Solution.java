package com.company;

import java.util.Stack;

public class Solution {
    public int maxDepth (String s) {
        Stack<Character> stack = new Stack<>();
        int length = s.length();
        int maxDepth = 0;
        for (int index = 0; index < length; index++) {
            char currChar = s.charAt(index);
            if (currChar == '(') {
                stack.push(currChar);
                int stackSize = stack.size();
                if (stackSize > maxDepth) {
                    maxDepth = stackSize;
                }
            } else if (currChar == ')') {
                stack.pop();
            }
        }

        return maxDepth;
    }
}