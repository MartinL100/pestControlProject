package com.AAAAAA.pestcontrolproject.servlet.eventModule;

import com.AAAAAA.pestcontrolproject.entity.eventModule.Event;
import com.AAAAAA.pestcontrolproject.entity.userModule.TRole;
import com.AAAAAA.pestcontrolproject.servic.eventModule.EventServiceImpl;
import com.AAAAAA.pestcontrolproject.servic.eventModule.IEventService;
import com.AAAAAA.pestcontrolproject.util.SplitPage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class eventMainServlet extends HttpServlet {
    IEventService service = new EventServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Map<String,Object> map=new HashMap<>();
        //查找所有事件对象集合
        List<Event> eventsList =service.findAllByMap(map);
        //分页显示
       int allRows=eventsList.size();
       String currentPageString=null;
       String pageTag=null;
       Map<String,Object> mapSplit=SplitPage.SplitPage(currentPageString,pageTag,5,allRows );
       map.put("startIndex",mapSplit.get("startIndex"));
        //查找分页对象集合
        List<Event> eventsSplit =service.findAllByMap(map);
        //将集合放入request
        request.setAttribute("currentPage",1);
        request.setAttribute("maxPage",mapSplit.get("maxPage"));
        request.setAttribute("eventsList",eventsSplit);
        request.getRequestDispatcher("page/eventModule/eventMain.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
