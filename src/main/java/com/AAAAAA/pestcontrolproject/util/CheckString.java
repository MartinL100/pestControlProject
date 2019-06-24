package com.AAAAAA.pestcontrolproject.util;

public class CheckString {
    /**
     * 判断字符串是否为空
     * @param str   目标字符串
     * @return 空返回true 非空返回false
     */
    public static boolean isNull(String str){
        boolean bl = false;
        if(null==str||"".equals(str)){
            bl=true;
        }
        return bl;
    }
}
