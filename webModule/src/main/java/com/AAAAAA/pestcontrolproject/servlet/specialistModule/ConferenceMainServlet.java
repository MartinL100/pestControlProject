package com.AAAAAA.pestcontrolproject.servlet.specialistModule;

import com.AAAAAA.pestcontrolproject.entity.Dto.ConferenceDto;
import com.AAAAAA.pestcontrolproject.entity.specialistModule.ConferenceResult;
import com.AAAAAA.pestcontrolproject.entity.specialistModule.TSpecialist;
import com.AAAAAA.pestcontrolproject.servic.impl.specialistModule.IConferenceDtoServiceImpl;
import com.AAAAAA.pestcontrolproject.servic.impl.specialistModule.IConferenceResultServiceImpl;
import com.AAAAAA.pestcontrolproject.servic.impl.specialistModule.IResultSpecialistServiceImpl;
import com.AAAAAA.pestcontrolproject.servic.impl.specialistModule.ISpecialistServiceImpl;
import com.AAAAAA.pestcontrolproject.servic.specialistModule.IConferenceDtoService;
import com.AAAAAA.pestcontrolproject.servic.specialistModule.IConferenceResultService;
import com.AAAAAA.pestcontrolproject.servic.specialistModule.IResultSpecialistService;
import com.AAAAAA.pestcontrolproject.servic.specialistModule.ISpecialistService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

public class ConferenceMainServlet extends HttpServlet {
    IConferenceDtoService service = new IConferenceDtoServiceImpl();
    IConferenceResultService resultService = new IConferenceResultServiceImpl();
    ISpecialistService specialistService = new ISpecialistServiceImpl();
    IResultSpecialistService resultSpecialistService = new IResultSpecialistServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //初始化界面
        String findEvent = req.getParameter("findEvent");//会商ID
        String addResult1 = req.getParameter("addResult1");//添加、返回
        String conferenceResult1 = req.getParameter("conferenceResult");

        if (null == addResult1 || "".equals(addResult1)) {
            ConferenceDto conferenceDto = service.findEventByConferenceId(findEvent);
            //得到事件记录对象会审的结果集合
            List<ConferenceResult> resultList = resultService.findConferenceByConferenceId(findEvent);
            //查询所有的专家
            List<TSpecialist> specialistList = specialistService.findSpecialistNameList();
            //将事件记录对象和结果集合转发到会审界面ConferenceMainServlet
            req.setAttribute("findEvent", findEvent);
            req.setAttribute("conferenceDto", conferenceDto);
            req.setAttribute("resultList", resultList);
            req.setAttribute("specialistList", specialistList);
            req.getRequestDispatcher("page/specialistModule/ConferenceMain.jsp").forward(req, resp);
        } else if ("addResult1".equals(addResult1)) {
            //添加结果
            ConferenceResult conferenceResult = new ConferenceResult();
            conferenceResult.setConferenceDate(new Date(System.currentTimeMillis()).toString());//得到当前时间
            conferenceResult.setConferenceResult(conferenceResult1);
            conferenceResult.setConferenceId(findEvent);
            resultService.addConferenceResult(conferenceResult);//添加事件结果
            //得到参与专家
            String resultId = resultService.findResultByConference(findEvent);//得到结果ID
            String specialist = req.getParameter("specialist");//专家ID字符串
            String[] str = specialist.split("\\,");
            for (int i = 0; i < str.length; i++) {
                resultSpecialistService.addResultSpecialist(resultId, str[i]);
            }
            resp.sendRedirect("conferenceMain");
        } else if ("revert".equals(addResult1)) {
            //点击返回
            //重定向到ConferenceEvent.jsp
            resp.sendRedirect("conferenceEvent");
        }

    }
}
