package com.AAAAAA.pestcontrolproject.servlet.userModule.temp;

import com.AAAAAA.pestcontrolproject.entity.documentModule.DiseaseBean;
import com.AAAAAA.pestcontrolproject.entity.documentModule.mouseBean;
import com.AAAAAA.pestcontrolproject.servic.impl.userModule.temp.DiseaseServiceImpl;
import com.AAAAAA.pestcontrolproject.servic.impl.userModule.temp.MouseServiceImpl;
import com.AAAAAA.pestcontrolproject.servic.userModule.temp.IDiseaseService;
import com.AAAAAA.pestcontrolproject.servic.userModule.temp.IMouseService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FindMouseServlet extends HttpServlet {
    IMouseService mouseService=new MouseServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String checkedMouse=request.getParameter("checkedMouse");
        mouseBean mouse=mouseService.AllMouse(Integer.parseInt(checkedMouse));
        request.setAttribute("mouse",mouse);
        request.getRequestDispatcher("page/userModule/temp/mouse/mouseInfo.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
