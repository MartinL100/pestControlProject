package com.AAAAAA.pestcontrolproject.servlet.drugModule;

import com.AAAAAA.pestcontrolproject.entity.Selected.SysSelectedType;
import com.AAAAAA.pestcontrolproject.entity.drugModule.StockpileDrugVo;
import com.AAAAAA.pestcontrolproject.entity.drugModule.StockpileVo;
import com.AAAAAA.pestcontrolproject.entity.drugModule.SysDrug;
import com.AAAAAA.pestcontrolproject.entity.userModule.TUser;
import com.AAAAAA.pestcontrolproject.servic.drugModule.IDrugService;
import com.AAAAAA.pestcontrolproject.servic.drugModule.IStockpileService;
import com.AAAAAA.pestcontrolproject.servic.impl.drugModule.DrugServiceImpl;
import com.AAAAAA.pestcontrolproject.servic.impl.drugModule.StockpileServiceImpl;
import com.AAAAAA.pestcontrolproject.service.selectedType.ISelectedTypeService;
import com.AAAAAA.pestcontrolproject.service.selectedType.impl.SelectedTypeImpl;
import com.AAAAAA.pestcontrolproject.util.SplitPage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OutWareHouseAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tag=request.getParameter("checkType");
        ISelectedTypeService typeService=new SelectedTypeImpl();
        IStockpileService stockpileService=new StockpileServiceImpl();
        IDrugService drugService = new DrugServiceImpl();
        String pageTag = request.getParameter("PageTag");
        String drugCureType = "";
        String drugType = "";
        String drugName = "";

        //初始化页面
    if(null==tag||"".equals(tag)){
        //得到班级下拉框所有
        List<SysSelectedType> Classlist=typeService.getAllClass();
        request.setAttribute("ClassNameList",Classlist);
        request.setAttribute("userObj",request.getSession().getAttribute("userObj"));
        List<SysDrug> list=(List<SysDrug>)request.getAttribute("MessageVoList");
//        request.setAttribute("test","test111");
        request.setAttribute("MessageVoList",list);
        if (!"getBtn".equals(pageTag)) {
            //初始化页面
            drugCureType = request.getParameter("drugCureType");
            drugType = request.getParameter("drugType");
            drugName = request.getParameter("drugName");
            String currentPage = request.getParameter("currentPage");
            Map<String, Object> map = new HashMap<>();
            map.put("drugName", drugName);
            map.put("drugCureType", drugCureType);
            map.put("drugType", drugType);
//        //总数量
            int allCount = drugService.getAllCount(map);
            Map<String, Object> mapx = SplitPage.SplitPage(currentPage, pageTag, 5, allCount);
//             int startIndex=(Integer) mapx.get("startIndex");
//             int rowNum=(Integer) mapx.get("rowNum");
            int newCurrentPage = (Integer) mapx.get("newCurrentPage");
            int startIndex = (Integer) mapx.get("startIndex");
            if (startIndex <=0) {
                startIndex = 0;
                map.put("startIndex", 0);
            } else {
                map.put("startIndex", mapx.get(startIndex));
            }
            map.put("rowNum", 5);
            //查询物品集合
            List<SysDrug> drugList = drugService.getListPageDrugByMap(map);
            //得到下拉框集合
            List<SysSelectedType> drugCureTypeList = typeService.getSelectValueListByTypeName("drugCureType");
            List<SysSelectedType> drugTypeList = typeService.getSelectValueListByTypeName("drugType");
            request.setAttribute("drugCureTypeList", drugCureTypeList);
            request.setAttribute("drugTypeList", drugTypeList);
            request.setAttribute("drugList", drugList);
            request.setAttribute("newCurrentPage",newCurrentPage);
            if("".equals(newCurrentPage)){
                request.setAttribute("newCurrentPage",1);
            }

        }
        //转发
        request.getRequestDispatcher("page/drugModule/OutWareHouseAdd.jsp").forward(request,response);
//      String tag2=request.getParameter("tag2");
//        if(tag2.equals("1"))
//        request.getRequestDispatcher("test.jsp").forward(request,response);
        return;
    }
    //    //如果点击的是添加按钮 将表格中的数据转发到 添加addObj页面
    //     if("addBtn".equals(tag)){
    //         //得到table中的id和num
    //      String[] drugIdList =   request.getParameterValues("drugId");
    //      String[] countNumList=  request.getParameterValues("countNum");
    //      request.setAttribute("drugIdList",drugIdList);
    //      request.setAttribute("countNumList",countNumList);
    //      request.getRequestDispatcher("OutWareHouseAddObjServlet.lovo").forward(request,response);
    //    }


