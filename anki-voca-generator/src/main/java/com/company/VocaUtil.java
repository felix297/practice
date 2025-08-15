package com.company;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.ja.JapaneseTokenizer;
import org.apache.lucene.analysis.ja.tokenattributes.ReadingAttribute;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import java.io.IOException;
import java.io.StringReader;
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

    /**
     * 将日语文本转换为平假名
     *
     * @param text 日语文本
     * @return 平假名字符串
     */
    public static String toHiragana(String text) throws IOException {
        StringBuilder sb = new StringBuilder();

        // 使用 Lucene 的 Kuromoji Tokenizer
        JapaneseTokenizer tokenizer = new JapaneseTokenizer(null, false, JapaneseTokenizer.Mode.NORMAL);
        tokenizer.setReader(new StringReader(text));

        TokenStream ts = tokenizer;
        ts.reset();

        CharTermAttribute termAttr = ts.getAttribute(CharTermAttribute.class);
        ReadingAttribute readingAttr = ts.getAttribute(ReadingAttribute.class);

        while (ts.incrementToken()) {
            String surface = termAttr.toString(); // 原文
            String reading = readingAttr.getReading(); // 读音（カタカナ）

            if (reading != null) {
                String hira = katakanaToHiragana(reading);
                // 如果原词和读音不一样才加括号
                if (!surface.equals(hira)) {
                    sb.append(surface).append("[").append(hira).append("]");
                } else {
                    sb.append(surface);
                }
            } else {
                sb.append(surface);
            }
        }

        ts.end();
        ts.close();

        return sb.toString();
    }

    /**
     * 将片假名转换为平假名
     */
    private static String katakanaToHiragana(String katakana) {
        StringBuilder result = new StringBuilder();
        for (char c : katakana.toCharArray()) {
            if (c >= 'ァ' && c <= 'ン') {
                result.append((char) (c - 'ァ' + 'ぁ'));
            } else if (c == 'ヴ') {
                result.append('ゔ'); // 特殊处理
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}
