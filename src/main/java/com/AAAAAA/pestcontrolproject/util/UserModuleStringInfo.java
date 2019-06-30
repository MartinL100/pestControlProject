package com.AAAAAA.pestcontrolproject.util;


import java.sql.Date;

public class UserModuleStringInfo {
    public  static String USER_IS_EXIST="该用户已存在";
    public static String PASSWORD_IS_DIFFRENT="两次输入的密码不一致，请重新输入";
    public static String ADD_SUCCESSFUL="添加成功";
    public  static String USERNAME_IS_NULL="用户名不能为空";
    public static String USER_IS_NOTEXIST="用户不存在或密码错误，请重新输入";
    public static String LOG_INFO="用户在"+new Date(System.currentTimeMillis()).toString()+"登录系统";
    public static String ADD_FAILED="添加失败，请重新添加";
    public static String UPDATE_SUCCESSFUL="修改成功";
    public static String UPDATE_FAILED="修改失败，请重新修改";
    public static String FILE_ISNOT_ALLOWED="图片格式不支持，请重新添加";
}
