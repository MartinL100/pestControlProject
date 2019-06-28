package com.AAAAAA.pestcontrolproject.servlet.userModule;

import com.AAAAAA.pestcontrolproject.entity.userModule.TRole;
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

public class UpdateUserInfoSureServlet extends HttpServlet {
    IUserServic userServic=new UserServicImpl();
    IRoleServic roleServic = new RoleServicImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //查找所有角色对象集合
        List<TRole> roleList =roleServic.findAllrolesList();
        //将集合放入request
        request.setAttribute("roleList",roleList);

       String newPwd= request.getParameter("newPwd");
        String sureNewPwd= request.getParameter("newPwd");
        //判断两次新密码是否一致
        if(newPwd.equals(sureNewPwd)){
            String roleId=request.getParameter("roleId");
            String userId=request.getParameter("userId");
            Map<String,String>map=new HashMap<>();
            map.put("newPwd",newPwd);
            map.put("roleId",roleId);
            map.put("userId",userId);
            userServic.updateUserInfo(map);
            request.getRequestDispatcher("findUserServlet").forward(request,response);
        }else {
            request.getRequestDispatcher("findUserServlet").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
