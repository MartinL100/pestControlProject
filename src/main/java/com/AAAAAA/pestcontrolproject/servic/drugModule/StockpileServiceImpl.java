package com.AAAAAA.pestcontrolproject.servic.drugModule;

import com.AAAAAA.pestcontrolproject.dao.drugModule.IStockpileDao;
import com.AAAAAA.pestcontrolproject.entity.drugModule.SysStockpile;
import com.AAAAAA.pestcontrolproject.entity.drugModule.stockpileDrug;
import com.AAAAAA.pestcontrolproject.util.GetSession;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class StockpileServiceImpl implements  IStockpileService {


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
    public void saveStockpileDrug() {

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
