package com.AAAAAA.pestcontrolproject.servic.eventModule;

import com.AAAAAA.pestcontrolproject.dao.eventModule.IEventDao;
import com.AAAAAA.pestcontrolproject.entity.eventModule.Event;
import com.AAAAAA.pestcontrolproject.util.GetSession;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventServiceImpl implements IEventService {
    @Override
    public void eventUpdate(Event event) {
        SqlSession session= GetSession.getSession();
        IEventDao dao=session.getMapper(IEventDao.class);

        dao.updateEvent(event);
        session.commit();
        session.close();
    }

    @Override
    public void eventAdd(Event event) {
        SqlSession session= GetSession.getSession();
        IEventDao dao=session.getMapper(IEventDao.class);

        dao.addEvent(event);
        session.commit();
        session.close();

    }


    @Override
    public List<Event> findAllByMap(Map<String, Object> map) {
        SqlSession session= GetSession.getSession();
        IEventDao dao=session.getMapper(IEventDao.class);

        List<Event> list= dao.findAllEventBy(map);

        session.commit();
        session.close();
        return list;
    }
}
