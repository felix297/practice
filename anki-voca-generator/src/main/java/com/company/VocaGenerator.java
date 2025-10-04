package com.company;

import java.util.Objects;
import java.io.*;

/**
 * 卡组来源
 * 大家的日本语 中级 1：https://ankiweb.net/shared/info/150726161 : 注意导出原始数据时要选上“标签”
 * JLPT 词汇：https://ankiweb.net/shared/info/832276382 : 注意导出时要选上“标签”
 */
public class VocaGenerator {
    private final String resourcePath = "src/main/resources/";
    private final String outputDir = resourcePath + "output/";
    private final String rawFileDir = resourcePath + "rawVoca/";
    /**
     * 卡组 https://ankiweb.net/shared/info/150726161 中的 tag 数量
     */
    private final int tabNum_150726161 = 5;
    /**
     * 卡组 https://ankiweb.net/shared/info/832276382 中的 tag 数量
     */
    private final int tabNum_832276382 = 39;

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
    private String addFurikana(boolean containsKanji, String nihongo) throws IOException {
        if (!containsKanji) {
            return nihongo;
        }
        char[] nihongo2addQuareArr = VocaUtil.toHiragana(nihongo).toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int index = 0; index < nihongo2addQuareArr.length; index++){
            char ch = nihongo2addQuareArr[index];
            if (!(isKana(ch) || isSymbol(ch) || isEnLetter(ch) || Character.isDigit(ch))) {
                stringBuilder.append(" ");
                stringBuilder.append(ch);
                if (index == nihongo2addQuareArr.length - 1 || nihongo2addQuareArr[index + 1] != '[') {
                    stringBuilder.append("[]");
                }
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
            VocaUtil.isFileExists(rawFile, "Raw File is not exists!");
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

        try(BufferedReader reader = new BufferedReader(new FileReader(rawFile))) {
            String line;
            int count = 1;
            while (Objects.nonNull(line = reader.readLine())) {
                String[] strArr = line.split("\t");
                if (strArr.length != tabNum_150726161 && strArr.length != tabNum_832276382) {
                    System.out.println("Wrong colume number at line " + count + " !");
                    continue;
                }
                if (strArr.length == tabNum_150726161) {
                    String nihongo = strArr[0];
                    boolean containsKanji = !isAllKanaIgnoreSymbols(nihongo);
                    String isKanji2Kana = containsKanji?"1":"0";
                    boolean isAllKatakana = isAllKatakanaIgnoreSymbols(nihongo);
                    String luomaji = isAllKatakana?"1":"0";
                    String rawFileName = rawFile.getName();
                    String audioFileName = rawFileName.split("\\.")[0] + "_" + count + ".mp3";
                    Tango tango = new Tango(addFurikana(containsKanji, nihongo),
                            strArr[3],
                            luomaji,
                            isKanji2Kana,
                            strArr[4],
                            audioFileName);
                    VocaUtil.writeLineIntoFile(outputFilePath, tango.toString());
                    count++;
                }
                if (strArr.length == tabNum_832276382) {
                    String nihongo = strArr[1];
                    boolean containsKanji = !isAllKanaIgnoreSymbols(nihongo);
                    String isKanji2Kana = containsKanji?"1":"0";
                    boolean isAllKatakana = isAllKatakanaIgnoreSymbols(nihongo);
                    String luomaji = isAllKatakana?strArr[4]:"0";
                    Tango tango = new Tango(addFurikana(containsKanji, nihongo),
                            strArr[6],
                            luomaji,
                            isKanji2Kana,
                            strArr[3],
                            strArr[7],
                            strArr[2]);
                    VocaUtil.writeLineIntoFile(outputFilePath, tango.toString());
                    String kanaFilePath = outputDir + "kana_" + new File(outputFilePath).getName();
                    VocaUtil.writeLineIntoFile(kanaFilePath, strArr[4] + "\n");
                    count++;
                }
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