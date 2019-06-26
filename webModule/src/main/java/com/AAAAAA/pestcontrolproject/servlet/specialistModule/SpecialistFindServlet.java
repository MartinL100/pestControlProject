package com.AAAAAA.pestcontrolproject.servlet.specialistModule;

import com.AAAAAA.pestcontrolproject.entity.specialistModule.TSpecialist;
import com.AAAAAA.pestcontrolproject.servic.impl.specialistModule.ISpecialistServiceImpl;
import com.AAAAAA.pestcontrolproject.servic.specialistModule.ISpecialistService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SpecialistFindServlet extends HttpServlet {
    ISpecialistService service = new ISpecialistServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //得到req中的标记
        String findTag = req.getParameter("findTag");
        if ("getBack".equals(findTag)) {
            resp.sendRedirect("specialistMain");
        } else {
            String specialistId = req.getParameter("specialistId");
            TSpecialist specialist = service.findSpecialistById(specialistId);//得到专家对象
            req.setAttribute("specialist", specialist);
            //将该对象转发给SpecialistFind.jsp
            req.getRequestDispatcher("page/specialistModule/SpecialistFind.jsp").forward(req, resp);
        }
    }
}