package com.AAAAAA.pestcontrolproject.servlet.documentModule.mouse;

import com.AAAAAA.pestcontrolproject.entity.documentModule.mouseBean;
import com.AAAAAA.pestcontrolproject.servic.impl.documentModule.MouseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class IdMouseServlet extends HttpServlet {
                   MouseServiceImpl mouseService=new MouseServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mouseId = request.getParameter("mouseId");
        System.out.println(mouseId);
        mouseBean mouseBean = mouseService.AllMouse(Integer.parseInt(mouseId));
        request.setAttribute("idMouse",mouseBean);
        request.getRequestDispatcher("page/documentModule/mouseInfo.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           doPost(request,response);
    }
}
