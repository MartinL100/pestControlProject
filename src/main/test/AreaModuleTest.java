import com.AAAAAA.pestcontrolproject.entity.Selected.SysSelectedType;
import com.AAAAAA.pestcontrolproject.entity.areaAndClassModule.SysArea;
import com.AAAAAA.pestcontrolproject.servic.areaAndClassModule.IAreaSevice;
import com.AAAAAA.pestcontrolproject.servic.impl.areaAndClassModule.AreaServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AreaModuleTest {
    public static     IAreaSevice areaSevice;
    @Before
    public void getService(){
        areaSevice=new AreaServiceImpl();
    }
    @Test
    public void addAreaTest(){
        SysArea area=new SysArea();
        SysSelectedType selectedType=new SysSelectedType();
        selectedType.setTypeId(1);
        area.setAreaGoodTree("细针灌木");
        area.setAreaName("西南片区");
        area.setAreaTreeType("灌木");
        area.setSelectedType(selectedType);
        String info=areaSevice.addArea(area);
        System.out.println(info);
    }
    @Test
    public void findAreaListTest(){
        Map<String,String> map=new HashMap();
        map.put("areaName","西南片区");
        map.put("areaTreeType","灌木");
        map.put("sclassName","J168");
       List<SysArea> areaList= areaSevice.findAreaList(map);
        System.out.println(areaList.size());
    }
}
