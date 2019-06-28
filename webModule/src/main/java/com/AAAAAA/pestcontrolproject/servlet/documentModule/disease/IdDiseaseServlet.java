package com.AAAAAA.pestcontrolproject.servlet.documentModule.disease;


import com.AAAAAA.pestcontrolproject.entity.documentModule.DiseaseBean;
import com.AAAAAA.pestcontrolproject.servic.impl.documentModule.DiseaseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class IdDiseaseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DiseaseServiceImpl diseaseService = new DiseaseServiceImpl();
        String diseaseId = request.getParameter("diseaseId");
            DiseaseBean diseaseBean = diseaseService.InquireDisease(Integer.parseInt(diseaseId));

            request.setAttribute("idDisease", diseaseBean);
            request.getRequestDispatcher("page/documentModule/diseaseInfo.jsp").forward(request, response);





    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }
}
