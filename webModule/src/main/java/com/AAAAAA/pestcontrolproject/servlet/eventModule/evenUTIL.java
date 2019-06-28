package com.AAAAAA.pestcontrolproject.servlet.eventModule;

import com.AAAAAA.pestcontrolproject.entity.areaAndClassModule.SysArea;
import com.AAAAAA.pestcontrolproject.entity.areaAndClassModule.SysClass;

import java.util.ArrayList;
import java.util.List;

public class evenUTIL {

    SysClass findClass(String areaId){

        List<SysClass> sysClassList=new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            SysClass sysClass=new SysClass();
            sysClass.setSclassId(i);
            sysClass.setSclassName("第"+i+"班");
            sysClassList.add(sysClass);
        }
        // 区域id不为空
        String className="";
        Long classId=null;
        SysClass aClass=new SysClass();
        if(areaId!=null&&areaId.length()>0){
            //查找班级名称
            for (int i=0;i<sysClassList.size();i++) {
                if (Integer.parseInt(areaId)==i+1){
                    aClass.setSclassName(sysClassList.get(i).getSclassName());
                    aClass.setSclassId(sysClassList.get(i).getSclassId());
                }
            }
        }
        return aClass;
    }
    SysArea  findArea(String areaId ){
        SysArea area1=new SysArea();
        String name=null;
        List<SysArea> areaList=new ArrayList<>();
        for (int i=1;i<4;i++){
            SysArea area=new SysArea();
            area.setAreaId(i);
            area.setAreaName("四川"+i+"区");
            areaList.add(area);
        }
        for (int i=1;i<=areaList.size();i++){
          if (areaList.get(i-1).getAreaId()==Integer.parseInt(areaId)){
              name=areaList.get(i-1).getAreaName();
              area1.setAreaName(name);
            }
        }
        area1.setAreaId(Integer.parseInt(areaId));
        return  area1;
    }
    String findDisasterStage(String disasterStageId){
        String[] arr={"已得到控制","防治中","无法解决申请会商"};
        String disasterStage="";
        int id=Integer.parseInt(disasterStageId);
        if (id<=arr.length){
            disasterStage=arr[id-1];
        }
        return disasterStage;
    }
    String findWay(String findId){
        String[] arr={"小班巡查发现","公众发现","上级部门巡查通报"};
        String way="";
        int id=Integer.parseInt(findId);
        if (id<=arr.length){
            way=arr[id-1];
        }
        return way;
    }
    String findType(String TypeId){
        String[] arr={"虫害","病害","鼠害"};
        String way="";
        int id=Integer.parseInt(TypeId);
        if (id<=arr.length){
            way=arr[id-1];
        }
        return way;
    }

}
