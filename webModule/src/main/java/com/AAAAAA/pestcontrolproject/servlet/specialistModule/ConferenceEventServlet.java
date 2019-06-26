package com.AAAAAA.pestcontrolproject.servlet.specialistModule;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ConferenceEventServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //得到事件转发过来的事件对象
        //将对象保存到数据库
        //将事件集合转发到ConferenceEvent.jsp进行初始化
        req.getRequestDispatcher("page/specialistModule/ConferenceEvent.jsp").forward(req, resp);


        //得到用户选择行的事件记录对象
        //得到事件记录对象会审的结果集合
        //将事件记录对象和结果集合转发到会审界面ConferenceMain.jsp
        req.getRequestDispatcher("page/specialistModule/ConferenceMain.jsp").forward(req, resp);
    }
}
