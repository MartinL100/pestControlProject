package com.AAAAAA.pestcontrolproject.servic.impl.drugModule;

import com.AAAAAA.pestcontrolproject.dao.drugModule.IDrugDao;
import com.AAAAAA.pestcontrolproject.dao.drugModule.IStockpileDao;
import com.AAAAAA.pestcontrolproject.entity.drugModule.StockpileDrugVo;
import com.AAAAAA.pestcontrolproject.entity.drugModule.StockpileVo;
import com.AAAAAA.pestcontrolproject.entity.drugModule.SysStockpile;
import com.AAAAAA.pestcontrolproject.entity.drugModule.stockpileDrug;
import com.AAAAAA.pestcontrolproject.servic.drugModule.IStockpileService;
import com.AAAAAA.pestcontrolproject.util.GetSession;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class StockpileServiceImpl implements IStockpileService {


    @Override
    public List<SysStockpile> getSysDrugList(Map map) {
        SqlSession session =  GetSession.getSession();
        IStockpileDao dao =session.getMapper(IStockpileDao.class);
        List<SysStockpile> list=dao.getSysDrugList(map);
        session.close();
        return list;
    }

    @Override
    public SysStockpile getSysDrugByID(int IStockpileID) {
        SqlSession session =  GetSession.getSession();
        IStockpileDao dao =session.getMapper(IStockpileDao.class);
        SysStockpile SysStockpile=dao.getSysDrugByID(IStockpileID);
        session.close();
        return SysStockpile;
    }

    @Override
    public int saveStockpileDrug(StockpileVo vo) {
        SqlSession session =  GetSession.getSession();
        IStockpileDao dao =session.getMapper(IStockpileDao.class);
        int id=dao.saveStockpileDrug(vo);
        session.commit();
        session.close();
        return id;
    }

    @Override
    public int GetCounts(Map map) {
        SqlSession session =  GetSession.getSession();
        IStockpileDao dao =session.getMapper(IStockpileDao.class);
        int count=dao.GetCounts(map);
        session.close();
        return count;
    }

    @Override
    public int addStockpileDrug(StockpileDrugVo DrugVo) {
        SqlSession session =  GetSession.getSession();
        IDrugDao drugdao=  session.getMapper(IDrugDao.class);
        int count= drugdao.getDrugById(DrugVo.getDrugId()).getDrugNum();
        IStockpileDao dao =session.getMapper(IStockpileDao.class);
        if(count-DrugVo.getStockpileNum()>=0){
         dao.addStockpileDrug(DrugVo);
         session.commit();
         session.close();
         return 1;
      }
        return -1;
    }

    @Override
    public List<stockpileDrug> getDrugListById(int ID) {
        SqlSession session =  GetSession.getSession();
        IStockpileDao dao =session.getMapper(IStockpileDao.class);
        List<stockpileDrug> list=dao.getDrugListById(ID);
        session.close();
        return list;
    }
//
//    @Override
//    public void removeStockpileDrug(int StockpileDrugID) {
//
//    }
}
