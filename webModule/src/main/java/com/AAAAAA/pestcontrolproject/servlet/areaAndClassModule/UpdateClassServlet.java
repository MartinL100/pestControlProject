package com.AAAAAA.pestcontrolproject.servlet.areaAndClassModule;

import com.AAAAAA.pestcontrolproject.entity.areaAndClassModule.SysClass;
import com.AAAAAA.pestcontrolproject.servic.areaAndClassModule.IClassServic;
import com.AAAAAA.pestcontrolproject.servic.impl.areaAndClassModule.ClassServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class UpdateClassServlet extends HttpServlet {
     IClassServic classServic=new ClassServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sclassId=request.getParameter("sclassId");
        String sclassLeader= request.getParameter("sclassLeader");
        String sclassLeaderTel=request.getParameter("sclassLeaderTel");

        HashMap map=new HashMap();
        map.put("sclassId",sclassId);
        map.put("sclassLeader",sclassLeader);
        map.put("sclassLeaderTel",sclassLeaderTel);

        String sysClass1= classServic.updateClass(map);
        request.getRequestDispatcher("page/areaAndClassModule/classPanel.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doPost(request,response);
    }
}