//         if("removeBtn".equals(tag)) {
//             String trId = request.getParameter("trId");
//             int id = Integer.parseInt(trId);
//             SysDrug drug = drugService.getDrugById(id);
//             List<SysDrug> list = (List) request.getAttribute("MessageVoList");
//             for (SysDrug s : list) {
//                 if (s.getDrugId() == (drug.getDrugId())) {
//                     list.remove(s);
//                 }
//             }
//             request.setAttribute("MessageVoList",list);
//             request.getRequestDispatcher("page/drugModule/OutWareHouseAdd.jsp").forward(request, response);
//
//         }

         if("outBtn".equals(tag)){
             //得到所有num和id
             String[] countNumArr=  request.getParameterValues("DrugCounts");
             String[] drugIdArr= request.getParameterValues("AlldrugId");
             TUser user= (TUser) request.getSession().getAttribute("userObj");
             String classID= request.getParameter("SelectedClassName");
             long classid=Integer.parseInt(classID);
            int stoID=0;
            if(null!=countNumArr&&null!=drugIdArr){
                //得到当前用户id
//            long userId=user.getUserId();
//           String RealName= user.getRealName();
               long userId=1;
                StockpileVo vo= new StockpileVo();
                vo.setStockpileUserId(userId);
                vo.setStockpileClassId(classid);
                //得到新建的订单的id
               stoID= stockpileService.saveStockpileDrug(vo);
               //将得到数据遍历出来 依次添加中间表数据
               for (int i=0;i<countNumArr.length;i++){
                  int count=   Integer.parseInt(countNumArr[i]);
                  int drugId=Integer.parseInt(drugIdArr[i]);
                   StockpileDrugVo drugVo=new StockpileDrugVo();
                   drugVo.setDrugId(drugId);
                   drugVo.setStockpileId(stoID);
                   drugVo.setStockpileNum(count);
                 int resultCount=  stockpileService.addStockpileDrug(drugVo);
               }
               //添加完毕
            }

             else{
                return;
            }
         }

//        if ("getBtn".equals(pageTag)) {
//            //得到父页面转发过来的id数组
//            //String[] drugIdList = (String[]) request.getAttribute("drugIdList");
//            //得到父类中所有表格中的drugId
//            String[] parentIdArr=  request.getParameterValues("drugId");
//            //获取所有被选中的checkbox中val
//            //定义数组添加
//            List<SysDrug> list = new ArrayList<>();
//            String[] boxId = request.getParameterValues("box");
//            int len=0;
//            if(null!=parentIdArr){
//                if(parentIdArr.length>boxId.length){
//                    len=parentIdArr.length;
//                }
//                else{
//                    len=boxId.length;
//                }
//                //根据id得到对象塞入集合
//                for (int i = 0; i < len; i++) {
//                    if (parentIdArr[i] != boxId[i]) {
//                        int drugId = Integer.parseInt(boxId[i]);
//                        SysDrug drug = drugService.getDrugById(drugId);
//                        list.add(drug);
//                    }
//                }
//            }
//            else{
//                len=boxId.length;
//                //根据id得到对象塞入集合
//                for (int i = 0; i < len; i++) {
//                    int drugId = Integer.parseInt(boxId[i]);
//                    SysDrug drug = drugService.getDrugById(drugId);
//                    list.add(drug);
//                }
//            }
//
//            request.setAttribute("MessageVoList",list);
//            // List<SysDrug> l= (List<SysDrug>)request.getAttribute("drugList");
//            request.getRequestDispatcher("page/drugModule/OutWareHouseAdd.jsp").forward(request, response);
//        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doPost(request,response);
    }
}
