package com.AAAAAA.pestcontrolproject.servlet.areaAndClassModule;

import com.AAAAAA.pestcontrolproject.entity.Selected.SysSelectedType;
import com.AAAAAA.pestcontrolproject.entity.areaAndClassModule.SysArea;
import com.AAAAAA.pestcontrolproject.entity.areaAndClassModule.SysClass;
import com.AAAAAA.pestcontrolproject.servic.areaAndClassModule.IClassServic;
import com.AAAAAA.pestcontrolproject.servic.impl.areaAndClassModule.ClassServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddClassServlet extends HttpServlet {
      IClassServic classServic= new ClassServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SysClass sysClass =new SysClass();
        SysArea sysArea=new SysArea();

        String sclassName=request.getParameter("sclassName");
        String  sclassLeaderTel=request.getParameter("sclassLeaderTel");
        String sclassLeader=request.getParameter("sclassLeader");
        String sclassNum=request.getParameter("sclassNum");
        String areaId= request.getParameter("TypeName");


        sysClass.setSclassName(sclassName);
        sysClass.setSclassLeaderTel(sclassLeaderTel);
        sysClass.setSclassLeader(sclassLeader);
        sysClass.setSclassNum(Long.parseLong(sclassNum));
        sysArea.setAreaId(Long.parseLong(areaId));
        sysClass.setArea(sysArea);





        String Strclass=classServic.addSysClass(sysClass);
        response.sendRedirect("findClassServlet");




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }
}
