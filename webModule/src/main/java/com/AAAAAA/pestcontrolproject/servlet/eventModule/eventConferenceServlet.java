package com.AAAAAA.pestcontrolproject.servlet.eventModule;

import com.AAAAAA.pestcontrolproject.entity.eventModule.Event;
import com.AAAAAA.pestcontrolproject.servic.impl.eventModule.AddConfServiceImpl;
import com.AAAAAA.pestcontrolproject.servic.impl.eventModule.EventServiceImpl;
import com.AAAAAA.pestcontrolproject.servic.eventModule.IEventService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class eventConferenceServlet extends HttpServlet {
    IEventService service = new EventServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String eventId=request.getParameter("eventId");
//        添加事件id到事件会商中间表
        AddConfServiceImpl addConfService=new AddConfServiceImpl();
        addConfService.addConf(Integer.parseInt(eventId));
        Map<String,Object> map=new HashMap<>();
        map.put("eventId",eventId);
        List<Event> eventList=service.findAllByMap(map);
         request.setAttribute("eventObj",eventList.get(0));
         request.getRequestDispatcher("conferenceMain").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
