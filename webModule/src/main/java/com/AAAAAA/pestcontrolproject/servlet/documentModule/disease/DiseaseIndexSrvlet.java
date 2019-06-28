package com.AAAAAA.pestcontrolproject.servlet.documentModule.disease;

import com.AAAAAA.pestcontrolproject.entity.documentModule.DiseaseBean;
import com.AAAAAA.pestcontrolproject.servic.impl.documentModule.DiseaseServiceImpl;
import com.AAAAAA.pestcontrolproject.util.PageUtil;
import org.apache.commons.lang3.StringUtils;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//病害主页面servlet
public class DiseaseIndexSrvlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        //获得查询条件
        String name = request.getParameter("name");
        String name1 = request.getParameter("name1");

        System.out.println(name + "," + name1);

        //获得当前页面
        String currentPage = request.getParameter("currentPage");
        String pageTag = request.getParameter("pageTag");

        System.out.println(currentPage + "," + pageTag);

        DiseaseServiceImpl diseaseService = new DiseaseServiceImpl();
        PageUtil pageUtil=new PageUtil();
        pageUtil.setCountPage(8);
        pageUtil.setAllCount(diseaseService.getDisease(null));
        pageUtil.setAllPage();

        if (StringUtils.isEmpty(currentPage)) {
            pageUtil.setCurrentPage(1, "1");
        }else {
            pageUtil.setCurrentPage(Integer.parseInt(currentPage), pageTag);
        }
        pageUtil.setStart();
        Map<String,Object> map=new HashMap<>();
        map.put("diseaseName",name);
        map.put("diseaseSymptom",name1);
        map.put("startIndex",pageUtil.getStart());
        map.put("rowNum",pageUtil.getCountPage());

        List<DiseaseBean> diseaseBeanList = diseaseService.getNameDisease(map);

        request.setAttribute("page",pageUtil);
        request.setAttribute("list",diseaseBeanList);
        request.getRequestDispatcher("page/documentModule/diseasePanel.jsp").forward(request,response);

//
//                List<DiseaseBean> nameDisease = diseaseService.getList();
//        request.setAttribute("list",nameDisease);
//        request.getRequestDispatcher("/page/documentModule/diseasePanel.jsp").forward(request,response);
//          String diseaseIndex = request.getParameter("diseaseIndex");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          doPost(request,response);
    }
}
