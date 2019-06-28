package com.AAAAAA.pestcontrolproject.servlet.areaAndClassModule;

import com.AAAAAA.pestcontrolproject.entity.areaAndClassModule.SysClass;
import com.AAAAAA.pestcontrolproject.servic.areaAndClassModule.IClassServic;
import com.AAAAAA.pestcontrolproject.servic.impl.areaAndClassModule.ClassServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateClassServlet extends HttpServlet {
     IClassServic classServic=new ClassServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SysClass sysClass=new SysClass();
        sysClass.setSclassId(Long.parseLong(""));


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doPost(request,response);
    }
}
