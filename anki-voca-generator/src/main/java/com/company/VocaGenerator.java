package com.company;

import java.util.Objects;
import java.io.*;

public class VocaGenerator {
    private void verifyFile (File file) {
        if (!file.exists()) {
            try {
                if (file.isDirectory()) {
                    file.mkdir();
                } else {
                    file.createNewFile();
                }
            } catch (IOException e) {
                System.out.println("Error when creating target file <" + file.getAbsolutePath() + ">");
                e.printStackTrace();
            }
        }
    }

    private void writeLineIntoFile (String outputFilePath, String content) {
        File file = new File(outputFilePath);
        verifyFile(file);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath, true))) {
            writer.append(content);
        } catch (IOException e) {
            System.out.println("Error when writing into target file <" + file.getAbsolutePath() + ">");
            e.printStackTrace();
        }
    }

    public void generateData4OneClass (File rawFile, String outputFilePath) {
        verifyFile(rawFile);
        try(BufferedReader reader = new BufferedReader(new FileReader(rawFile))) {
            String line;
            int count = 1;
            while (Objects.nonNull(line = reader.readLine())) {
                String[] strArr = line.split("\t");
                if (strArr.length != 7) {
                    System.out.println("Wrong colume number at line " + count);
                    continue;
                }
                Tango tango = new Tango(strArr[2], strArr[5], strArr[0], strArr[1], strArr[6], rawFile.getName().substring(0, 6) + "_" + count + ".mp3");
                writeLineIntoFile(outputFilePath, tango.toString());
                System.out.println("Word " + count + " is inserted!");
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void generateData4OneClass (String rawFilePath, String outputFilePath) {
        String absoluteFilePath = this.getClass().getClassLoader().getResource(rawFilePath).getPath();
        File file = new File(absoluteFilePath);
        generateData4OneClass(file, file.getParentFile().getParent() + "\\" + outputFilePath);
    }

    public void generateData4AllClass (String relativeResourcePath, String outputFilePath) {
        File directory = new File(this.getClass().getClassLoader().getResource(relativeResourcePath).getFile());
        File[] files = directory.listFiles();
        for (File file: files) {
            generateData4OneClass(file, directory.getParent() + "\\" + outputFilePath);
        }
    }
}