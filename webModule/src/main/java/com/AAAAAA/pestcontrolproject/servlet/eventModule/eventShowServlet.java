package com.AAAAAA.pestcontrolproject.servlet.eventModule;

import com.AAAAAA.pestcontrolproject.entity.eventModule.Event;
import com.AAAAAA.pestcontrolproject.servic.eventModule.EventServiceImpl;
import com.AAAAAA.pestcontrolproject.servic.eventModule.IEventService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class eventShowServlet extends HttpServlet {
    IEventService service = new EventServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        Map<String,Object> map=new HashMap<>();
        int eventId=Integer.parseInt(request.getParameter("eventId"));
        map.put("eventId",eventId);

        //查找所有事件对象集合
        List<Event> eventsList =service.findAllByMap(map);

        Event event=eventsList.get(0);

        //将对象放入request
        request.setAttribute("event",event);

        //判段是修改请求还是查看信息请求
        String showOrUpdate=request.getParameter("showOrUp");
        if("show".equals(showOrUpdate)){
            request.getRequestDispatcher("page/eventModule/eventShow.jsp").forward(request,response);
        }
        else if("update".equals(showOrUpdate)){
        // 请求转发到更新页面
            request.getRequestDispatcher("page/eventModule/eventUpdate.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
