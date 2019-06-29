package com.AAAAAA.pestcontrolproject.servlet.eventModule;

import com.AAAAAA.pestcontrolproject.entity.Selected.SysSelectedType;
import com.AAAAAA.pestcontrolproject.entity.areaAndClassModule.SysArea;
import com.AAAAAA.pestcontrolproject.entity.eventModule.Event;
import com.AAAAAA.pestcontrolproject.servic.impl.eventModule.EventServiceImpl;
import com.AAAAAA.pestcontrolproject.servic.eventModule.IEventService;
import com.AAAAAA.pestcontrolproject.servic.impl.eventModule.FindTypeServiceImpl;
import com.AAAAAA.pestcontrolproject.util.SplitPage;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

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
    FindTypeServiceImpl servicef=new FindTypeServiceImpl();
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
        //  判断日期格式
        String startTime= request.getParameter("startTime");
        String endTime=request.getParameter("endTime");
        String regexTime="(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)";
        if(startTime!=null&&startTime.length()>0&&!startTime.matches(regexTime)){
            return;
        }
        if (endTime!=null&&endTime.length()>0&&!endTime.matches(regexTime)){
          return;
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
        //查询灾情状态集合
        Map<String,Object> map1 =new HashMap<>();
        map1.put("typeName","disasterStage");
        List<SysSelectedType> disasterStageList=servicef.findType(map1);

        Map<String,Object> eventsMap=new HashMap<>();
        eventsMap.put("disasterStageList",disasterStageList);
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
