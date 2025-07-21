package com.company;

public class Tango {
    private String nihongo;
    private String lomaji;
    private String chinese;
    private String audio;
    private String isKanji2Kana;
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