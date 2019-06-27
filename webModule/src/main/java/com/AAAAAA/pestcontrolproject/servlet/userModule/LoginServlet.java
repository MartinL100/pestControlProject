package com.AAAAAA.pestcontrolproject.servlet.userModule;

import com.AAAAAA.pestcontrolproject.entity.userModule.TLog;
import com.AAAAAA.pestcontrolproject.entity.userModule.TUser;
import com.AAAAAA.pestcontrolproject.servic.impl.userModule.LogServicImpl;
import com.AAAAAA.pestcontrolproject.servic.impl.userModule.UserServicImpl;
import com.AAAAAA.pestcontrolproject.servic.userModule.ILogSevice;
import com.AAAAAA.pestcontrolproject.servic.userModule.IUserServic;
import com.AAAAAA.pestcontrolproject.util.UserModuleStringInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LoginServlet extends HttpServlet {
    IUserServic userServic = new UserServicImpl();
    ILogSevice logSevice=new LogServicImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


            String userName=request.getParameter("userName");
            String password=request.getParameter("password");
        Map<String, String> map = new HashMap<>();
        map.put("userName",userName);
        map.put("password",password);
        //获取登录的对象
       TUser user= userServic.login(map);
            //登录验证
        if(null==user){
            //如果用户为空则返回登录界面，并且返回错误信息
            request.setAttribute("errorInfo", UserModuleStringInfo.USER_IS_NOTEXIST);
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }else {
            //将user放到session中，属性名字为userObj
                request.getSession().setAttribute("userObj",user);
                //添加登录日志
            TLog log=new TLog();
            log.setLogDescrip(userName+UserModuleStringInfo.LOG_INFO);
            logSevice.addLog(log);
            request.getRequestDispatcher("page/userModule/mainFrame.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
