package com.AAAAAA.pestcontrolproject.servlet.documentModule.pestis;

import com.AAAAAA.pestcontrolproject.entity.documentModule.pestisBean;
import com.AAAAAA.pestcontrolproject.servic.impl.documentModule.DiseaseServiceImpl;
import com.AAAAAA.pestcontrolproject.servic.impl.documentModule.PestisServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class IdPestisServlet extends HttpServlet {
    PestisServiceImpl pestisService = new PestisServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pestisId = request.getParameter("pestisId");

            pestisBean pestisBean = pestisService.AllPestis(Integer.parseInt(pestisId));

            request.setAttribute("idpestis", pestisBean);
            request.getRequestDispatcher("page/documentModule/wormInfo.jsp").forward(request, response);
        }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  doPost(request,response);
    }
}
