package com.company;

import java.io.IOException;

public class Main {
    public static void main (String[] args) {
        run();
    }

    public static void run () {
        VocaGenerator vocaGenerator = new VocaGenerator();
        vocaGenerator.generateData4AllClass();
//        String text = "私は漢字が読めます";
//        String hiragana = VocaUtil.toHiragana(text);
//        System.out.println("原文: " + text);
//        System.out.println("平假名: " + hiragana);
    }
}