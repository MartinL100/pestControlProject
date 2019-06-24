package com.AAAAAA.pestcontrolproject.servic.impl.userModule;

import com.AAAAAA.pestcontrolproject.dao.userModule.IRoleDao;
import com.AAAAAA.pestcontrolproject.entity.userModule.TRole;
import com.AAAAAA.pestcontrolproject.servic.userModule.IRoleServic;
import com.AAAAAA.pestcontrolproject.util.GetSession;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class RoleServicImpl  implements IRoleServic {
    @Override
    public List<TRole> findAllrolesList() {

        SqlSession sqlSession=GetSession.getSession();
        IRoleDao dao=sqlSession.getMapper(IRoleDao.class);
        List<TRole> roleList =dao.findAllrolesList();
        sqlSession.close();
        return roleList;
    }
}
