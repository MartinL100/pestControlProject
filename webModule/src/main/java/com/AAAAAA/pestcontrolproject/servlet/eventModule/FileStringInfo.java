package com.AAAAAA.pestcontrolproject.servlet.eventModule;

public class FileStringInfo {
    public  static  final String FILEPATH="D:/img/";
    public  static final  String  ERRORFILE="上传文件失败！！";


    /**
     * 获得新的文件名
     * @param path 原文件名
     * @return
     */
    public  static  String getNewFileName(String path){
        path=path.substring(path.lastIndexOf("."),path.length());
        return System.currentTimeMillis()+path;

    }

}
