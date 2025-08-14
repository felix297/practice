package com.company;

import java.io.*;

public class VocaUtil {
    /**
     * 验证文件是否存在，不存在则创建
     * @param file 要验证的文件
     */
    public static void isFileExistsNCreate (File file) {
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
    public static void isFileExists (File file, String msg) throws FileNotFoundException {
        if (!file.exists()) {
            throw new FileNotFoundException();
        }
    }

    /**
     * 写入一行数据到目标文件中
     * @param outputFilePath 目标文件
     * @param content 写入内容
     */
    public static void writeLineIntoFile (String outputFilePath, String content) {
        File file = new File(outputFilePath);
        isFileExistsNCreate(file);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath, true))) {
            writer.append(content);
        } catch (IOException e) {
            System.out.println("Error when writing into target file <" + file.getAbsolutePath() + ">");
            e.printStackTrace();
        }
    }
}
