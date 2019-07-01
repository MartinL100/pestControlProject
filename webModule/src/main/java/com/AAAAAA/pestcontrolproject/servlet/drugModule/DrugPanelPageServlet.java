package com.AAAAAA.pestcontrolproject.servlet.drugModule;

import com.AAAAAA.pestcontrolproject.entity.Selected.SysSelectedType;
import com.AAAAAA.pestcontrolproject.entity.drugModule.SysDrug;
import com.AAAAAA.pestcontrolproject.servic.drugModule.IDrugService;
import com.AAAAAA.pestcontrolproject.servic.impl.drugModule.DrugServiceImpl;
import com.AAAAAA.pestcontrolproject.service.selectedType.ISelectedTypeService;
import com.AAAAAA.pestcontrolproject.service.selectedType.impl.SelectedTypeImpl;
import com.AAAAAA.pestcontrolproject.util.PageUtil;
import com.AAAAAA.pestcontrolproject.util.SplitPage;
import com.AAAAAA.pestcontrolproject.util.Verify;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DrugPanelPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IDrugService drugService=new DrugServiceImpl();
        ISelectedTypeService typeService=new SelectedTypeImpl();

        String drugCureType="";
        String drugType="";
        String drugName="";
//        //得到分页标签
        String pageTag=request.getParameter("PageTag");
//        //得到页传过来的数据


//         if(null==pageTag||"".equals(pageTag)){
//             Map<String,Object> map= new HashMap<>();
//             map.put("drugName",drugName);
//             map.put("drugCureType",drugCureType);
//             map.put("drugType",drugType);
//             map.put("startIndex",0);
//            map.put("rowNum",5);
//
////        //查询物品集合
//       List<SysDrug> drugList=drugService.getListPageDrugByMap(map);
       //得到下拉框集合
//       List<SysSelectedType> drugCureTypeList= typeService.getSelectValueListByTypeName("drugCureType");
//       List<SysSelectedType> drugTypeList=  typeService.getSelectValueListByTypeName("drugType");
//        request.setAttribute("drugCureTypeList",drugCureTypeList);
//        request.setAttribute("drugTypeList",drugTypeList);
//        request.setAttribute("drugList",drugList);
//        request.setAttribute("newCurrentPage",1);

//         }
        if(!"addBtn".equals(pageTag)){
         drugCureType=  request.getParameter("drugCureType");
         drugType   =request.getParameter("drugType");
         drugName= request.getParameter("drugName");
         String currentPage=  request.getParameter("currentPage");
             Map<String,Object> map= new HashMap<>();
             map.put("drugName",drugName);
             map.put("drugCureType",drugCureType);
             map.put("drugType",drugType);
//        //总数量
             int allCount= drugService.getAllCount(map);
             Map<String,Object> mapx=  SplitPage.SplitPage(currentPage,pageTag,5,allCount);
//             int startIndex=(Integer) mapx.get("startIndex");
//             int rowNum=(Integer) mapx.get("rowNum");
                int newCurrentPage= (Integer)mapx.get("newCurrentPage");
                int startIndex=(Integer)mapx.get("startIndex");
                if(startIndex<0){
                    startIndex=0;
                    map.put("startIndex",0);
                }
                else{
                    map.put("startIndex",mapx.get("startIndex"));
                }
              map.put("rowNum",5);
             //查询物品集合
             List<SysDrug> drugList=drugService.getListPageDrugByMap(map);
            //得到下拉框集合
             List<SysSelectedType> drugCureTypeList= typeService.getSelectValueListByTypeName("drugCureType");
             List<SysSelectedType> drugTypeList=  typeService.getSelectValueListByTypeName("drugType");
             request.setAttribute("drugCureTypeList",drugCureTypeList);
             request.setAttribute("drugTypeList",drugTypeList);
             request.setAttribute("drugList",drugList);
             request.setAttribute("newCurrentPage",newCurrentPage);
            if("".equals(newCurrentPage)){
                request.setAttribute("newCurrentPage",1);
            }
            if(0==newCurrentPage){
                request.setAttribute("newCurrentPage",1);
            }
            request.getRequestDispatcher("page/drugModule/DrugPanel.jsp").forward(request,response);
        }
          else{
             if ("addBtn".equals(pageTag)){
                 List<SysSelectedType> drugCureTypeList= typeService.getSelectValueListByTypeName("drugCureType");
                 List<SysSelectedType> drugTypeList=  typeService.getSelectValueListByTypeName("drugType");
                 request.setAttribute("drugCureTypeList",drugCureTypeList);
                 request.setAttribute("drugTypeList",drugTypeList);
                 request.getRequestDispatcher("page/drugModule/DrugAdd.jsp").forward(request,response);
                 return;
             }
         }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }
}
