package com.AAAAAA.pestcontrolproject.servlet.documentModule.pestis;

import com.AAAAAA.pestcontrolproject.entity.documentModule.pestisBean;
import com.AAAAAA.pestcontrolproject.servic.impl.documentModule.PestisServiceImpl;
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

public class PestisIndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        PestisServiceImpl pestisService = new PestisServiceImpl();
//        List<pestisBean> listPestis = pestisService.getListPestis();
//        System.out.println(listPestis);
//        request.setAttribute("page",listPestis);
//        request.getRequestDispatcher("page/documentModule/wormPanel.jsp").forward(request,response);

        request.setCharacterEncoding("UTF-8");
        //获得查询条件
        String name = request.getParameter("name");
        String name1 = request.getParameter("name1");

        System.out.println(name + "," + name1);

        //获得当前页面
        String currentPage = request.getParameter("currentPage");
        String pageTag = request.getParameter("pageTag");

        System.out.println(currentPage + "," + pageTag);
        PestisServiceImpl pestisService = new PestisServiceImpl();
        PageUtil pageUtil=new PageUtil();
        pageUtil.setCountPage(8);
        pageUtil.setAllCount(pestisService.getPestis(null));
        pageUtil.setAllPage();
        if (StringUtils.isEmpty(currentPage)) {
            pageUtil.setCurrentPage(1, "1");
        }else {
            pageUtil.setCurrentPage(Integer.parseInt(currentPage), pageTag);
        }
        pageUtil.setStart();
        Map<String,Object> map=new HashMap<>();

        map.put("pestisName",name);
        map.put("pestisSymptom",name1);
        map.put("startIndex",pageUtil.getStart());
        map.put("rowNum",pageUtil.getCountPage());

        List<pestisBean> namePestis = pestisService.getNamePestis(map);
        request.setAttribute("page",pageUtil);
        request.setAttribute("list",namePestis);
        request.getRequestDispatcher("page/documentModule/wormPanel.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doPost(request,response);
    }
}
