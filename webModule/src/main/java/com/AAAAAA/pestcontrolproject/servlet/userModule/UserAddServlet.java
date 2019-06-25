package com.AAAAAA.pestcontrolproject.servlet.userModule;

import com.AAAAAA.pestcontrolproject.entity.userModule.TRole;
import com.AAAAAA.pestcontrolproject.entity.userModule.TUser;
import com.AAAAAA.pestcontrolproject.servic.impl.userModule.UserServicImpl;
import com.AAAAAA.pestcontrolproject.servic.userModule.IUserServic;
import com.AAAAAA.pestcontrolproject.util.UserModuleStringInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserAddServlet extends HttpServlet {
    IUserServic userServic=new UserServicImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userName=request.getParameter("userName");
        String password=request.getParameter("password");
        String passwordSure=request.getParameter("passwordSure");
        String realName=request.getParameter("realName");
        String roleId=request.getParameter("roleId");
        //记录错误信息
        String erroInfo="";
        //判断两次密码是否相同
        if(password.equals(passwordSure)){
            TUser user=new TUser();
            TRole role=new TRole();
            role.setRoleId(Integer.parseInt(roleId));
            user.setUserName(userName);
            user.setUserPassword(password);
            user.setRealName(realName);
            user.setRole(role);
            //利用返回信息判断是否存在同名用户，如果同名不会执行添加
            erroInfo=userServic.addUser(user);

        }else {
            erroInfo= UserModuleStringInfo.PASSWORD_IS_DIFFRENT;
        }

        //如果返回信息为null，则返回添加成功信息
        if(null==erroInfo||"".equals(erroInfo)){
            erroInfo=UserModuleStringInfo.ADD_SUCCESSFUL;
        }

        request.setAttribute("erroInfo",erroInfo);
response.sendRedirect("findUserServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
