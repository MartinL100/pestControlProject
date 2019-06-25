package com.AAAAAA.pestcontrolproject.servlet.drugModule;

import com.AAAAAA.pestcontrolproject.entity.Selected.SysSelectedType;
import com.AAAAAA.pestcontrolproject.entity.drugModule.SysDrug;
import com.AAAAAA.pestcontrolproject.servic.drugModule.IDrugService;
import com.AAAAAA.pestcontrolproject.servic.impl.drugModule.DrugServiceImpl;
import com.AAAAAA.pestcontrolproject.service.selectedType.ISelectedTypeService;
import com.AAAAAA.pestcontrolproject.service.selectedType.impl.SelectedTypeImpl;
import com.AAAAAA.pestcontrolproject.util.PageUtil;
import com.AAAAAA.pestcontrolproject.util.Verify;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class drugPanelPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IDrugService drugService=new DrugServiceImpl();
        ISelectedTypeService typeService=new SelectedTypeImpl();

        String drugCureType="";
        String drugType="";
        String drugName="";
//        //得到分页标签
        String pageTag=request.getParameter("PageTag");
//        //得到页传过来的数据

        if(null!=pageTag&&!("".equals(pageTag))){
         drugCureType=  request.getParameter("drugCureType");
         drugType   =request.getParameter("drugType");
         drugName= request.getParameter("drugName");
        }
//        //新建一个分页对象
        PageUtil page=new PageUtil();
        //获得当前页
        String currentPage=  request.getParameter("currentPage");
        int currentPageNum=1;
        if(Verify.verifyString(currentPage)){
            //当前页不为空
            currentPageNum=Integer.parseInt(currentPage);
        }
        if(!Verify.verifyString(pageTag)){
            pageTag="first";//如果标志为空，就赋值为首页
        }
//        //得到初始的当前页
//       int CurrentPage= page.getCurrentPage();
//        //设置当前页
        page.setCurrentPage(currentPageNum,pageTag);

        //得到数据条数
        int countPage= page.getCountPage();
//        //查询得到总页数
        Map<String,Object> map= new HashMap<>();
        map.put("drugName",drugName);
        map.put("drugCureType",drugCureType);
        map.put("drugType",drugType);
//        //总数量
       int allCount= drugService.getAllCount(map);
//       //设置行数....
        page.setAllCount(allCount);
//        //设置总页数
        page.setAllPage();
        //设置起始位置
        page.setStartPage();
        //得到起始页
        int startPage=page.getStartPage();
        map.put("startPage",startPage);
        map.put("countPage",countPage);
//
//        //查询物品集合
       List<SysDrug> drugList=drugService.getListPageDrugByMap(map);
       //得到下拉框集合
       List<SysSelectedType> drugCureTypeList= typeService.getSelectValueListByTypeName("drugCureType");
       List<SysSelectedType> drugTypeList=  typeService.getSelectValueListByTypeName("drugType");
        request.setAttribute("drugCureTypeList",drugCureTypeList);
        request.setAttribute("drugTypeList",drugTypeList);
        request.setAttribute("drugList",drugList);
        request.setAttribute("page",page);
       if ("addBtn".equals(pageTag)){
           request.getRequestDispatcher("page/drugModule/drugAdd.jsp").forward(request,response);
           return;
       }
        if (null == pageTag||"".equals(pageTag)){
            request.setAttribute("checkType","NotOneTime");
        }
        request.getRequestDispatcher("page/drugModule/drugPanel.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }
}
