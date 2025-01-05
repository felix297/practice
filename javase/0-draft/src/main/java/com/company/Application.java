package com.company;

import java.util.ArrayList;
import java.util.Stack;

public class Application {
    public static void main (String[] args) {
        String str = "0-2147483647";
        System.out.println(calculate(str));
    }


    public static Integer calculate(String s) {
        char[] letters = s.toCharArray();
        ProcessBuilder processBuilder = new ProcessBuilder();

        Stack<String> buffer = new Stack<>();
        StringBuilder number = new StringBuilder();
        for (int index = letters.length - 1; index > -1; index--) {
            char letter = letters[index];
            if (letter != ' ') {
                if (letter != '+' && letter != '*' && letter != '/' && letter != '-') {
                    number.append(letter);
                } else {
                    buffer.push(number.reverse().toString());
                    buffer.push(Character.toString(letter));
                    number = new StringBuilder("");
                }
            }
        }
        if (!number.equals("")) {
            buffer.push(number.reverse().toString());
        }

        // 先乘除
        Stack<String> buffer2 = new Stack<>();
        while (!buffer.empty()) {
            String number1str = buffer.pop();
            Integer number1 = Integer.valueOf(number1str);
            buffer2.push(number1str);

            String operation = null;
            if (!buffer.empty()) {
                operation = buffer.pop();
            }

            if (operation != null && operation.equals("*")) {
                Integer number2 = Integer.valueOf(buffer.pop());
                Integer res = number2 * number1;
                buffer.push(res.toString());
                buffer2.pop();
                continue;
            }

            if (operation != null && operation.equals("/")) {
                Integer number2 = Integer.valueOf(buffer.pop());
                Integer res = number1 / number2;
                buffer.push(res.toString());
                buffer2.pop();
                continue;
            }

            if (operation != null) {
                buffer2.push(operation);
            }
        }

        // 后加减
        Stack<String> buffer3 = new Stack<>();
        while (!buffer2.empty()) {
            buffer3.push(buffer2.pop());
        }
        while (!buffer3.empty()) {
            Integer number1 = Integer.valueOf(buffer3.pop());
            if (buffer3.empty()) {
                return number1;
            }
            String operation = buffer3.pop();
            Integer number2 = Integer.valueOf(buffer3.pop());

            if (operation.equals("+")) {
                buffer3.push(Integer.toString(number1 + number2));
                continue;
            }

            if (operation.equals("-")) {
                buffer3.push(Integer.toString(number1 - number2));
                continue;
            }
        }

        return Integer.valueOf(buffer2.pop());
    }
}