import com.AAAAAA.pestcontrolproject.entity.areaAndClassModule.SysArea;
import com.AAAAAA.pestcontrolproject.entity.areaAndClassModule.SysClass;
import com.AAAAAA.pestcontrolproject.servic.areaAndClassModule.IClassServic;
import com.AAAAAA.pestcontrolproject.servic.impl.areaAndClassModule.ClassServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassTest {
    IClassServic servic=new ClassServiceImpl();
    Map map=new HashMap();
    @Test
    public void findClassByClassIdTest(){
        map.put("sclassId",1);
        SysClass sysClass=servic.findClassByClassId(map);
        System.out.println(sysClass);
    }
    @Test
    public void findClassList(){
        map.put("sclassName","J168");
        map.put("areaName","西南片区");
       List<SysClass>  sysClass=servic.findClassList(map);
        System.out.println(sysClass);
    }
    @Test
    public void addClassTest(){
        SysClass sysClass=new SysClass();
        SysArea sysArea=new SysArea();
        sysArea.setAreaId(2);
        sysClass.setArea(sysArea);
        sysClass.setSclassLeader("阿亮");
        sysClass.setSclassLeaderTel("1383838438");
        sysClass.setSclassName("火箭班");
        sysClass.setSclassNum(50);
        sysClass.setSclassStartDate("2019-01-09");
        String info =servic.addSysClass(sysClass);
        System.out.println(info);
    }

    @Test
    public void updateClassTest(){
        map.put("sclassId",1);
        map.put("sclassLeaderTel","13990999999");
        map.put("sclassLeader","赵云");
        String info=servic.updateClass(map);
        System.out.println(info);
    }
    @Test
    public void findClassTest(){
        map.put("areaId",1);
       SysClass sysClass= servic.findClassByAreaId(map);
        System.out.println(sysClass);
    }
}
