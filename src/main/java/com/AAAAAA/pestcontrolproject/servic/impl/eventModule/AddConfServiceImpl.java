package com.AAAAAA.pestcontrolproject.servic.impl.eventModule;

import com.AAAAAA.pestcontrolproject.dao.eventModule.IAddConfDao;
import com.AAAAAA.pestcontrolproject.dao.eventModule.IEventDao;
import com.AAAAAA.pestcontrolproject.entity.specialistModule.TConference;
import com.AAAAAA.pestcontrolproject.util.GetSession;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class AddConfServiceImpl implements IAddConfDao {

    @Override
    public void addConf(int eventId) {
        SqlSession session= GetSession.getSession();
        IAddConfDao dao=session.getMapper(IAddConfDao.class);

        dao.addConf(eventId);
        session.commit();
        session.close();
    }

    @Override
    public List<TConference> findConfIdByEventId(int EventId) {

        SqlSession session= GetSession.getSession();
        IAddConfDao dao=session.getMapper(IAddConfDao.class);
        List<TConference>  tConferences =dao.findConfIdByEventId(EventId);

        session.commit();
        session.close();
        return  tConferences;
    }
}
