package com.AAAAAA.pestcontrolproject.servlet.documentModule.mouse;

import com.AAAAAA.pestcontrolproject.entity.documentModule.mouseBean;
import com.AAAAAA.pestcontrolproject.servic.impl.documentModule.MouseServiceImpl;
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

public class MouseIndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        MouseServiceImpl mouseService = new MouseServiceImpl();
//        List<mouseBean> lIstMouse = mouseService.getLIstMouse();
//        request.setAttribute("mouse",lIstMouse);
//        request.getRequestDispatcher("page/documentModule/mousePanel.jsp").forward(request,response);
        request.setCharacterEncoding("UTF-8");
        //获得查询条件
        String name = request.getParameter("name");
        //获得当前页面
        String currentPage = request.getParameter("currentPage");
        String pageTag = request.getParameter("pageTag");

        System.out.println(currentPage + "," + pageTag);

        MouseServiceImpl mouseService = new MouseServiceImpl();
        PageUtil pageUtil=new PageUtil();
        pageUtil.setCountPage(8);
        pageUtil.setAllCount(mouseService.getMouse(null));
        pageUtil.setAllPage();

        if (StringUtils.isEmpty(currentPage)) {
            pageUtil.setCurrentPage(1, "1");
        }else {
            pageUtil.setCurrentPage(Integer.parseInt(currentPage), pageTag);
        }
        pageUtil.setStart();
        Map<String,Object> map=new HashMap<>();
        map.put("mouseName",name);
        map.put("startIndex",pageUtil.getStart());
        map.put("rowNum",pageUtil.getCountPage());
        List<mouseBean> nameMouse = mouseService.getNameMouse(map);
        request.setAttribute("page",pageUtil);
        request.setAttribute("list",nameMouse);
        request.getRequestDispatcher("page/documentModule/mousePanel.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doPost(request,response);
    }
}
