package com.alibaba.android.arouter.compiler.utils;

/**
 * Author: lingquan(lingquan@yy.com)
 * Date : 2017/11/9
 * Description : This is a description example
 */

public class TextUtils {
    /**
     * Returns true if the string is null or 0-length.
     * @param str the string to be examined
     * @return true if str is null or zero length
     */
    public static boolean isEmpty(CharSequence str) {
        if (str == null || str.length() == 0)
            return true;
        else
            return false;
    }
}
