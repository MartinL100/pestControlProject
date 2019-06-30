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
import java.util.List;

public class ShowClassServlet extends HttpServlet {
    IClassServic classServic= new ClassServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String classID=request.getParameter("classID");
        String updateOrLook= request.getParameter("updateOrLook");

        HashMap map=new HashMap();
        map.put("sclassId",classID);
        SysClass sysClass= classServic.findClassByClassId(map);

        request.setAttribute("classShow",sysClass);
        if("update".equals(updateOrLook)) {
            request.getRequestDispatcher("page/areaAndClassModule/UpdateClass.jsp").forward(request, response);
        }else if ("look".equals(updateOrLook)){
            request.getRequestDispatcher("page/areaAndClassModule/classShow.jsp").forward(request, response);

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doPost(request,response);
    }
}
