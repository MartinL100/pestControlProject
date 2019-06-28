package com.AAAAAA.pestcontrolproject.servic.eventModule;

import com.AAAAAA.pestcontrolproject.dao.eventModule.IAddConfDao;
import com.AAAAAA.pestcontrolproject.dao.eventModule.IEventDao;
import com.AAAAAA.pestcontrolproject.util.GetSession;
import org.apache.ibatis.session.SqlSession;

public class AddConfServiceImpl implements IAddConfDao {

    @Override
    public void addConf(int eventId) {
        SqlSession session= GetSession.getSession();
        IAddConfDao dao=session.getMapper(IAddConfDao.class);

        dao.addConf(eventId);
        session.commit();
        session.close();
    }
}
