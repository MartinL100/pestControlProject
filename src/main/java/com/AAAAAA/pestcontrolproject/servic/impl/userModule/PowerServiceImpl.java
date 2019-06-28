package com.AAAAAA.pestcontrolproject.servic.impl.userModule;

import com.AAAAAA.pestcontrolproject.dao.userModule.IPowerDao;
import com.AAAAAA.pestcontrolproject.entity.userModule.TPower;
import com.AAAAAA.pestcontrolproject.servic.userModule.IPowerService;
import com.AAAAAA.pestcontrolproject.util.GetSession;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class PowerServiceImpl implements IPowerService {
    @Override
    public List<TPower> findMenuPowers(Map map) {
        SqlSession session= GetSession.getSession();
        IPowerDao dao= session.getMapper(IPowerDao.class);
        List<TPower> powers=dao.findMenuPowers(map);
        session.close();
        return powers;
    }
}
