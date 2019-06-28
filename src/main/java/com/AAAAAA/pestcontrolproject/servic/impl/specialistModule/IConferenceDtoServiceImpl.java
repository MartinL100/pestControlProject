package com.AAAAAA.pestcontrolproject.servic.impl.specialistModule;

import com.AAAAAA.pestcontrolproject.dao.specialistModule.IConferenceDtoDao;
import com.AAAAAA.pestcontrolproject.entity.Dto.ConferenceDto;
import com.AAAAAA.pestcontrolproject.servic.specialistModule.IConferenceDtoService;
import com.AAAAAA.pestcontrolproject.util.GetSession;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class IConferenceDtoServiceImpl implements IConferenceDtoService {
    @Override
    public ConferenceDto findEventByConferenceId(String conferenceId) {
        SqlSession session = GetSession.getSession();
        ConferenceDto conferenceDto = session.getMapper(IConferenceDtoDao.class).findEventByConferenceId(conferenceId);
        session.close();
        return conferenceDto;
    }

    @Override
    public List<ConferenceDto> allConference() {
        SqlSession session = GetSession.getSession();
        List<ConferenceDto> list = session.getMapper(IConferenceDtoDao.class).allConference();
        session.close();
        return list;
    }
}
