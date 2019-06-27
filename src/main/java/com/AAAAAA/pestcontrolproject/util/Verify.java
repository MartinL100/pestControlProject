package com.AAAAAA.pestcontrolproject.util;

public class Verify {
    /**
     * 验证字符串是否为空
     * @param str
     * @return
     */
    public static   boolean verifyString(String str){
        boolean bl=false;
        if(null!=str&&!"".equals(str)) {
            bl = true;
        }
        return  bl;
    }
    /**
     * 验证字符串是否为空
     * @param strs
     * @return
     */
    public static   boolean verifyString(String...strs){
        boolean bl=true;
        for (String str:strs) {
          //只要任何一次循环为空，就改为false
            if(null==str||"".equals(str)) {
                bl = false;
                break;
            }
        }
        return  bl;
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
