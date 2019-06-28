package com.AAAAAA.pestcontrolproject.servlet.eventModule;

import com.AAAAAA.pestcontrolproject.entity.areaAndClassModule.SysArea;
import com.AAAAAA.pestcontrolproject.entity.areaAndClassModule.SysClass;
import com.AAAAAA.pestcontrolproject.entity.eventModule.Event;
import com.AAAAAA.pestcontrolproject.servic.eventModule.EventServiceImpl;
import com.AAAAAA.pestcontrolproject.servic.eventModule.IEventService;
import com.AAAAAA.pestcontrolproject.util.FileStringInfo;
import com.AAAAAA.pestcontrolproject.util.SplitPage;
import com.AAAAAA.pestcontrolproject.util.UploadUtil;
import com.AAAAAA.pestcontrolproject.util.Verify;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;


public class eventFindClassByAreaServlet extends HttpServlet {
    IEventService service = new EventServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        //条件map
        Map<String,Object> map=new HashMap<>();
        String areaId=request.getParameter("areaId");
        List<SysClass> sysClassList=new ArrayList<>();

        evenUTIL util=new evenUTIL();
        SysClass aClass=util.findClass(areaId);


        ObjectMapper objectMapper=new ObjectMapper();
        String jsonStr=objectMapper.writeValueAsString(aClass);
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        PrintWriter printWriter =response.getWriter();
        printWriter.write(jsonStr);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
