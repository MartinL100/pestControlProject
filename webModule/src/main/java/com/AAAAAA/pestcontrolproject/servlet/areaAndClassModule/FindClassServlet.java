package com.AAAAAA.pestcontrolproject.servlet.areaAndClassModule;

import com.AAAAAA.pestcontrolproject.entity.areaAndClassModule.SysClass;
import com.AAAAAA.pestcontrolproject.entity.userModule.TRole;
import com.AAAAAA.pestcontrolproject.entity.userModule.TUser;
import com.AAAAAA.pestcontrolproject.servic.areaAndClassModule.IClassServic;
import com.AAAAAA.pestcontrolproject.servic.impl.areaAndClassModule.ClassServiceImpl;
import com.AAAAAA.pestcontrolproject.servic.impl.userModule.RoleServicImpl;
import com.AAAAAA.pestcontrolproject.servic.impl.userModule.UserServicImpl;
import com.AAAAAA.pestcontrolproject.servic.userModule.IRoleServic;
import com.AAAAAA.pestcontrolproject.servic.userModule.IUserServic;
import com.AAAAAA.pestcontrolproject.util.SplitPage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindClassServlet extends HttpServlet {
    IClassServic classServic=new ClassServiceImpl();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     //查询条件集合
        Map map = new HashMap();
        //获取查找条件
        String sclassName=request.getParameter("sclassName");
        map.put("sclassName",sclassName);
        String areaName=request.getParameter("areaName");
        map.put("areaName",areaName);

        //获取操作标记
        String tag=request.getParameter("tag");
        //获取前端传递的当前页
        String currentPage=request.getParameter("currentPage");
        //查找总行数
        int allRows=classServic.countClass(map);
        //调用计算方法，返回条件集合
         Map splitPageMap=SplitPage.SplitPage(currentPage,tag,5,allRows);
        map.putAll(splitPageMap);
       List<SysClass> classList=classServic.findClassList(map);
        request.setAttribute("classList",classList);
        request.setAttribute("maxPage",map.get("maxPage"));
        request.setAttribute("currentPage",map.get("newCurrentPage"));
        request.setAttribute("areaName",areaName);
        request.setAttribute("sclassName",sclassName);
        request.getRequestDispatcher("page/areaAndClassModule/classPanel.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
