package com.AAAAAA.pestcontrolproject.servic.impl.specialistModule;

import com.AAAAAA.pestcontrolproject.dao.specialistModule.IResultSpecialistDao;
import com.AAAAAA.pestcontrolproject.entity.specialistModule.ResultSpecialist;
import com.AAAAAA.pestcontrolproject.servic.specialistModule.IResultSpecialistService;
import com.AAAAAA.pestcontrolproject.util.GetSession;
import org.apache.ibatis.session.SqlSession;

public class IResultSpecialistServiceImpl implements IResultSpecialistService {
    @Override
    public boolean addResultSpecialist(String  resultId,String  specialistId) {
        SqlSession session = GetSession.getSession();
        int a = session.getMapper(IResultSpecialistDao.class).addResultSpecialist(resultId,specialistId);
        session.commit();
        session.close();
        if (a == 1) {
            return true;
        }
        return false;
    }
}
