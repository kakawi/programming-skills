package com.hlebon.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 */
public class RomanToInteger {

    public static void main(String[] args) {
        RomanToInteger romanToInteger = new RomanToInteger();
        System.out.println(romanToInteger.romanToInt("III"));
        System.out.println(romanToInteger.romanToInt("LVIII"));
        System.out.println(romanToInteger.romanToInt("MCMXCIV"));
    }

    public int romanToInt(String s) {
        int result = 0;
        char[] chars = s.toCharArray();
        int prev = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            int currentNumber = getNumber(chars[i]);
            if (currentNumber < prev) {
                result -= currentNumber;
            } else {
                result += currentNumber;
            }
            prev = currentNumber;
        }

        return result;
    }

    private int getNumber(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
