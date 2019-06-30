package com.AAAAAA.pestcontrolproject.servlet.userModule.temp;

import com.AAAAAA.pestcontrolproject.entity.documentModule.DiseaseBean;
import com.AAAAAA.pestcontrolproject.entity.documentModule.pestisBean;
import com.AAAAAA.pestcontrolproject.servic.impl.userModule.temp.DiseaseServiceImpl;
import com.AAAAAA.pestcontrolproject.servic.impl.userModule.temp.PestisServiceImpl;
import com.AAAAAA.pestcontrolproject.servic.userModule.temp.IDiseaseService;
import com.AAAAAA.pestcontrolproject.servic.userModule.temp.IPestisService;
import com.AAAAAA.pestcontrolproject.util.SplitPage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiseaseIntitServlet extends HttpServlet {
            IDiseaseService diseaseService=new DiseaseServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //封装查询条件的map
        Map map=new HashMap();
        //获取查询条件
        String diseaseName=request.getParameter("diseaseName");
        String diseaseSymptom=request.getParameter("diseaseSymptom");
            map.put("diseaseName",diseaseName);
        map.put("diseaseSymptom",diseaseSymptom);
        //获取操作标记
        String tag=request.getParameter("tag");
        //获取前端传递的当前页
        String currentPage=request.getParameter("currentPage");
        //获取总行数
        int rows =diseaseService.getDisease(map);
        //调用分页计算
        Map mapTemp= SplitPage.SplitPage(currentPage,tag,5,rows);
        map.putAll(mapTemp);

        List<DiseaseBean> diseaseBeanList=diseaseService.getNameDisease(map);
        //设置返回集合
        request.setAttribute("diseaseBeanList",diseaseBeanList);
        //设置当前页
        request.setAttribute("maxPage",map.get("maxPage"));
        //设置最大页
        request.setAttribute("currentPage",map.get("newCurrentPage"));
        //返回查询条件
        request.setAttribute("diseaseName",diseaseName);
        request.setAttribute("diseaseSymptom",diseaseSymptom);
        request.getRequestDispatcher("page/userModule/temp/disease/diseasePanel.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request, response);
    }
}
