package com.company;

import java.util.Stack;

public class Solution {
    public int minOperations (String[] logs) {
        Stack<String> paths = new Stack<>();
        for (String log: logs) {
            if (log.equals("./")) {

            } else if (log.equals("../")) {
                if (!paths.empty()) {
                    paths.pop();
                }
            } else {
                paths.push(log);
            }
        }
        return paths.size();
    }
}