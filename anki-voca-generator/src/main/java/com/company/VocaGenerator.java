package com.company;

import java.util.Objects;
import java.io.*;

public class VocaGenerator {
    private final String resourcePath = "src/main/resources/";
    private final String outputDir = resourcePath + "output/";
    private final String rawFileDir = resourcePath + "rawVoca/";

    /**
     * 验证文件是否存在，不存在则创建
     * @param file 要验证的文件
     */
    private void isFileExistsNCreate (File file) {
        if (!file.exists()) {
            System.out.println("Target written file is not existed, creating it");
            try {
                if (!file.createNewFile()) {
                    throw new IOException();
                }
            } catch (IOException e) {
                System.out.println("Error when creating target file <" + file.getAbsolutePath() + ">");
                e.printStackTrace();
            }
        }
    }

    /**
     * 验证文件是否存在
     * @param file 要验证的文件
     */
    private void isFileExists (File file, String msg) throws FileNotFoundException {
        if (!file.exists()) {
            throw new FileNotFoundException();
        }
    }

    /**
     * 写入一行数据到目标文件中
     * @param outputFilePath 目标文件
     * @param content 写入内容
     */
    private void writeLineIntoFile (String outputFilePath, String content) {
        File file = new File(outputFilePath);
        isFileExistsNCreate(file);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath, true))) {
            writer.append(content);
        } catch (IOException e) {
            System.out.println("Error when writing into target file <" + file.getAbsolutePath() + ">");
            e.printStackTrace();
        }
    }

    /**
     * 将原生数据处理为目标格式数据，写入目标文件中
     * @param rawFile 原生数据文件
     * @param outputFilePath 目标文件
     */
    private boolean generateData4OneClass (File rawFile, String outputFilePath) {
        try {
            isFileExists(rawFile, "Raw File is not exists!");
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

        try(BufferedReader reader = new BufferedReader(new FileReader(rawFile))) {
            String line;
            int count = 1;
            while (Objects.nonNull(line = reader.readLine())) {
                String[] strArr = line.split("\t");
                if (strArr.length != 7) {
                    System.out.println("Wrong colume number at line " + count + " !");
                    continue;
                }
                Tango tango = new Tango(strArr[2], strArr[5], strArr[0], strArr[1], strArr[6], rawFile.getName().substring(0, 6) + "_" + count + ".mp3");
                writeLineIntoFile(outputFilePath, tango.toString());
                count++;
            }
            return true;
        } catch (IOException e) {
            System.out.println("Error when reading raw file!");
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 将原生数据处理为目标格式数据，写入目标文件中
     * @param rawFileName 原生数据文件名
     */
    private boolean generateData4OneClass (String rawFileName) {
        File file = new File(rawFileDir + rawFileName);
        return generateData4OneClass(file, outputDir + "Anki_" + rawFileName);
    }

    /**
     * 处理存放原生数据的文件夹下的所有文件
     */
    public void generateData4AllClass () {
        File directory = new File(rawFileDir);
        File[] files = directory.listFiles();

        if (Objects.isNull(files) || files.length == 0) {
            System.out.println("Raw File Directory is empty or it's a non-existed directory!");
            return ;
        }

        for (File file: files) {
            if (generateData4OneClass(file.getName())) {
                System.out.println(file.getName() + " is processed successfully!");
            }
        }
    }
}