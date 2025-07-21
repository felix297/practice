package com.company;

import java.util.Objects;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class VocaGenerator {
    private void verifyFile (File file) {
        if (!file.exists()) {
            try {
                file.createNewFile();
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

    public void generateData4OneClass (File srcFile, String outputFilePath) {
        verifyFile(srcFile);
        try (BufferedReader reader = new BufferedReader(new FileReader(srcFile))) {
            String line;
            int count = 1;
            while (!Objects.isNull(line = reader.readLine())) {
                String[] strArr = line.split(",");
                Tango tango = new Tango(strArr[0], strArr[1], strArr[2], strArr[3], srcFile.getName().substring(0, 6) + "_" + count + ".mp3");
                writeLineIntoFile(outputFilePath, tango.toString());
                System.out.println("Word " + count + " is inserted!");
                count++;
            }
        } catch (IOException e) {
            System.out.println("Error when reading source data file <" + srcFile.getAbsolutePath() + ">");
            e.printStackTrace();
        }
    }

    public void generateData4AllClass (String relativeResourcePath, String outputFilePath) {
        File directory = new File(this.getClass().getClassLoader().getResource(relativeResourcePath).getFile());
        File[] files = directory.listFiles();
        for (File file: files) {
            generateData4OneClass(file, directory.getParent() + "\\" + outputFilePath);
        }
    }
}