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

    /**
     * 判断字符串是否是不为空的数字
     * @param str 目标字符串
     * @return  是数字返回ture，否则返回false
     */
    public static boolean isNum(String str){
        boolean bl = false;
        if(null==str||"".equals(str)){
            return false;
        }
        if(str.matches("[0-9]+")){
            bl=true;
        }
        return bl;
    }

    /**
     * 验证上传文件是否合法
     * @param path  文件名
     * @param beforeStrs 后缀名数组
     * @return 验证成功为true否则false
     */
    public  static boolean verifyFile(String path,String[] beforeStrs){
        boolean bl=false;
        //截取最后一个点，后面的字符串
        path=path.substring(path.lastIndexOf(".")+1,path.length());
        for (String str:beforeStrs) {
            if(str.equals(path)){
                bl=true;//如果在数组中找到后缀，就设置为true并且终止循环
                return  bl;
            }
        }

        return  bl;
    }
}
