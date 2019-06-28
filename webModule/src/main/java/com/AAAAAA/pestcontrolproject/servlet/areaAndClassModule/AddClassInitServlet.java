package com.AAAAAA.pestcontrolproject.servlet.areaAndClassModule;

import com.AAAAAA.pestcontrolproject.entity.Selected.SysSelectedType;
import com.AAAAAA.pestcontrolproject.servic.areaAndClassModule.IClassServic;
import com.AAAAAA.pestcontrolproject.servic.impl.areaAndClassModule.ClassServiceImpl;
import com.AAAAAA.pestcontrolproject.service.selectedType.ISelectedTypeService;
import com.AAAAAA.pestcontrolproject.service.selectedType.impl.SelectedTypeImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AddClassInitServlet extends HttpServlet {
        IClassServic classServic =new ClassServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ISelectedTypeService selectedTypeService = new SelectedTypeImpl();
        List<SysSelectedType> sysSelectedTypeslist= selectedTypeService.getSelectValueListByTypeName("QY");

        request.setAttribute("classList",sysSelectedTypeslist);
        request.getRequestDispatcher("page/areaAndClassModule/classAdd.jsp").forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             doPost(request,response);
    }
}
