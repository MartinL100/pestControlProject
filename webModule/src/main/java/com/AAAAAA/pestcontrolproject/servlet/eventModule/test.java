package com.AAAAAA.pestcontrolproject.servlet.eventModule;

import com.AAAAAA.pestcontrolproject.servic.impl.eventModule.FindTypeServiceImpl;

import java.util.HashMap;
import java.util.Map;

public class test {


   public static void main(String[]args){


       FindTypeServiceImpl service=new FindTypeServiceImpl();
       Map<String,Object> map =new HashMap<>();
       map.put("typeName","disasterStage");

       System.out.println(service.findType(map));

   }


}
