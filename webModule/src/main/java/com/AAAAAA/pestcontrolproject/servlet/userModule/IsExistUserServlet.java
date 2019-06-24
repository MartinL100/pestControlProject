package com.AAAAAA.pestcontrolproject.servlet.userModule;

import com.AAAAAA.pestcontrolproject.servic.impl.userModule.UserServicImpl;
import com.AAAAAA.pestcontrolproject.servic.userModule.IUserServic;
import com.AAAAAA.pestcontrolproject.util.CheckString;
import com.AAAAAA.pestcontrolproject.util.UserModuleStringInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

public class IsExistUserServlet extends HttpServlet {
    IUserServic userServic=new UserServicImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName=request.getParameter("userName");
        String erroInfo="";
        //检查用户名是否为空
        if(CheckString.isNull(userName)){
            erroInfo= UserModuleStringInfo.USERNAME_IS_NULL;
        }else {
            //检查用户名是否存在
          boolean isExistBl=  userServic.isExistUserByName(userName);
          if(isExistBl){
              erroInfo=UserModuleStringInfo.USER_IS_EXIST;
          }
        }
 response.setHeader("Content-type", "text/plain;charset=UTF-8");
        Writer writer=response.getWriter();
            writer.write(erroInfo);
            writer.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
