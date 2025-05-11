package com.company;

public class Main {
    public static void main (String[] args) {
        Solution solution = new Solution();
//        String[] logs = new String[] {"d1/","d2/","./","d3/","../","d31/"};
        String[] logs = new String[] {"d1/","d2/","../","d21/","./"};
        int res = solution.minOperations(logs);
        System.out.println(res);
    }
}