package com.AAAAAA.pestcontrolproject.servlet.eventModule;

import com.AAAAAA.pestcontrolproject.entity.areaAndClassModule.SysClass;
import com.AAAAAA.pestcontrolproject.servic.impl.areaAndClassModule.ClassServiceImpl;
import com.AAAAAA.pestcontrolproject.servic.impl.eventModule.EventServiceImpl;
import com.AAAAAA.pestcontrolproject.servic.eventModule.IEventService;
import com.AAAAAA.pestcontrolproject.servic.impl.eventModule.FindTypeServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;


public class eventFindClassByAreaServlet extends HttpServlet {
    IEventService service = new EventServiceImpl();
    ClassServiceImpl classService=new ClassServiceImpl();
    FindTypeServiceImpl findTypeService=new FindTypeServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        //条件map
        Map<String,Object> map=new HashMap<>();
        String areaId=request.getParameter("areaId");
        int id=Integer.parseInt(areaId);
        SysClass aClass=  findTypeService.findClaaByAreaId(id).get(0);


        ObjectMapper objectMapper=new ObjectMapper();
        String jsonStr=objectMapper.writeValueAsString(aClass);
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        PrintWriter printWriter =response.getWriter();
        printWriter.write(jsonStr);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
