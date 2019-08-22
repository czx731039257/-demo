package com.csx.demo2.entity;

public class StringUtils {

    public static boolean isNoBlank(String str){
        if(str==null||"".equals(str)){
            return false;
        }
        return true;
    }
}
