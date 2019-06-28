import com.AAAAAA.pestcontrolproject.entity.userModule.MenuVO;
import com.AAAAAA.pestcontrolproject.entity.userModule.TPower;
import com.AAAAAA.pestcontrolproject.servic.impl.userModule.PowerServiceImpl;
import com.AAAAAA.pestcontrolproject.servic.userModule.IPowerService;
import com.AAAAAA.pestcontrolproject.util.CheckString;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PowerTest {
    @Test
    public void findPowerList(){
        Map map=new HashMap();
        map.put("roleId",1);
        IPowerService powerService=new PowerServiceImpl();
       List<TPower> powers= powerService.findMenuPowers(map);

       //筛选power
        List<MenuVO> menuVOList=new ArrayList<>();
        MenuVO menuObj =new MenuVO();
        List<TPower> powerList=new ArrayList<>();

        long key =-1;
        for (TPower power:powers) {
            //判断分组标记
            if(power.getPowerTag()!=key){
                if(key!=-1){
                    menuObj.setSecendMenu(powerList);
                    menuVOList.add(menuObj);
                }
                //重新赋值分组标记
                key=power.getPowerTag();
                //创建新的vo对象和新的power集合
                 menuObj=new MenuVO();
                 powerList=new ArrayList<>();
            }
            if(CheckString.isNull(power.getPowerResource())){
                //筛选一级菜单
                menuObj.setFirstMenu(power);
            }else {
                //筛选二级菜单
                powerList.add(power);
            }
        }
        //添加最后一次循环的菜单栏
        menuVOList.add(menuObj);



        System.out.println(menuVOList.size());







    }
}
