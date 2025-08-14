package com.company;

public class Tango {
    private String nihongo;
    private String lomaji; // 是否是外来语
    private String chinese;
    private String audio;
    private String isKanji2Kana; // 是否需要汉字到假名
    private String isSmallNihongo = "";
    private String isSmallKana = "";
    private String isSmallChinese = "";
    private String yinhe = "";
    private String cixing = "";
    private String jibenxing = "";
    private String biaoqian = "";

    public Tango() {
    }

    public Tango(String nihongo, String chinese, String lomaji, String isKanji2Kana, String audioFileName) {
        this.nihongo = nihongo;
        this.lomaji = lomaji.equals("0") ? "" : lomaji;
        this.chinese = chinese;
        this.audio = "[sound:" + audioFileName + "]";
        this.isKanji2Kana = isKanji2Kana.equals("0") ? "" : isKanji2Kana;
    }

    public Tango(String nihongo, String chinese, String lomaji, String isKanji2Kana, String cixing, String audioFileName) {
        this.nihongo = nihongo;
        this.lomaji = lomaji.equals("0") ? "" : lomaji;
        this.chinese = chinese;
        this.cixing = cixing;
        this.audio = "[sound:" + audioFileName + "]";
        this.isKanji2Kana = isKanji2Kana.equals("0") ? "" : isKanji2Kana;
    }

    public Tango(String nihongo, String chinese, String lomaji, String isKanji2Kana, String cixing, String audioFileName, String yinhe) {
        this.nihongo = nihongo;
        this.lomaji = lomaji.equals("0") ? "" : lomaji;
        this.chinese = chinese;
        this.cixing = cixing;
        this.audio = audioFileName;
        this.isKanji2Kana = isKanji2Kana.equals("0") ? "" : isKanji2Kana;
        this.yinhe = yinhe;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(this.nihongo).append(",")
                .append(this.yinhe).append(",")
                .append(this.cixing).append(",")
                .append(this.jibenxing).append(",")
                .append(this.lomaji).append(",")
                .append(this.chinese).append(",")
                .append(this.audio).append(",")
                .append(this.isKanji2Kana).append(",")
                .append(this.isSmallNihongo).append(",")
                .append(this.isSmallKana).append(",")
                .append(this.isSmallChinese).append(",")
                .append(this.biaoqian).append("\n");
        return res.toString();
    }
}