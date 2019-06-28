package com.AAAAAA.pestcontrolproject.servlet.areaAndClassModule;

import com.AAAAAA.pestcontrolproject.entity.Selected.SysSelectedType;
import com.AAAAAA.pestcontrolproject.entity.areaAndClassModule.SysArea;
import com.AAAAAA.pestcontrolproject.servic.areaAndClassModule.IAreaSevice;
import com.AAAAAA.pestcontrolproject.servic.impl.areaAndClassModule.AreaServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddAreaServlet extends HttpServlet {
    IAreaSevice areaSeviceareaTreeType=new AreaServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         SysArea area = new SysArea();
         String areaTreeType = request.getParameter("areaTreeType");
         String areaGoodTree = request.getParameter("areaGoodTree");
         String selectedType = request.getParameter("selectedType");

         area.setAreaTreeType(areaTreeType);
         area.setAreaGoodTree(areaGoodTree);

          SysSelectedType sysSelectedType=new SysSelectedType();
          sysSelectedType.setTypeId(Integer.parseInt(selectedType));
          area.setSelectedType(sysSelectedType);

          String Strare = areaSeviceareaTreeType.addArea(area);
          request.getRequestDispatcher("page/areaAndClassModule/areaPanel.jsp").forward(request,response);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          doPost(request,response);
    }
}
