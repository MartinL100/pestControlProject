package com.AAAAAA.pestcontrolproject.servlet.eventModule;

import com.AAAAAA.pestcontrolproject.entity.areaAndClassModule.SysClass;
import com.AAAAAA.pestcontrolproject.entity.specialistModule.TConference;
import com.AAAAAA.pestcontrolproject.servic.impl.areaAndClassModule.ClassServiceImpl;
import com.AAAAAA.pestcontrolproject.servic.impl.eventModule.AddConfServiceImpl;
import com.AAAAAA.pestcontrolproject.servic.impl.eventModule.FindTypeServiceImpl;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test {


   public static void main(String[]args){

//       Map<String,Object> map=new HashMap<>();
//
//
//
//       FindTypeServiceImpl classService=new FindTypeServiceImpl();
//       List<SysClass> aClass= classService.findClaaByAreaId(1);
//       System.out.println(aClass.get(0).toString());
       AddConfServiceImpl addConfService=new AddConfServiceImpl();

       List<TConference> tConferences=addConfService.findConfIdByEventId(2);
       Long a= tConferences.get(0).getConferenceId();

       System.out.println(a.intValue());
   }


}
