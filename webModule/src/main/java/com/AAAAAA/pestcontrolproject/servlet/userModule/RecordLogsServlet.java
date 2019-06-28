package com.AAAAAA.pestcontrolproject.servlet.userModule;

import com.AAAAAA.pestcontrolproject.entity.userModule.TLog;
import com.AAAAAA.pestcontrolproject.servic.impl.userModule.LogServicImpl;
import com.AAAAAA.pestcontrolproject.servic.userModule.ILogSevice;
import com.AAAAAA.pestcontrolproject.util.SplitPage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecordLogsServlet extends HttpServlet {
    ILogSevice logSevice = new LogServicImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map map=new HashMap();
       //获取查询条件
        String startTime=request.getParameter("startTime");
        String endTime=request.getParameter("endTime");
        map.put("startTime",startTime);
        map.put("endTime",endTime);
        //获取操作标记
        String tag=request.getParameter("tag");
        //获取前端传递的当前页
        String currentPage=request.getParameter("currentPage");
        //查找总行数
        int rows=logSevice.countLogs(map);

        Map splitPageMap= SplitPage.SplitPage(currentPage,tag,5,rows);
        map.putAll(splitPageMap);
       List<TLog> logList= logSevice.findLogsList(map);
        request.setAttribute("logList",logList);
        request.setAttribute("maxPage",map.get("maxPage"));
        request.setAttribute("currentPage",map.get("newCurrentPage"));
        request.setAttribute("startTime",startTime);
        request.setAttribute("endTime",endTime);
        request.getRequestDispatcher("page/userModule/logs.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
