package com.AAAAAA.pestcontrolproject.servlet.userModule;

import com.AAAAAA.pestcontrolproject.entity.userModule.TRole;
import com.AAAAAA.pestcontrolproject.entity.userModule.TUser;
import com.AAAAAA.pestcontrolproject.servic.impl.userModule.RoleServicImpl;
import com.AAAAAA.pestcontrolproject.servic.impl.userModule.UserServicImpl;
import com.AAAAAA.pestcontrolproject.servic.userModule.IRoleServic;
import com.AAAAAA.pestcontrolproject.servic.userModule.IUserServic;
import com.AAAAAA.pestcontrolproject.util.CheckString;
import com.AAAAAA.pestcontrolproject.util.SplitPage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindUserServlet extends HttpServlet {
    IUserServic userServic = new UserServicImpl();
    IRoleServic roleServic = new RoleServicImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     //查询条件集合
        Map map = new HashMap();

        //查找所有角色对象集合
        List<TRole> roleList =roleServic.findAllrolesList();
        //将集合放入request
        request.setAttribute("roleList",roleList);
        //获取查找条件
        String roleId=request.getParameter("roleId");
        map.put("roleId",roleId);
        //获取操作标记
        String tag=request.getParameter("tag");
        //获取前端传递的当前页
        String currentPage=request.getParameter("currentPage");
        //查找总行数
        int allRows=userServic.countAllUsers(map);
        //调用计算方法，返回条件集合
         Map splitPageMap=SplitPage.SplitPage(currentPage,tag,5,allRows);
        map.putAll(splitPageMap);
       List<TUser>userList= userServic.findUsersList(map);
        request.setAttribute("userList",userList);
        request.setAttribute("maxPage",map.get("maxPage"));
        request.setAttribute("currentPage",map.get("newCurrentPage"));
        request.getRequestDispatcher("page/userModule/userPanel.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
