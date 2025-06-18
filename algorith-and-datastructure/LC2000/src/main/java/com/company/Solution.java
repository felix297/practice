package com.company;

import java.util.Stack;

public class Solution {
    public String reversePrefix (String word, char ch) {
        StringBuilder resStr = new StringBuilder();
        Stack<Character> prefix = new Stack<>();
        int length = word.length();
        int prefixLength = 0;
        for (int index = 0; index < length; index++) {
            char currCh = word.charAt(index);
            if (currCh != ch) {
                prefix.push(currCh);
                prefixLength++;
                continue;
            }
            prefix.push(ch);
            break;
        }

        if (prefixLength == length) {
            return word;
        }

        while (!prefix.empty()) {
            resStr.append(prefix.pop());
        }

        resStr.append(word.substring(prefixLength + 1));
        return resStr.toString();
    }
}