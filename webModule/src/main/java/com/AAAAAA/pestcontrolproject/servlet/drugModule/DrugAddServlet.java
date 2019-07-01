package com.AAAAAA.pestcontrolproject.servlet.drugModule;
import com.AAAAAA.pestcontrolproject.entity.Selected.SysSelectedType;
import com.AAAAAA.pestcontrolproject.servic.drugModule.IDrugService;
import com.AAAAAA.pestcontrolproject.servic.impl.drugModule.DrugServiceImpl;
import com.AAAAAA.pestcontrolproject.service.selectedType.ISelectedTypeService;
import com.AAAAAA.pestcontrolproject.service.selectedType.impl.SelectedTypeImpl;
import com.AAAAAA.pestcontrolproject.vo.drugModule.SysDrugAddVo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DrugAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IDrugService drugService=new DrugServiceImpl();
//        List<SysSelectedType> drugCureTypeList= (List<SysSelectedType>) request.getAttribute("drugCureTypeList");
//        List<SysSelectedType>  drugTypeList= (List<SysSelectedType>) request.getAttribute("drugTypeList");
//        if(null==drugCureTypeList&&null==drugTypeList){
//            ISelectedTypeService typeService=new SelectedTypeImpl();
//             drugCureTypeList= typeService.getSelectValueListByTypeName("drugCureType");
//             drugTypeList=  typeService.getSelectValueListByTypeName("drugType");
//            request.setAttribute("drugCureTypeList",drugCureTypeList);
//            request.setAttribute("drugTypeList",drugTypeList);
//            request.getRequestDispatcher("drugPanelPageServlet.lovo").forward(request,response);
//            return;
//        }
        String drugName=  request.getParameter("drugName");
        long drugCureTypeId=  Long.parseLong(request.getParameter("drugCureType"));
        long drugTypeId= Long.parseLong(request.getParameter("drugType"));
        String DrugUseWay =   request.getParameter("DrugUseWay");
        int num= Integer.parseInt(request.getParameter("drugNum"));
        SysDrugAddVo addVo =new SysDrugAddVo();
        addVo.setDrugTypeId(drugTypeId);
        addVo.setDrugCureTypeId(drugCureTypeId);
        addVo.setDrugUseWay(DrugUseWay);
        addVo.setDrugNum(num);
        addVo.setDrugName(drugName);
        drugService.saveSysDrug(addVo);

       // request.setAttribute("checkType","firstPage");
      //  request.getRequestDispatcher("page/drugModule/DrugPanel.jsp").forward(request,response);
        response.sendRedirect("drugPanelPageServlet.lovo");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doPost(request,response);
    }
}
