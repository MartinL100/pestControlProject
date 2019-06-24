package com.AAAAAA.pestcontrolproject.servlet.userModule;

import com.AAAAAA.pestcontrolproject.entity.userModule.TRole;
import com.AAAAAA.pestcontrolproject.entity.userModule.TUser;
import com.AAAAAA.pestcontrolproject.servic.impl.userModule.RoleServicImpl;
import com.AAAAAA.pestcontrolproject.servic.impl.userModule.UserServicImpl;
import com.AAAAAA.pestcontrolproject.servic.userModule.IRoleServic;
import com.AAAAAA.pestcontrolproject.servic.userModule.IUserServic;

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
        //查找所有角色对象集合
        List<TRole> roleList =roleServic.findAllrolesList();
        //将集合放入request
        request.setAttribute("roleList",roleList);
        String roleId=request.getParameter("roleId");
        Map<String,String> map=new HashMap<>();
        map.put("roleId",roleId);
       List<TUser>userList= userServic.findUsersList(map);
        request.setAttribute("userList",userList);
        request.getRequestDispatcher("page/userModule/userPanel.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
