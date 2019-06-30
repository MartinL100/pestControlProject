package com.AAAAAA.pestcontrolproject.servlet.eventModule;

import com.AAAAAA.pestcontrolproject.entity.areaAndClassModule.SysClass;
import com.AAAAAA.pestcontrolproject.servic.impl.areaAndClassModule.ClassServiceImpl;
import com.AAAAAA.pestcontrolproject.servic.impl.eventModule.FindTypeServiceImpl;


import java.util.HashMap;
import java.util.Map;

public class test {


   public static void main(String[]args){

       Map<String,Object> map=new HashMap<>();



       FindTypeServiceImpl classService=new FindTypeServiceImpl();
       SysClass aClass= classService.findClaaByAreaId(1);
       System.out.println(aClass.getSclassName());
   }


}
