package com.AAAAAA.pestcontrolproject.servic.impl.drugModule;

import com.AAAAAA.pestcontrolproject.dao.drugModule.IDrugDao;

import com.AAAAAA.pestcontrolproject.entity.drugModule.SysDrug;

import com.AAAAAA.pestcontrolproject.servic.drugModule.IDrugService;
import com.AAAAAA.pestcontrolproject.util.GetSession;
import com.AAAAAA.pestcontrolproject.vo.drugModule.SysDrugAddVo;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class DrugServiceImpl  implements IDrugService {
    @Override
    public List<SysDrug> getListPageDrugByMap(Map<String, Object> map) {
        SqlSession session= GetSession.getSession();
        IDrugDao dao=  session.getMapper(IDrugDao.class);
        List<SysDrug> list= dao.getListPageDrugByMap(map);
        session.close();
        return list;
    }

    @Override
    public int getAllCount(Map<String, Object> map) {
        SqlSession session= GetSession.getSession();
        IDrugDao dao=  session.getMapper(IDrugDao.class);
        int count=dao.getAllCount(map);
        session.close();
        return count;
    }

    @Override
    public void saveSysDrug(SysDrugAddVo drug) {
        SqlSession session= GetSession.getSession();
        IDrugDao dao=  session.getMapper(IDrugDao.class);
        dao.saveSysDrug(drug);
        session.close();
    }
}
