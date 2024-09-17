package com.company;

import org.junit.Test;

public class Application {
    @Test
    public void run () {
        System.out.println(myAtoi("20000000000000000000"));
        Integer
    }

    public int myAtoi(String s) {
        // skip the prefix space
        int fromIndex = 0;
        int endIndex = 0;

        fromIndex = getFromIndex(s, ' ', fromIndex);

        int sign = isDigitOrSign(s, fromIndex);
        if (sign != -2) {
            if (sign != 2) {
                fromIndex++;
            }
            endIndex = getEndIndex(s, fromIndex);
            return getRangedNumber(s, fromIndex, endIndex, sign);
        } else {
            return 0;
        }
    }

    public boolean isDigit (String str, int index) {
        return str.charAt(index) >= 48 && str.charAt(index) <= 57;
    }

    public int isDigitOrSign (String str, int index) {
        char letter = str.charAt(index);

        if (letter == 43) {
            return 1;
        }

        if (letter == 45) {
            return -1;
        }

        if (isDigit(str, index)) {
            return 2;
        }

        return -2;
    }

    public int getFromIndex (String str, char skipLetter, int fromIndex) {
        int index = fromIndex;
        int length = str.length();
        while (index < length && str.charAt(index) == skipLetter) {
            index++;
        }

        return index;
    }

    /**
     endIndex: excluded
     */
    public int getEndIndex (String str, int fromIndex) {
        int index = fromIndex;
        int length = str.length();

        while (index < length && isDigit(str, index)) {
            index++;
        }

        return index;
    }

    public int getRangedNumber (String str, int fromIndex, int endIndex, int sign) {
        long res = 0L;
        int lowerBound = - (int) Math.pow(2, 31) - 1;
        int upperBound = (int) Math.pow(2, 31);

        fromIndex = getFromIndex(str, '0', fromIndex);
        StringBuilder numberString = new StringBuilder(str.substring(fromIndex, endIndex));
        int length = numberString.length();

        if (length > 12) {
            if (sign > 0) {
                return upperBound;
            } else {
                return lowerBound;
            }
        }


        for (int index = 0; index < length; index++) {
            int digit = numberString.charAt(length - index - 1) - '0';
            res = res + digit * (long) Math.pow(10, index);
        }

        res = res * sign;

        if (res < lowerBound) {
            return lowerBound;
        }

        if (res > upperBound) {
            return upperBound;
        }

        return (int)res;
    }
}