package com.company;

public class Main {
    public static void main (String[] args) {
        VocaGenerator vocaGenerator = new VocaGenerator();
        vocaGenerator.generateData4AllClass("src_files", "Anki.txt");
    }
}