import com.AAAAAA.pestcontrolproject.dao.drugModule.IDrugDao;
import com.AAAAAA.pestcontrolproject.dao.drugModule.IStockpileDao;
import com.AAAAAA.pestcontrolproject.dao.selectedType.ISelectedTypeDao;
import com.AAAAAA.pestcontrolproject.entity.Selected.SysSelectedType;
import com.AAAAAA.pestcontrolproject.entity.drugModule.*;
import com.AAAAAA.pestcontrolproject.servic.drugModule.IStockpileService;
import com.AAAAAA.pestcontrolproject.servic.impl.drugModule.StockpileServiceImpl;
import com.AAAAAA.pestcontrolproject.util.GetSession;
import com.AAAAAA.pestcontrolproject.vo.drugModule.SysDrugAddVo;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;


import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestDrug {
    @Test
    public void TestGetListPageDrugByMap(){
        SqlSession session= GetSession.getSession();
        IDrugDao dao=  session.getMapper(IDrugDao.class);
        Map<String,Object> map=new HashMap<>();
//        map.put("drugCureType","虫害");
//        map.put("drugType","器械");
        map.put("drugName","草");
        map.put("startIndex",0);
        map.put("rowNum",5);

        List<SysDrug> list= dao.getListPageDrugByMap(map);
        for (SysDrug s:list) {
            System.out.println(s);
        }
        int c=dao.getAllCount(map);
        System.out.println(c);
        session.close();
    }


    @Test
    public void TestGetDrugByID(){
        SqlSession session= GetSession.getSession();
        IDrugDao dao=  session.getMapper(IDrugDao.class);
        System.out.println(dao.getDrugById(1));
        session.close();
    }
    @Test
    public void TestSelectedTypeDao(){
        SqlSession session= GetSession.getSession();
        ISelectedTypeDao dao=  session.getMapper(ISelectedTypeDao.class);
       List<SysSelectedType> list=dao.getSelectValueListByTypeName("drugCureType");
    //    List<SysSelectedType> list=dao.getSelectValueListByTypeName("drugType");
//        System.out.println(list2);
        for (SysSelectedType s:list) {
            System.out.println(s);
        }
//        System.out.println("================================");
//        System.out.println(dao.getSelectedValueByID(1));

        List<SysSelectedType> Classlist= dao.getAllClass();
        for (SysSelectedType c: Classlist) {
            System.out.println(c.getTypeVal());
        }

        session.close();
    }

    @Test
    public void TestAllCount(){
        SqlSession session= GetSession.getSession();
        IDrugDao dao=  session.getMapper(IDrugDao.class);
        Map<String,Object> map=new HashMap<>();
        long x=dao.getAllCount(map);
        System.out.println(x);
        session.close();
    }

    @Test
    public void TestSaveAllCount(){
        SqlSession session= GetSession.getSession();
        IDrugDao dao=  session.getMapper(IDrugDao.class);
        SysDrugAddVo addVo=new SysDrugAddVo();
        addVo.setDrugName("捕鼠笼");
        addVo.setDrugCureTypeId(1);
        addVo.setDrugNum(100);
        addVo.setDrugTypeId(2);
        addVo.getDrugUseWay();
       dao.saveSysDrug(addVo);
       session.close();

    }

@Test
    public void Test(){
    SqlSession session =  GetSession.getSession();
    IStockpileDao dao =session.getMapper(IStockpileDao.class);
    Map<String,Object> map=new HashMap<>();
    map.put("startIndex",0);
    map.put("rowNum",5);
    map.put("startTime",new Date(System.currentTimeMillis()).toString());
    List<SysStockpile> list= dao.getSysDrugList(map);
    for (SysStockpile s:
         list) {
        System.out.println(s);
    }
    System.out.println(dao.getSysDrugByID(1));
    session.close();
    }

    @Test
    public  void  GetCount(){
        SqlSession session =  GetSession.getSession();
        IStockpileDao dao =session.getMapper(IStockpileDao.class);
        Map<String,Object> map=new HashMap<>();
        map.put("drugName","虫");
        int count=dao.GetCounts(map);
        System.out.println(count);
        session.close();
    }


    @Test
    public void TestGetListByid(){
        SqlSession session =  GetSession.getSession();
        IStockpileDao dao =session.getMapper(IStockpileDao.class);
        List<stockpileDrug> list=dao.getDrugListById(22);


        for (stockpileDrug s:list
             ) {
            System.out.println(s);
        }

        System.out.printf("============================");
        StockpileDrugVo drugVo=new StockpileDrugVo();
        drugVo.setDrugId(4);
        drugVo.setStockpileId(4);
        drugVo.setStockpileNum(20);
        System.out.println(dao.addStockpileDrug(drugVo));
        session.close();
    }

    @Test
    public void TestAddStoDrug(){
//        SqlSession session =  GetSession.getSession();
//        IStockpileDao dao =session.getMapper(IStockpileDao.class);
        IStockpileService dao=new StockpileServiceImpl();
        StockpileDrugVo drugVo=new StockpileDrugVo();
        StockpileDrugVo drugVo2=new StockpileDrugVo();
        drugVo.setDrugId(3);
        drugVo.setStockpileId(2);
        drugVo.setStockpileNum(2);

        drugVo2.setDrugId(4);
        drugVo2.setStockpileId(6);
        drugVo2.setStockpileNum(1);
        List<StockpileDrugVo> list=new ArrayList<>();
        list.add(drugVo);
        list.add(drugVo2);
        for (StockpileDrugVo svo:list) {
            System.out.println(dao.addStockpileDrug(svo));
        }
    }

@Test
    public void TestSaveSto(){
    SqlSession session =  GetSession.getSession();
    IStockpileDao dao =session.getMapper(IStockpileDao.class);
    StockpileVo vo=new StockpileVo();
    vo.setStockpileClassId(6);
    vo.setStockpileUserId(9);
    dao.saveStockpileDrug(vo);
    int id=vo.getStockpileId();
    System.out.println(id);
    }

}
