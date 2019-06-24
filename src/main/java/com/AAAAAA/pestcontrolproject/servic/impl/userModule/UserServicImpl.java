package com.AAAAAA.pestcontrolproject.servic.impl.userModule;

import com.AAAAAA.pestcontrolproject.dao.userModule.IUserDao;
import com.AAAAAA.pestcontrolproject.entity.userModule.TUser;
import com.AAAAAA.pestcontrolproject.servic.userModule.IUserServic;
import com.AAAAAA.pestcontrolproject.util.GetSession;
import com.AAAAAA.pestcontrolproject.util.UserModuleStringInfo;
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
    public String addUser(TUser user) {
        SqlSession sqlSession =GetSession.getSession();
        IUserDao dao= sqlSession.getMapper(IUserDao.class);
        String info ="";
    //判断用户名是否存在
        TUser user1=dao.findUserByName(user.getUserName());
        if(user1==null){
            //如果用户名不存在，添加该用户
           dao.addUser(user);

        }else {
            //如果用户名存在，返回错误信息
            info= UserModuleStringInfo.USER_IS_EXIST;
        }
        sqlSession.commit();
        sqlSession.close();
       return info;
    }

    @Override
    public boolean isExistUserByName(String userName) {
        return false;
    }
}
