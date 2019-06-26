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

public class eventFindServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IEventService service = new EventServiceImpl();

        request.setCharacterEncoding("UTF-8");
        Map<String,Object> map=new HashMap<>();
        System.out.println(request.getParameter("areaId"));
        String areaId=request.getParameter("areaId");
        String disasterStage=request.getParameter("disasterStage");
        // 区域id不为空
        if(areaId!=null&&areaId.length()>0){
            map.put("areaId",Integer.parseInt(areaId));
        }
        // 灾害阶段id不为空
        if(disasterStage!=null&&disasterStage.length()>0){
            map.put("disasterStage",Integer.parseInt(disasterStage));
        }
        map.put("eventName",request.getParameter("eventName"));
        map.put("startTime",request.getParameter("startTime"));
        map.put("endTime",request.getParameter("endTime"));
        System.out.println();
        //查找所有事件对象集合
        List<Event> eventsList =service.findAllByMap(map);
        //将集合放入request
        System.out.println("find"+eventsList.toString());

        //list转换为json格式字符串
        ObjectMapper objectMapper=new ObjectMapper();
        String jsonStr= objectMapper.writeValueAsString(eventsList);
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        PrintWriter printWriter =response.getWriter();
        printWriter.write(jsonStr);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
