package com.company;

import java.util.ArrayList;
import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        int length = s.length();
        Stack<String> buffer = new Stack<>();
        StringBuilder digitHandler = new StringBuilder();

        for (int index = 0; index < length; index++) {
            Character currChar = s.charAt(index);
            if (Character.isLetter(currChar) || currChar.equals('[')) {
                buffer.push(currChar.toString());
            } else if (Character.isDigit(currChar)){
                digitHandler.append(currChar);

                if (!Character.isDigit(s.charAt(index + 1))) {
                    buffer.push(digitHandler.toString());
                    digitHandler = new StringBuilder();
                }
            } else {
                StringBuilder tempRes = new StringBuilder();
                ArrayList<String> tempResArr = new ArrayList<>();
                while (!buffer.peek().equals("[")) {
                    tempResArr.add(buffer.pop());
                }

                for (String ele: tempResArr) {
                    tempRes.insert(0, ele);
                }

                buffer.pop(); // 弹出 "["
                int count = Integer.parseInt(buffer.pop()); // 解析数字

                while (count > 0) {
                    buffer.push(tempRes.toString());
                    count--;
                }
            }
        }

        StringBuilder res = new StringBuilder();
        while (!buffer.empty()) {
            res.insert(0, buffer.pop());
        }

        return res.toString();
    }
}