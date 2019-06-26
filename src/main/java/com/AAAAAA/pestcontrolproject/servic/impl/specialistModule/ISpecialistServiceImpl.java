package com.AAAAAA.pestcontrolproject.servic.impl.specialistModule;

import com.AAAAAA.pestcontrolproject.dao.specialistModule.ISpecialistDao;
import com.AAAAAA.pestcontrolproject.entity.specialistModule.TSpecialist;
import com.AAAAAA.pestcontrolproject.servic.specialistModule.ISpecialistService;
import com.AAAAAA.pestcontrolproject.util.GetSession;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class ISpecialistServiceImpl implements ISpecialistService {

    @Override
    public boolean addSpecialist(TSpecialist specialist) {
        SqlSession session = GetSession.getSession();
        int a = session.getMapper(ISpecialistDao.class).addSpecialist(specialist);
        session.commit();
        session.close();
        if (a == 1) {
            return true;
        }
        return false;
    }

    @Override
    public TSpecialist findSpecialistById(String specialistId) {
        SqlSession session = GetSession.getSession();
        TSpecialist specialist = session.getMapper(ISpecialistDao.class).findSpecialistById(specialistId);
        session.close();
        return specialist;
    }

    @Override
    public boolean updateSpecialist(Map map) {
        SqlSession session = GetSession.getSession();
        int a = session.getMapper(ISpecialistDao.class).updateSpecialist(map);
        session.commit();
        session.close();
        if (a == 1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean delSpecialistById(String specialistId) {
        SqlSession session = GetSession.getSession();
        int a = session.getMapper(ISpecialistDao.class).delSpecialistById(specialistId);
        session.commit();
        session.close();
        if (a == 1) {
            return true;
        }
        return false;
    }

    @Override
    public List<TSpecialist> findSpecialistList(Map map) {
        SqlSession session = GetSession.getSession();
        List<TSpecialist> list = session.getMapper(ISpecialistDao.class).findSpecialistList(map);
        session.close();
        return list;

    }

    @Override
    public int findCountRow(Map map) {
        SqlSession session=GetSession.getSession();
      int countRow = session.getMapper(ISpecialistDao.class).findCountRow(map);
        return countRow;
    }
}
