package com.AAAAAA.pestcontrolproject.servlet.documentModule.mouse;

import com.AAAAAA.pestcontrolproject.entity.documentModule.mouseBean;
import com.AAAAAA.pestcontrolproject.servic.impl.documentModule.MouseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MouseIndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MouseServiceImpl mouseService = new MouseServiceImpl();




        List<mouseBean> lIstMouse = mouseService.getLIstMouse();
        request.setAttribute("mouse",lIstMouse);
        request.getRequestDispatcher("page/documentModule/mousePanel.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doPost(request,response);
    }
}
