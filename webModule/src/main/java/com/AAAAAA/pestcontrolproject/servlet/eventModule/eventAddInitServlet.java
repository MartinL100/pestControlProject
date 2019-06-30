package com.AAAAAA.pestcontrolproject.servlet.eventModule;

import com.AAAAAA.pestcontrolproject.entity.Selected.SysSelectedType;
import com.AAAAAA.pestcontrolproject.entity.areaAndClassModule.SysArea;
import com.AAAAAA.pestcontrolproject.entity.eventModule.Event;
import com.AAAAAA.pestcontrolproject.servic.eventModule.IEventService;
import com.AAAAAA.pestcontrolproject.servic.impl.areaAndClassModule.AreaServiceImpl;
import com.AAAAAA.pestcontrolproject.servic.impl.areaAndClassModule.ClassServiceImpl;
import com.AAAAAA.pestcontrolproject.servic.impl.eventModule.EventServiceImpl;
import com.AAAAAA.pestcontrolproject.servic.impl.eventModule.FindTypeServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import java.util.*;


public class eventAddInitServlet extends HttpServlet {
    FindTypeServiceImpl servicef=new FindTypeServiceImpl();
    AreaServiceImpl areaService=new AreaServiceImpl();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Event event=new Event();

        //查询区域LIST
        Map<String,Object> map0 =new HashMap<>();
        map0.put("startIndex",266);
        map0.put("rowNum",5);
        List<SysArea> areaList =areaService.findAreaList(map0);


        //查询灾情状态集合
        Map<String,Object> map1 =new HashMap<>();
        map1.put("typeName","disasterStage");
        List<SysSelectedType> disasterStageList=servicef.findType(map1);
        Map<String,Object> map2 =new HashMap<>();
        map2.put("typeName","findWay");
        List<SysSelectedType> findWayList=servicef.findType(map2);
        Map<String,Object> map3 =new HashMap<>();
        map3.put("typeName","disasterType");
        List<SysSelectedType> disasterTypeList=servicef.findType(map3);
        request.setAttribute( "disasterTypeList",disasterTypeList);
        request.setAttribute("findWayList",findWayList);
        request.setAttribute("areaList",areaList);
        request.setAttribute("disasterStageList",disasterStageList);
         //初始化添加页面
       request.getRequestDispatcher("page/eventModule/eventAdd.jsp").forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
