package com.AAAAAA.pestcontrolproject.servlet.userModule.temp;

import com.AAAAAA.pestcontrolproject.entity.documentModule.pestisBean;
import com.AAAAAA.pestcontrolproject.servic.impl.userModule.temp.PestisServiceImpl;
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

public class WormIntitServlet extends HttpServlet {
            IPestisService pestisService=new PestisServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //封装查询条件的map
        Map map=new HashMap();
        //获取查询条件
        String pestisName=request.getParameter("pestisName");
        String pestisHost=request.getParameter("pestisHost");
            map.put("pestisName",pestisName);
        map.put("pestisHost",pestisHost);
        //获取操作标记
        String tag=request.getParameter("tag");
        //获取前端传递的当前页
        String currentPage=request.getParameter("currentPage");
        //获取总行数
        int rows =pestisService.getPestis(map);
        //调用分页计算
        Map mapTemp= SplitPage.SplitPage(currentPage,tag,5,rows);
        map.putAll(mapTemp);

        List<pestisBean> pestisBeanList=pestisService.getListPestis(map);
        //设置返回集合
        request.setAttribute("pestisBeanList",pestisBeanList);
        //设置当前页
        request.setAttribute("maxPage",map.get("maxPage"));
        //设置最大页
        request.setAttribute("currentPage",map.get("newCurrentPage"));
        //返回查询条件
        request.setAttribute("pestisName",pestisName);
        request.setAttribute("pestisHost",pestisHost);
        request.getRequestDispatcher("page/userModule/temp/worm/wormPanel.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request, response);
    }
}
