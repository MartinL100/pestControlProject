package com.AAAAAA.pestcontrolproject.servic.impl.userModule;

import com.AAAAAA.pestcontrolproject.dao.userModule.IUserDao;
import com.AAAAAA.pestcontrolproject.entity.userModule.TUser;
import com.AAAAAA.pestcontrolproject.servic.userModule.IUserServic;
import com.AAAAAA.pestcontrolproject.util.GetSession;
import org.apache.ibatis.session.SqlSession;

import java.util.Map;

public class UserServicImpl implements IUserServic {
    @Override
    public TUser login(Map map) {
        SqlSession sqlSession =GetSession.getSession();
        IUserDao dao= sqlSession.getMapper(IUserDao.class);
        TUser user = dao.login(map);
        sqlSession.close();
        return user;
    }

    @Override
    public void addUser(TUser user) {

    }
}
