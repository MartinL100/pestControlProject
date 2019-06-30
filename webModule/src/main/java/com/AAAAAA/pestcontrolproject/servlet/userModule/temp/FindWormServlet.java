package com.AAAAAA.pestcontrolproject.servlet.userModule.temp;

import com.AAAAAA.pestcontrolproject.entity.documentModule.pestisBean;
import com.AAAAAA.pestcontrolproject.servic.impl.userModule.temp.PestisServiceImpl;
import com.AAAAAA.pestcontrolproject.servic.userModule.temp.IPestisService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FindWormServlet extends HttpServlet {
    IPestisService pestisService=new PestisServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String checkedWorm=request.getParameter("checkedWorm");
        pestisBean idpestis= pestisService.AllPestis(Integer.parseInt(checkedWorm));
        request.setAttribute("idpestis",idpestis);
        request.getRequestDispatcher("page/userModule/temp/worm/wormInfo.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
