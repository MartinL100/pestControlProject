package com.AAAAAA.pestcontrolproject.servlet.specialistModule;

import com.AAAAAA.pestcontrolproject.entity.Dto.ConferenceDto;
import com.AAAAAA.pestcontrolproject.entity.specialistModule.ConferenceResult;
import com.AAAAAA.pestcontrolproject.servic.impl.specialistModule.IConferenceDtoServiceImpl;
import com.AAAAAA.pestcontrolproject.servic.impl.specialistModule.IConferenceResultServiceImpl;
import com.AAAAAA.pestcontrolproject.servic.specialistModule.IConferenceDtoService;
import com.AAAAAA.pestcontrolproject.servic.specialistModule.IConferenceResultService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ConferenceEventServlet extends HttpServlet {
    IConferenceDtoService service = new IConferenceDtoServiceImpl();
IConferenceResultService resultService=new IConferenceResultServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String findEvent = req.getParameter("findEvent");//会商ID
        if (null == findEvent || "".equals(findEvent)) {
            List<ConferenceDto> list = service.allConference();
            req.setAttribute("conferenceEventList", list);
            //将事件集合转发到ConferenceEvent.jsp进行初始化
            req.getRequestDispatcher("page/specialistModule/ConferenceEvent.jsp").forward(req, resp);
        } else {

            //得到用户选择行的事件记录对象
            ConferenceDto conferenceDto = service.findEventByConferenceId(findEvent);
            //得到事件记录对象会审的结果集合
            List<ConferenceResult> resultList=   resultService.findConferenceByConferenceId(findEvent);
            //将事件记录对象和结果集合转发到会审界面ConferenceMain.jsp
            req.setAttribute("conferenceDto",conferenceDto);
            req.setAttribute("resultList",resultList);
            req.getRequestDispatcher("page/specialistModule/ConferenceMain.jsp").forward(req, resp);
        }
    }
}