package com.AAAAAA.pestcontrolproject.servlet.eventModule;

import com.AAAAAA.pestcontrolproject.entity.areaAndClassModule.SysArea;
import com.AAAAAA.pestcontrolproject.entity.areaAndClassModule.SysClass;
import com.AAAAAA.pestcontrolproject.entity.eventModule.Event;
import com.AAAAAA.pestcontrolproject.entity.specialistModule.ConferenceResult;
import com.AAAAAA.pestcontrolproject.entity.specialistModule.TConference;
import com.AAAAAA.pestcontrolproject.entity.specialistModule.TSpecialist;
import com.AAAAAA.pestcontrolproject.servic.impl.eventModule.AddConfServiceImpl;
import com.AAAAAA.pestcontrolproject.servic.impl.eventModule.EventServiceImpl;
import com.AAAAAA.pestcontrolproject.servic.eventModule.IEventService;
import com.AAAAAA.pestcontrolproject.servic.impl.eventModule.FindTypeServiceImpl;
import com.AAAAAA.pestcontrolproject.servic.impl.specialistModule.IConferenceResultServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class eventShowServlet extends HttpServlet {
    IEventService service = new EventServiceImpl();
    IConferenceResultServiceImpl iConferenceResultService=new IConferenceResultServiceImpl();
    AddConfServiceImpl addConfService=new AddConfServiceImpl();
    FindTypeServiceImpl findTypeService=new FindTypeServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        Map<String,Object> map=new HashMap<>();
        int eventId=Integer.parseInt(request.getParameter("eventId"));
        map.put("eventId",eventId);

        //查找所有事件对象集合
        List<Event> eventsList =service.findAllByMap(map);
        Event event=eventsList.get(0);
        //查询班级、区域信息
        evenUTIL util=new evenUTIL();
        SysClass aClass=findTypeService.findClaaByAreaId(event.getAreaId()).get(0);
        SysArea  area=findTypeService.findAreaByAreaId(event.getAreaId()).get(0);

        request.setAttribute("className",aClass.getSclassName());
        request.setAttribute("area",area.getAreaName());
        request.setAttribute("disasterStage",util.findDisasterStage(event.getDisasterStage()+""));
        request.setAttribute("findWay",util.findWay(event.getFindWay()+""));
        request.setAttribute("disasterType",util.findType(event.getDisasterType()+""));

        //将对象放入request
        request.setAttribute("event",event);

        //判段是修改请求还是查看信息请求
        String showOrUpdate=request.getParameter("showOrUp");
        if("show".equals(showOrUpdate)){

//            查找会商信息,并保存到request中
            List<TConference> tConferences=addConfService.findConfIdByEventId(eventId);
            Long i=tConferences.get(0).getConferenceId();
            int a=i.intValue();
            List<ConferenceResult> conferenceResults=iConferenceResultService.findConferenceByConferenceId(a+"");
//            List<ConferenceResult> conferenceResults=new ArrayList<>();
//            ConferenceResult test=new ConferenceResult();
//            List<TSpecialist> specialist= new ArrayList<>();
//            TSpecialist special=new TSpecialist();
//            specialist.add(special);
//            test.setSpecialistList(specialist);
//            conferenceResults.add(test);

            request.setAttribute("conferenceResults",conferenceResults);
            request.getRequestDispatcher("page/eventModule/eventShow.jsp").forward(request,response);
        }
        else if("update".equals(showOrUpdate)){
            // 请求转发到更新页面
            request.getRequestDispatcher("page/eventModule/eventUpdate.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
