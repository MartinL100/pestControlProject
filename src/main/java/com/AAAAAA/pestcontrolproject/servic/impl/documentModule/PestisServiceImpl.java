package com.AAAAAA.pestcontrolproject.servic.impl.documentModule;

import com.AAAAAA.pestcontrolproject.dao.documentModule.IdiseaseDao;
import com.AAAAAA.pestcontrolproject.dao.documentModule.IpestisDao;
import com.AAAAAA.pestcontrolproject.entity.documentModule.DiseaseBean;
import com.AAAAAA.pestcontrolproject.entity.documentModule.pestisBean;
import com.AAAAAA.pestcontrolproject.servic.documentModule.IpestisService;
import com.AAAAAA.pestcontrolproject.util.GetSession;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class PestisServiceImpl implements IpestisService {
    @Override
    public List<pestisBean> getListPestis(Map map) {
        SqlSession session = GetSession.getSession();
        List<pestisBean> listPestis = session.getMapper(IpestisDao.class).getListPestis(map);
        return listPestis;
    }

    @Override
    public pestisBean AllPestis(int pestisId) {
        SqlSession session = GetSession.getSession();
        pestisBean pestisBean = session.getMapper(IpestisDao.class).AllPestis(pestisId);
        return pestisBean;
    }

    @Override
    public boolean AddPestis(pestisBean pestisBean) {
        SqlSession session = GetSession.getSession();
        int pestisByName = session.getMapper(IpestisDao.class).getPestisByName(pestisBean.getPestisName());
        if (pestisByName>0){
            session.close();
            return true;
        }else {
            session.getMapper(IpestisDao.class).AddPestis(pestisBean);
            session.commit();
            return false;
        }


    }

    @Override
    public int getPestisByName(String pestisName) {
        return 0;
    }


    @Override
    public List<pestisBean> getNamePestis(Map map) {
        SqlSession session = GetSession.getSession();
        List<pestisBean> bypestis = session.getMapper(IpestisDao.class).getBypestis(map);
        return bypestis;
    }

    @Override
    public int getPestis(Map map) {
        SqlSession session = GetSession.getSession();
        int countPestis = session.getMapper(IpestisDao.class).getCountPestis(map);
        return countPestis;
    }
}
