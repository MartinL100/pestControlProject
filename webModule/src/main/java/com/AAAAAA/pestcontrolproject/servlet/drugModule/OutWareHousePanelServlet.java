package com.AAAAAA.pestcontrolproject.servlet.drugModule;

import com.AAAAAA.pestcontrolproject.entity.drugModule.SysStockpile;
import com.AAAAAA.pestcontrolproject.entity.drugModule.stockpileDrug;
import com.AAAAAA.pestcontrolproject.servic.drugModule.IStockpileService;
import com.AAAAAA.pestcontrolproject.servic.impl.drugModule.StockpileServiceImpl;
import com.AAAAAA.pestcontrolproject.util.PageUtil;
import com.AAAAAA.pestcontrolproject.util.SplitPage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OutWareHousePanelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Tag= request.getParameter("checkType");
        IStockpileService stockpileService=new StockpileServiceImpl();
        //初始化
        if("".equals(Tag)||null==Tag){
            //获取所有订单前五条数据
            Map<String,Object> map= new HashMap();
            //初始化起始位置和显示数量
            map.put("startIndex",0);
            map.put("rowNum",5);
            //查询出所有数据中前五条
            List<SysStockpile> stockpileList = stockpileService.getSysDrugList(map);
            int count=  stockpileService.GetCounts(map);
            PageUtil page=new PageUtil();
            page.setAllCount(count);
            page.setCurrentPage(1,"firstPage");
            //将list放入到request中转发回页面
            request.setAttribute("stockpileList",stockpileList);
            request.setAttribute("newCurrentPage",page.getCurrentPage());
            request.getRequestDispatcher("page/drugModule/OutWareHousePanel.jsp").forward(request,response);
        }
        else if("findByIDbtn".equals(Tag)){
           String Trid=request.getParameter("TrId");

            if(null==Trid|| "".equals(Trid)){
               return;
            }
            int id= Integer.parseInt(request.getParameter("TrId"));
          //得到该订单下的商品详情
            // List<stockpileDrug> list=dao.getDrugListById(1);
            List<stockpileDrug> Druglist= stockpileService.getDrugListById(id);
            //得到该订单对象
          SysStockpile Stockpile=  stockpileService.getSysDrugByID(id);

          Stockpile.setDrugList(Druglist);
            //放入到request中
          request.setAttribute("Stockpile",Stockpile);
          //转发出去
          request.getRequestDispatcher("page/drugModule/OutWareHouseUpdate.jsp").forward(request,response);
        }
        //将主页面中table中的数据 drugIdList和countNumList转发到子页面
        else if("addBtn".equals(Tag)){
        String[] drugIdList=request.getParameterValues("drugId");
         String [] countNumList=   request.getParameterValues("countNum");
         request.setAttribute("drugIdList",drugIdList);
         request.setAttribute("countNumList",countNumList);
         request.getRequestDispatcher("OutWareHouseAddObjServlet.lovo").forward(request,response);
        }
        else{
         String startTime=     request.getParameter("startTime");
         String endTime=    request.getParameter("endTime");
         String className=   request.getParameter("className");
         Map<String,Object> map=new HashMap<>();
//            System.out.printf(startTime);
//            System.out.printf(endTime);
         map.put("startTime",startTime);
         map.put("endTime",endTime);
         map.put("className",className);
         int count=   stockpileService.GetCounts(map);
            String currentPage=  request.getParameter("currentPage");
            Map<String,Object> mapx=  SplitPage.SplitPage(currentPage,Tag,5,count);
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
            List<SysStockpile> stockpileList = stockpileService.getSysDrugList(map);
            request.setAttribute("stockpileList",stockpileList);
            request.setAttribute("newCurrentPage",mapx.get("newCurrentPage"));
            request.getRequestDispatcher("page/drugModule/OutWareHousePanel.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doPost(request,response);
    }
}
