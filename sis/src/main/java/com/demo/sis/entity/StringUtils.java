package com.demo.sis.entity;

public class StringUtils {

    public static boolean isNoBlank(String str) {
        if (str == null || "".equals(str)) {
            return false;
        }
        return true;
    }
}
