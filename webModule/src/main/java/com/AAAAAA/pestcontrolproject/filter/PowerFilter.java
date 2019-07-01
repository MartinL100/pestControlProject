package com.AAAAAA.pestcontrolproject.filter;

import com.AAAAAA.pestcontrolproject.entity.userModule.TPower;
import com.AAAAAA.pestcontrolproject.entity.userModule.TUser;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class PowerFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request=(HttpServletRequest)req;
        HttpServletResponse response=(HttpServletResponse)resp;
        //获取请求名称
        String servletPath=request.getServletPath();
        servletPath=servletPath.substring(1,servletPath.length());
        //判断如果是登录servlet则放行
        if("loginServlet".equals(servletPath)||"index.jsp".equals(servletPath)||servletPath.endsWith(".js")||servletPath.contains(".jsp")||servletPath.contains(".css")||servletPath.contains("jpg")||servletPath.contains("png")){
            chain.doFilter(request,response);
            return;
        }
        //如果不是登录页面

        //从session中获取user
        TUser user=(TUser)request.getSession().getAttribute("userObj");
        //判断用户是否登录
        if(user==null){
            //如果用户没有登录则返回登录页面
            response.sendRedirect("index.jsp");
            return;
        }
        //如果用户已经登录，则判断该用户是否有该servlet的权限
        List<TPower> powers=user.getRole().getPowers();
        //权限标记开关
        Boolean powerBl=false;
        for (TPower p :powers) {
                if(servletPath.equals(p.getPowerResource())){
                    powerBl=true;
                }
        }
        if(powerBl){
            chain.doFilter(req, resp);
        }else {
            //如果该用户没有登录权限，则返回登录界面
            response.sendRedirect("index.jsp");
            return;
        }


    }

    public void init(FilterConfig config) throws ServletException {

    }

}
