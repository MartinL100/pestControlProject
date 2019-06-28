package com.AAAAAA.pestcontrolproject.servlet.specialistModule;

import com.AAAAAA.pestcontrolproject.entity.specialistModule.TSpecialist;
import com.AAAAAA.pestcontrolproject.servic.impl.specialistModule.ISpecialistServiceImpl;
import com.AAAAAA.pestcontrolproject.servic.specialistModule.ISpecialistService;
import com.AAAAAA.pestcontrolproject.util.SplitPage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpecialistMainServlet extends HttpServlet {
    ISpecialistService service = new ISpecialistServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、显示主界面
        //得到首页的专家集合
        //起始位置
        int startIndex = 0;
        //显示行数
        int rowNum = 5;
        String pageTag = req.getParameter("pageTag");//页面标记
        String currentPage = req.getParameter("currentPage");//得到当前页
        String specialistId = req.getParameter("specialistId");//得到专家ID
        //得到查询条件
        String specialistName = req.getParameter("specialistName");
        String specialistSpeciality = req.getParameter("specialistSpeciality");
        String specialistUnits = req.getParameter("specialistUnits");
        System.out.println(pageTag);
        Map<String, Object> map = new HashMap<>();
        map.put("startIndex", startIndex);
        map.put("rowNum", rowNum);
        map.put("specialistName", specialistName);
        map.put("specialistSpeciality", specialistSpeciality);
        map.put("specialistUnits", specialistUnits);
        req.setAttribute("specialistId", specialistId);
        //得到总行数
        int countRow = service.findCountRow(map);
        if (null == pageTag || "".equals(pageTag) || "findF".equals(pageTag)) {//初始化和动态查询初始化

            List<TSpecialist> list = service.findSpecialistList(map);
            //得到总页数
            if (countRow % rowNum == 0) {
                countRow = countRow / rowNum;
            } else {
                countRow = countRow / rowNum + 1;
            }
            req.setAttribute("currentPage", 1);
            req.setAttribute("countRow", countRow);
            req.setAttribute("specialistName", specialistName);
            req.setAttribute("specialistSpeciality", specialistSpeciality);
            req.setAttribute("specialistUnits", specialistUnits);
            //将专家集合转发到SpecialistMain.jsp
            req.setAttribute("specialistList", list);
            req.getRequestDispatcher("page/specialistModule/SpecialistMain.jsp").forward(req, resp);
        } else if ("find".equals(pageTag)) {//查看专家
            //3、点击查看按钮
            //得到用户选择行的信息，并将其转发到SpecialistFind
            req.getRequestDispatcher("specialistFind").forward(req, resp);
        } else if ("add".equals(pageTag)) {//添加专家
            req.getRequestDispatcher("page/specialistModule/SpecialistAdd.jsp").forward(req, resp);
        } else if ("update".equals(pageTag)) {
            //4、点击修改按钮
            //得到用户选择行的信息，并将其转发到SpecialistUpdateMain
            req.getRequestDispatcher("specialistUpdate").forward(req, resp);
        } else if ("del".equals(pageTag)) {
            //5、点击删除按钮
            //得到用户选择行的id，删除该专家
            service.delSpecialistById(specialistId);
            resp.sendRedirect("specialistMain");
        } else {//上一页、下一页和跳转页   if ("next".equals(pageTag) || "prev".equals(pageTag))
            Map mapMax = SplitPage.SplitPage(currentPage, pageTag, rowNum, countRow);
            mapMax.put("specialistName", specialistName);
            mapMax.put("specialistSpeciality", specialistSpeciality);
            mapMax.put("specialistUnits", specialistUnits);
            List<TSpecialist> list = service.findSpecialistList(mapMax);
            req.setAttribute("specialistName", specialistName);
            req.setAttribute("specialistSpeciality", specialistSpeciality);
            req.setAttribute("specialistUnits", specialistUnits);
            req.setAttribute("specialistList", list);
            req.setAttribute("countRow", mapMax.get("maxPage"));
            req.setAttribute("currentPage", mapMax.get("newCurrentPage"));
            req.getRequestDispatcher("page/specialistModule/SpecialistMain.jsp").forward(req, resp);
        }
    }
}
