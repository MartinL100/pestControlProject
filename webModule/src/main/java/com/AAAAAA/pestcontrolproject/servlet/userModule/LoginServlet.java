package com.AAAAAA.pestcontrolproject.servlet.userModule;

import com.AAAAAA.pestcontrolproject.entity.userModule.TUser;
import com.AAAAAA.pestcontrolproject.servic.impl.userModule.UserServicImpl;
import com.AAAAAA.pestcontrolproject.servic.userModule.IUserServic;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LoginServlet extends HttpServlet {
    IUserServic userServic = new UserServicImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

           //获取登录的对象
            String userName=request.getParameter("userName");
            String password=request.getParameter("password");
        Map<String, String> map = new HashMap<>();
        map.put("userName",userName);
        map.put("password",password);
       TUser user= userServic.login(map);



       request.getRequestDispatcher("page/userModule/mainFrame.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
