package com.AAAAAA.pestcontrolproject.servlet.eventModule;

import com.AAAAAA.pestcontrolproject.entity.areaAndClassModule.SysArea;
import com.AAAAAA.pestcontrolproject.entity.eventModule.Event;
import com.AAAAAA.pestcontrolproject.servic.eventModule.EventServiceImpl;
import com.AAAAAA.pestcontrolproject.servic.eventModule.IEventService;
import com.AAAAAA.pestcontrolproject.util.SplitPage;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class eventFindServlet extends HttpServlet {
    IEventService service = new EventServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        //条件map
        Map<String,Object> map=new HashMap<>();
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
        //查找所有事件对象集合
        List<Event> eventsList =service.findAllByMap(map);
        //分页显示
        int allRows=eventsList.size();
        String currentPageString=request.getParameter("currentPage");
        String pageTag=request.getParameter("pageTag");
        Map<String,Object> mapSplit= SplitPage.SplitPage(currentPageString,pageTag,5,allRows );
        map.put("startIndex",mapSplit.get("startIndex"));
        eventsList =service.findAllByMap(map);
        String maxPage=mapSplit.get("maxPage").toString();
        String currentPage=mapSplit.get("newCurrentPage").toString();

        //查询区域LIST
        //封装页面显示的数据进入map集合
        List<SysArea> areaList=new ArrayList<>();
        for (int i=1;i<4;i++){
            SysArea area=new SysArea();
            area.setAreaId(i);
            area.setAreaName("四川"+i+"区");
            areaList.add(area);
        }




        Map<String,Object> eventsMap=new HashMap<>();
        eventsMap.put("areaList",areaList);
        eventsMap.put("eventsList",eventsList);
        eventsMap.put("maxPage",maxPage);
        eventsMap.put("currentPage",currentPage);
        //list转换为json格式字符串
        ObjectMapper objectMapper=new ObjectMapper();

        String jsonStr= objectMapper.writeValueAsString(eventsMap);
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        PrintWriter printWriter =response.getWriter();
        printWriter.write(jsonStr);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
