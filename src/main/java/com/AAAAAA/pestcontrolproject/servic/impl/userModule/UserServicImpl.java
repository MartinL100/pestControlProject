package com.AAAAAA.pestcontrolproject.servic.impl.userModule;

import com.AAAAAA.pestcontrolproject.dao.userModule.IUserDao;
import com.AAAAAA.pestcontrolproject.entity.userModule.TUser;
import com.AAAAAA.pestcontrolproject.servic.userModule.IUserServic;
import com.AAAAAA.pestcontrolproject.util.GetSession;
import com.AAAAAA.pestcontrolproject.util.UserModuleStringInfo;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
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
        SqlSession sqlSession =GetSession.getSession();
        IUserDao dao= sqlSession.getMapper(IUserDao.class);
        TUser user= dao.findUserByName(userName);
        boolean bl = false;
        if(user!=null){
            bl=true;
        }
        return bl;
    }

    @Override
    public List<TUser> findUsersList(Map map) {
        SqlSession sqlSession =GetSession.getSession();
        IUserDao dao= sqlSession.getMapper(IUserDao.class);
        List<TUser> userList=dao.findUsersList(map);
        return userList;
    }

    @Override
    public void delUser(Map map) {
        SqlSession sqlSession =GetSession.getSession();
        IUserDao dao= sqlSession.getMapper(IUserDao.class);
        dao.delUser(map);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public TUser findUserById(Map map) {
        SqlSession sqlSession =GetSession.getSession();
        IUserDao dao= sqlSession.getMapper(IUserDao.class);
        TUser user=dao.findUserById(map);
        sqlSession.close();

        return user;
    }

    @Override
    public void updateUserInfo(Map map) {
        SqlSession sqlSession =GetSession.getSession();
        IUserDao dao= sqlSession.getMapper(IUserDao.class);
        dao.updateUserInfo(map);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public int countAllUsers(Map map) {
        SqlSession sqlSession =GetSession.getSession();
        IUserDao dao= sqlSession.getMapper(IUserDao.class);
        int rows= dao.countAllUsers(map);
        return rows;
    }
}
