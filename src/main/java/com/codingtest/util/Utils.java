package com.codingtest.util;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Utils {
    public static boolean isPositiveNumber(String strNum) {
        try {
            int value = Integer.parseInt(strNum);
            if(value < 0) {
                return false;
            }
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
