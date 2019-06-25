package com.AAAAAA.pestcontrolproject.servlet.drugModule;

import com.AAAAAA.pestcontrolproject.entity.Selected.SysSelectedType;
import com.AAAAAA.pestcontrolproject.service.selectedType.ISelectedTypeService;
import com.AAAAAA.pestcontrolproject.service.selectedType.impl.SelectedTypeImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class outwarehouseAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String tag=request.getParameter("");
        ISelectedTypeService typeService=new SelectedTypeImpl();
    if(null==tag||"".equals(tag)){
        //得到班级下拉框所有
        List<SysSelectedType> Classlist=typeService.getAllClass();
        request.setAttribute("ClassNameList",Classlist);
        request.setAttribute("userObj",request.getSession().getAttribute("userObj"));
       //转发
        request.getRequestDispatcher("page/drugModule/outwarehouseAdd.jsp").forward(request,response);
    }
    else{

    }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doPost(request,response);
    }
}
