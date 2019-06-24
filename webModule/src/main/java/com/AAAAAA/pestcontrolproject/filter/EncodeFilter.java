package com.AAAAAA.pestcontrolproject.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.Writer;

/**
 * 自定义过滤器
 */
public class EncodeFilter implements Filter {
  String encoding="UTF-8";
    public void init(FilterConfig filterConfig) throws ServletException {
        //System.out.println("过滤器1被初始化");
        encoding= filterConfig.getInitParameter("encoding");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req=(HttpServletRequest)request;
        //获取请求名称
        String servletPath=req.getServletPath();
        //如果是jsp文件则放行
            if(servletPath.endsWith("jsp")){
                chain.doFilter(request,response);
                return;
            }

        //System.out.println("进入了过滤器1");
        request.setCharacterEncoding(encoding);
        response.setCharacterEncoding(encoding);
        //把request和response交给下一个过滤器，如果没有过滤器就交给servlet
        chain.doFilter(request,response);

    }

    @Override
    public void destroy() {

    }
}
