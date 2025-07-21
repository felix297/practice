package com.company;

public class Main {
    // default value
    static byte byteValue;
    static short shortValue;
    static int intValue;
    static long longValue;
    static float floatValue;
    static double doubleValue;
    static char charValue;
    static boolean booleanValue;

    public static void main (String[] args) {
//        valueRange();
//        defaultValue();
//        referenceType();
//        constant();
//        radix();
        escapeChar();

    }

    public static void escapeChar () {
        String sentence = "\nline one\rline two\fline three\bline four\0line five\tline six\"line seven\\line eight\77line nine";
        System.out.println(sentence);
    }

    public static void radix () {
        int radixEight = 011;
        int radixSixteen = 0x11;

        System.out.println("radix eight: " + radixEight);
        System.out.println("radix sixteen: " + radixSixteen);
    }

    public static void constant () {
        final double PI = 3.14159;
        System.out.println(PI);
//        PI = 3;
//        System.out.println(PI);
    }

    public static void referenceType () {
        ReferenceType referenceType;
//        System.out.println(referenceType.toString());
    }

    public static void valueRange() {
        // value range
        System.out.println("----BYTE----");
        System.out.println("Size: " + Byte.SIZE);
        System.out.println("Max value: " + Byte.MAX_VALUE);
        System.out.println("Minimum value: " + Byte.MIN_VALUE);
        System.out.println("----SHORT----");
        System.out.println("Size: " + Short.SIZE);
        System.out.println("Maximum Value: " + Short.MAX_VALUE);
        System.out.println("Minimum Value: " + Short.MIN_VALUE);
        System.out.println("----INT----");
        System.out.println("Size: " + Integer.SIZE);
        System.out.println("Maximum Value: " + Integer.MAX_VALUE);
        System.out.println("Minimum Value: " + Integer.MIN_VALUE);
        System.out.println("----LONG----");
        System.out.println("Size: " + Long.SIZE);
        System.out.println("Maximum Value: " + Long.MAX_VALUE);
        System.out.println("Minimum Value: " + Long.MIN_VALUE);
        System.out.println("----FLOAT----");
        System.out.println("Size: " + Float.SIZE);
        System.out.println("Maximum Value: " + Float.MAX_VALUE);
        System.out.println("Minimum Value: " + Float.MIN_VALUE);
        System.out.println("----DOUBLE----");
        System.out.println("Size: " + Double.SIZE);
        System.out.println("Maximum Value: " + Double.MAX_VALUE);
        System.out.println("Minimum Value: " + Double.MIN_VALUE);
        System.out.println("----CHAR----");
        System.out.println("Size: " + Character.SIZE);
        System.out.println("Maximum Value: " + Character.MAX_VALUE);
        System.out.println("Minimum Value: " + Character.MIN_VALUE);
    }

    public static void defaultValue () {
        // default value
        System.out.println("byteValue: " + byteValue);
        System.out.println("shortValue: " + shortValue);
        System.out.println("intValue: " + intValue);
        System.out.println("longValue: " + longValue);
        System.out.println("floatValue: " + floatValue);
        System.out.println("doubleValue: " + doubleValue);
        System.out.println("charValue: " + charValue);
        System.out.println("booleanValue: " + booleanValue);
    }
}