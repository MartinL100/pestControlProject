package com.AAAAAA.pestcontrolproject.servlet.documentModule.pestis;

import com.AAAAAA.pestcontrolproject.entity.documentModule.pestisBean;
import com.AAAAAA.pestcontrolproject.servic.impl.documentModule.PestisServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class PestisIndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PestisServiceImpl pestisService = new PestisServiceImpl();
        List<pestisBean> listPestis = pestisService.getListPestis();
        System.out.println(listPestis);
        request.setAttribute("page",listPestis);
        request.getRequestDispatcher("page/documentModule/wormPanel.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doPost(request,response);
    }
}
