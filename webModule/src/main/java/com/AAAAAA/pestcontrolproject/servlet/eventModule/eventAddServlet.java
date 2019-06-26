package com.AAAAAA.pestcontrolproject.servlet.eventModule;

import com.AAAAAA.pestcontrolproject.entity.eventModule.Event;
import com.AAAAAA.pestcontrolproject.servic.eventModule.EventServiceImpl;
import com.AAAAAA.pestcontrolproject.servic.eventModule.IEventService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class eventAddServlet extends HttpServlet {
    IEventService service = new EventServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        System.out.println(111);
        Event event=new Event();
        event.setAreaId(Integer.parseInt(request.getParameter("areaId")));
        event.setClassId(Integer.parseInt(request.getParameter("classId")));
        event.setDisasterStage(Integer.parseInt(request.getParameter("disasterStage")));
        event.setDisasterType(Integer.parseInt(request.getParameter("disasterType")));
        event.setEventArea(request.getParameter("eventArea"));
        event.setEventDescribe(request.getParameter("eventDescribe"));
        event.setEventLoss(request.getParameter("eventLoss"));
        event.setEventName(request.getParameter("eventName"));
        event.setFindWay(Integer.parseInt(request.getParameter("findWay")));
        event.setOccurTime(request.getParameter("occurTime"));
        event.setPhotoPath(request.getParameter("photoPath"));
        event.setPlan(request.getParameter("plan"));

        System.out.println(event.toString());

        // 将添加对象加入数据库
//        service.eventAdd(event);

        //返回事件主页面
        request.getRequestDispatcher("page/eventModule/eventMain.jsp").forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
