package com.AAAAAA.pestcontrolproject.servlet.specialistModule;

import com.AAAAAA.pestcontrolproject.entity.specialistModule.TSpecialist;
import com.AAAAAA.pestcontrolproject.servic.impl.specialistModule.ISpecialistServiceImpl;
import com.AAAAAA.pestcontrolproject.servic.specialistModule.ISpecialistService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SpecialistUpdateServlet extends HttpServlet {
    ISpecialistService service = new ISpecialistServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 得到请求中的专家对象
        String specialistId = req.getParameter("specialistId");
        String updateTag = req.getParameter("updateTag");
        String specialistDuty = req.getParameter("specialistDuty");
        String specialistTel = req.getParameter("specialistTel");
        String specialistUnits = req.getParameter("specialistUnits");
        String specialistEmail = req.getParameter("specialistEmail");
        if (null == updateTag) {
            TSpecialist specialist = service.findSpecialistById(specialistId);
            req.setAttribute("specialistObj", specialist);
            //将对象转发到SpecialistUpdate.jsp
            req.getRequestDispatcher("page/specialistModule/SpecialistUpdate.jsp").forward(req, resp);
        } else if ("updateSpecialist".equals(updateTag)) {
            //点击确认修改后的新的专家信息
            //将信息重新保存，并重定向到主页面SpecialistMain.jsp
            Map map = new HashMap();
            map.put("specialistDuty", specialistDuty);
            map.put("specialistTel", specialistTel);
            map.put("specialistUnits", specialistUnits);
            map.put("specialistEmail", specialistEmail);
            map.put("specialistId", specialistId);
            service.updateSpecialist(map);
            resp.sendRedirect("specialistMain");
        }




    }
}
