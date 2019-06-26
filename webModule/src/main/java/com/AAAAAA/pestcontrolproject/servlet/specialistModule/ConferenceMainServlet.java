package com.AAAAAA.pestcontrolproject.servlet.specialistModule;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ConferenceMainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //点击添加会审结果：
        //得到页面数据：事件ID、当前时间、专家、防治方案。
        //根据事件ID保存事件结果到数据库
        //转发到ConferenceMain.jsp


        //点击返回
        //重定向到ConferenceEvent.jsp
    }
}
