package com.company;

public class Main {
    public static void main (String[] args) {
        run();
    }

    public static void run () {
        VocaGenerator vocaGenerator = new VocaGenerator();
        vocaGenerator.generateData4AllClass();
    }
}