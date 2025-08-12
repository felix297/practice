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
     * 判断一个字符是否是日语假名（全角平假名或片假名）
     * @param c 待判断的字符
     * @return 判断结果
     */
    private boolean isKana(char c) {
        Character.UnicodeBlock block = Character.UnicodeBlock.of(c);
        return block == Character.UnicodeBlock.HIRAGANA || isKatakana(c);
    }

    /**
     * 判断一个字符是否是日语片假名
     * @param c 待判断的字符
     * @return 判断结果
     */
    private boolean isKatakana (char c) {
        Character.UnicodeBlock block = Character.UnicodeBlock.of(c);
        return block == Character.UnicodeBlock.KATAKANA
                || block == Character.UnicodeBlock.KATAKANA_PHONETIC_EXTENSIONS;
    }

    /**
     * 判读一个字符串是否为空
     * @param str 待判断字符串
     * @return 判断结果
     */
    private boolean isEmptyStr(String str) {
        return str == null || str.isEmpty();
    }

    /**
     * 判断一个字符是否为符号
     * @param c 待判断的字符
     * @return 判断结果
     */
    private boolean isSymbol(char c){
        int type = Character.getType(c);
        return type == Character.SPACE_SEPARATOR ||
                type == Character.LINE_SEPARATOR ||
                type == Character.PARAGRAPH_SEPARATOR ||
                type == Character.DASH_PUNCTUATION ||
                type == Character.START_PUNCTUATION ||
                type == Character.END_PUNCTUATION ||
                type == Character.CONNECTOR_PUNCTUATION ||
                type == Character.OTHER_PUNCTUATION ||
                type == Character.MATH_SYMBOL ||
                type == Character.CURRENCY_SYMBOL ||
                type == Character.MODIFIER_SYMBOL ||
                type == Character.OTHER_SYMBOL;
    }

    /**
     * 判断一个字符串是否全为日语片假名(外来语)
     * @param str 待判断的字符串
     * @return 判断结果
     */
    private boolean isAllKatakanaIgnoreSymbols(String str) {
        if (isEmptyStr(str)) {
            return false;
        }
        for (char c : str.toCharArray()) {
            // 跳过空格和各种符号
            if (isSymbol(c) || isEnLetter(c) || Character.isDigit(c)) {
                continue; // 忽略符号
            }
            if (!isKatakana(c)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断一个字符是否为英文字母
     * @param c 待判断的字符
     * @return 判断结果
     */
    private boolean isEnLetter (char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }

    /**
     * 判断一个字符串是否全为日语假名(否是需要汉字到假名)
     * @param str 待判断的字符串
     * @return 判断结果
     */
    private boolean isAllKanaIgnoreSymbols(String str) {
        if (isEmptyStr(str)) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (isSymbol(c) || isEnLetter(c) || Character.isDigit(c)) {
                continue; // 忽略符号
            }
            if (!isKana(c)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 给汉字前面添加一个空格，后面添加 "[]"
     * @param containsKanji 是否包含汉字
     * @param nihongo 日语
     * @return 加了空格和 "[]"之后的日语
     */
    private String addSquareAfterKanji (boolean containsKanji, String nihongo) {
        if (!containsKanji) {
            return nihongo;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char ch: nihongo.toCharArray()) {
            if (!(isKana(ch) || isSymbol(ch) || isEnLetter(ch) || Character.isDigit(ch))) {
                stringBuilder.append(" ");
                stringBuilder.append(ch);
                stringBuilder.append("[]");
                continue;
            }
            stringBuilder.append(ch);
        }
        return stringBuilder.toString();
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
                if (strArr.length != 5) {
                    System.out.println("Wrong colume number at line " + count + " !");
                    continue;
                }
                String nihongo = strArr[0];
                boolean containsKanji = !isAllKanaIgnoreSymbols(nihongo);
                String isKanji2Kana = containsKanji?"1":"0";
                Tango tango = new Tango(addSquareAfterKanji(containsKanji, nihongo), strArr[3], isAllKatakanaIgnoreSymbols(nihongo)?"1":"0", isKanji2Kana, strArr[4], rawFile.getName().substring(0, 6) + "_" + count + ".mp3");
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