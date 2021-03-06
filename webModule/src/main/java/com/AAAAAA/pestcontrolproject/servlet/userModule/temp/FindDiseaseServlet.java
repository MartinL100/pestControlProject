package com.AAAAAA.pestcontrolproject.servlet.userModule.temp;

import com.AAAAAA.pestcontrolproject.entity.documentModule.DiseaseBean;
import com.AAAAAA.pestcontrolproject.entity.documentModule.pestisBean;
import com.AAAAAA.pestcontrolproject.servic.impl.userModule.temp.DiseaseServiceImpl;
import com.AAAAAA.pestcontrolproject.servic.impl.userModule.temp.PestisServiceImpl;
import com.AAAAAA.pestcontrolproject.servic.userModule.temp.IDiseaseService;
import com.AAAAAA.pestcontrolproject.servic.userModule.temp.IPestisService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FindDiseaseServlet extends HttpServlet {
    IDiseaseService diseaseService=new DiseaseServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String checkedWorm=request.getParameter("checkedDisease");
        DiseaseBean diseaseBean = diseaseService.InquireDisease(Integer.parseInt(checkedWorm));
        request.setAttribute("diseaseBean",diseaseBean);
        request.getRequestDispatcher("page/userModule/temp/disease/disesaInfo.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
