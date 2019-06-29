package com.AAAAAA.pestcontrolproject.servlet.drugModule;

import com.AAAAAA.pestcontrolproject.entity.Selected.SysSelectedType;
import com.AAAAAA.pestcontrolproject.entity.drugModule.SysDrug;
import com.AAAAAA.pestcontrolproject.servic.drugModule.IDrugService;
import com.AAAAAA.pestcontrolproject.servic.impl.drugModule.DrugServiceImpl;
import com.AAAAAA.pestcontrolproject.service.selectedType.ISelectedTypeService;
import com.AAAAAA.pestcontrolproject.service.selectedType.impl.SelectedTypeImpl;
import com.AAAAAA.pestcontrolproject.util.SplitPage;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OutWareHouseAddObjServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IDrugService drugService = new DrugServiceImpl();
        ISelectedTypeService typeService = new SelectedTypeImpl();
       PrintWriter pw= response.getWriter();
        String drugCureType = "";
        String drugType = "";
        String drugName = "";
        //得到分页标签
        String pageTag = request.getParameter("PageTag");
        if (!"getBtn".equals(pageTag)) {
            //初始化页面
            if("findBtn".equals(pageTag)){
                pageTag="";
            }
            drugCureType = request.getParameter("drugCureType");
            drugType = request.getParameter("drugType");
            drugName = request.getParameter("drugName");
            String currentPage = request.getParameter("sonCurrentPage");
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
            if (startIndex <= 0) {
                startIndex = 0;
                map.put("startIndex", 0);
            } else {
                map.put("startIndex", mapx.get(startIndex));
            }
            map.put("rowNum", 5);
            //查询物品集合
            List<SysDrug> drugList = drugService.getListPageDrugByMap(map);
            //得到下拉框集合
//            request.setAttribute("drugList", drugList);
            //request.setAttribute("sonCurrentPage", newCurrentPage);
            ObjectMapper objectMapper=new ObjectMapper();
            String JsonStr= objectMapper.writeValueAsString(drugList);
            pw.write(JsonStr);
            pw.close();
            return;
        } else {
            if ("getBtn".equals(pageTag)) {
                //得到父页面转发过来的id数组
                //String[] drugIdList = (String[]) request.getAttribute("drugIdList");
             String fatherStr=   request.getParameter("fatherStr");
             String sonStr= request.getParameter("sonStr");
             String[] fatherIdArr= fatherStr.split("\\,");
                String[] boxId =   sonStr.split("\\,");
                //得到父类中所有表格中的drugId
                //获取所有被选中的checkbox中val
                //定义数组添加
                List<SysDrug> list = new ArrayList<>();
                int len=0;
                if(null!=fatherIdArr&&"".equals(fatherIdArr)){
                    if(fatherIdArr.length>boxId.length){
                        len=fatherIdArr.length;
                    }
                    else{
                        len=boxId.length;
                    }
                    //根据id得到对象塞入集合
                    for (int i = 0; i < len; i++) {
                        if (fatherIdArr[i] != boxId[i]) {
                            int drugId = Integer.parseInt(boxId[i]);
                            SysDrug drug = drugService.getDrugById(drugId);
                            list.add(drug);
                        }
                    }
                }
                else{
                    len=boxId.length;
                    //根据id得到对象塞入集合
                    for (int i = 0; i < len; i++) {
                            int drugId = Integer.parseInt(boxId[i]);
                            SysDrug drug = drugService.getDrugById(drugId);
                            list.add(drug);
                    }
                }

                //将得到的集合转换为json字符串传给页面
                ObjectMapper objectMapper=new ObjectMapper();
                String JsonStr= objectMapper.writeValueAsString(list);
                pw.write(JsonStr);
                pw.close();
//                request.setAttribute("MessageVoList",list);
               // List<SysDrug> l= (List<SysDrug>)request.getAttribute("drugList");
//                request.getRequestDispatcher("OutWareHouseAddServlet.lovo").forward(request, response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

}
