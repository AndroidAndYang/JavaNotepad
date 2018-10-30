package com.yjz.notepad.util;

/**
 * author： YJZ
 * date:  2018/10/30
 * des:
 */
public class StringUtil {

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0 || str.trim().length() == 0;
    }
}
