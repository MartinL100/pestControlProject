package com.AAAAAA.pestcontrolproject.servlet.userModule.temp;

import com.AAAAAA.pestcontrolproject.entity.documentModule.DiseaseBean;
import com.AAAAAA.pestcontrolproject.entity.documentModule.mouseBean;
import com.AAAAAA.pestcontrolproject.servic.impl.userModule.temp.DiseaseServiceImpl;
import com.AAAAAA.pestcontrolproject.servic.impl.userModule.temp.MouseServiceImpl;
import com.AAAAAA.pestcontrolproject.servic.userModule.temp.IDiseaseService;
import com.AAAAAA.pestcontrolproject.servic.userModule.temp.IMouseService;
import com.AAAAAA.pestcontrolproject.util.SplitPage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MouseIntitServlet extends HttpServlet {
           IMouseService mouseService=new MouseServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //封装查询条件的map
        Map map=new HashMap();
        //获取查询条件
        String mouseName=request.getParameter("mouseName");
            map.put("mouseName",mouseName);
        //获取操作标记
        String tag=request.getParameter("tag");
        //获取前端传递的当前页
        String currentPage=request.getParameter("currentPage");
        //获取总行数
        int rows =mouseService.getMouse(map);
        //调用分页计算
        Map mapTemp= SplitPage.SplitPage(currentPage,tag,5,rows);
        map.putAll(mapTemp);

        List<mouseBean> mouseBeanList=mouseService.getNameMouse(map);
        //设置返回集合
        request.setAttribute("mouseBeanList",mouseBeanList);
        //设置当前页
        request.setAttribute("maxPage",map.get("maxPage"));
        //设置最大页
        request.setAttribute("currentPage",map.get("newCurrentPage"));
        //返回查询条件
        request.setAttribute("mouseName",mouseName);
        request.getRequestDispatcher("page/userModule/temp/mouse/mousePanel.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request, response);
    }
}
