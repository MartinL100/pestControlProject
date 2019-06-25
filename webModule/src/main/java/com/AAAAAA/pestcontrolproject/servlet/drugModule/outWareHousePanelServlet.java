package com.AAAAAA.pestcontrolproject.servlet.drugModule;

import com.AAAAAA.pestcontrolproject.entity.drugModule.SysStockpile;
import com.AAAAAA.pestcontrolproject.entity.drugModule.stockpileDrug;
import com.AAAAAA.pestcontrolproject.servic.drugModule.IStockpileService;
import com.AAAAAA.pestcontrolproject.servic.drugModule.StockpileServiceImpl;
import com.AAAAAA.pestcontrolproject.util.PageUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class outWareHousePanelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Tag= request.getParameter("checkType");
        IStockpileService stockpileService=new StockpileServiceImpl();
        //初始化
        if("".equals(Tag)||null==Tag){
            //获取所有订单前五条数据
            Map<String,Object> map= new HashMap();
            //初始化起始位置和显示数量
            map.put("startPage",0);
            map.put("countPage",5);

            //查询出所有数据中前五条
            List<SysStockpile> stockpileList = stockpileService.getSysDrugList(map);
            int count=  stockpileService.GetCounts(map);
            PageUtil page=new PageUtil();
            page.setAllCount(count);
            page.setCurrentPage(1,"firstPage");
            //将list放入到request中转发回页面
            request.setAttribute("stockpileList",stockpileList);
            request.setAttribute("page",page);
            request.getRequestDispatcher("page/drugModule/outwarehousePanel.jsp").forward(request,response);
        }
        else if("findByIDbtn".equals(Tag)){
           String Trid=request.getParameter("TrId");

            if(null==Trid|| "".equals(Trid)){
               return;
            }
            int id= Integer.parseInt(request.getParameter("TrId"));
          //得到该订单下的商品详情
            List<stockpileDrug> Druglist= stockpileService.getDrugListById(id);
            //得到该订单对象
          SysStockpile Stockpile=  stockpileService.getSysDrugByID(id);

          Stockpile.setDrugList(Druglist);
            //放入到request中
          request.setAttribute("Stockpile",Stockpile);
          //转发出去
          request.getRequestDispatcher("page/drugModule/outwarehouseUpdate.jsp").forward(request,response);
        }
        else if("addBtn".equals(Tag)){

        }
        else{

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doPost(request,response);
    }
}
