package com.AAAAAA.pestcontrolproject.servlet.documentModule.disease;

import com.AAAAAA.pestcontrolproject.entity.documentModule.DiseaseBean;
import com.AAAAAA.pestcontrolproject.servic.documentModule.IdiseaseService;
import com.AAAAAA.pestcontrolproject.servic.impl.documentModule.DiseaseServiceImpl;
import com.AAAAAA.pestcontrolproject.util.PageUtil;
import com.AAAAAA.pestcontrolproject.util.Verify;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetNameServlet extends HttpServlet {
          IdiseaseService idiseaseService=new DiseaseServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doPost(request,response);
    }
}
