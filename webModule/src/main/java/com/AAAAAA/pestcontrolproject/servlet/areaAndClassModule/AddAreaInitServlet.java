package com.AAAAAA.pestcontrolproject.servlet.areaAndClassModule;

import com.AAAAAA.pestcontrolproject.entity.Selected.SysSelectedType;
import com.AAAAAA.pestcontrolproject.entity.areaAndClassModule.SysArea;
import com.AAAAAA.pestcontrolproject.entity.areaAndClassModule.SysClass;
import com.AAAAAA.pestcontrolproject.entity.userModule.TRole;
import com.AAAAAA.pestcontrolproject.servic.areaAndClassModule.IAreaSevice;
import com.AAAAAA.pestcontrolproject.servic.areaAndClassModule.IClassServic;
import com.AAAAAA.pestcontrolproject.servic.impl.areaAndClassModule.AreaServiceImpl;
import com.AAAAAA.pestcontrolproject.servic.impl.areaAndClassModule.ClassServiceImpl;
import com.AAAAAA.pestcontrolproject.servic.impl.userModule.RoleServicImpl;
import com.AAAAAA.pestcontrolproject.servic.userModule.IRoleServic;
import com.AAAAAA.pestcontrolproject.service.selectedType.ISelectedTypeService;
import com.AAAAAA.pestcontrolproject.service.selectedType.impl.SelectedTypeImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

    public class AddAreaInitServlet extends HttpServlet {
   IAreaSevice areaSevice=new AreaServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //查找所有地类对象集合
        ISelectedTypeService  selectedTypeService = new SelectedTypeImpl();
        List<SysSelectedType> sysSelectedTypelist= selectedTypeService.getSelectValueListByTypeName("DL");

        //将集合放入request
        request.setAttribute("areaList",sysSelectedTypelist);
        request.getRequestDispatcher("page/areaAndClassModule/areaAdd.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
