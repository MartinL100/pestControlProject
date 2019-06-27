package com.AAAAAA.pestcontrolproject.servic.impl.specialistModule;

import com.AAAAAA.pestcontrolproject.dao.specialistModule.IConferenceResultDao;
import com.AAAAAA.pestcontrolproject.entity.specialistModule.ConferenceResult;
import com.AAAAAA.pestcontrolproject.entity.specialistModule.ResultSpecialist;
import com.AAAAAA.pestcontrolproject.entity.specialistModule.TConference;
import com.AAAAAA.pestcontrolproject.servic.specialistModule.IConferenceResultService;
import com.AAAAAA.pestcontrolproject.util.GetSession;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class IConferenceResultServiceImpl implements IConferenceResultService {

    @Override
    public List<ConferenceResult> findConferenceByConferenceId(String conferenceId) {
        SqlSession session = GetSession.getSession();
        List<ConferenceResult> list = session.getMapper(IConferenceResultDao.class).findConferenceByConferenceId(conferenceId);
        session.close();

        return list;
    }

    //添加会商结果，同时添加结果和专家关联
    @Override
    public boolean addConferenceResult(ConferenceResult conferenceResult) {
        SqlSession session = GetSession.getSession();
        int a = session.getMapper(IConferenceResultDao.class).addConferenceResult(conferenceResult);
        session.commit();
        session.close();
        if (a != 1) {
            return false;
        }

        return true;
    }
}
