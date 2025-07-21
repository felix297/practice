package com.company;

public class Main {
    public static void main (String[] args) {
        VocaGenerator vocaGenerator = new VocaGenerator();
        String fileName = "class1";
        vocaGenerator.generateData4OneClass("rawVoca/" + fileName + ".txt", "Anki_" + fileName + ".txt");
//        vocaGenerator.generateData4AllClass("rawVoca", "Anki.txt");
    }
}