package com.AAAAAA.pestcontrolproject.servic.impl.eventModule;

import com.AAAAAA.pestcontrolproject.dao.eventModule.IEventDao;
import com.AAAAAA.pestcontrolproject.dao.eventModule.IFindTypeDao;
import com.AAAAAA.pestcontrolproject.entity.Selected.SysSelectedType;
import com.AAAAAA.pestcontrolproject.entity.areaAndClassModule.SysArea;
import com.AAAAAA.pestcontrolproject.entity.areaAndClassModule.SysClass;
import com.AAAAAA.pestcontrolproject.util.GetSession;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FindTypeServiceImpl implements IFindTypeDao {
    @Override
    public List<SysSelectedType> findType(Map<String, Object> map) {
        SqlSession session= GetSession.getSession();
        IFindTypeDao dao=session.getMapper(IFindTypeDao.class);

       List<SysSelectedType>selectedTypeList= dao.findType(map);
        session.commit();
        session.close();
        return selectedTypeList;

    }

    @Override
    public List<SysClass> findClaaByAreaId(int id) {

        SqlSession session= GetSession.getSession();
        IFindTypeDao dao=session.getMapper(IFindTypeDao.class);
        List<SysClass> list= dao.findClaaByAreaId(id);
        session.commit();
        session.close();
        return list;



    }

    @Override
    public List<SysArea> findAreaByAreaId(int id) {

        SqlSession session= GetSession.getSession();
        IFindTypeDao dao=session.getMapper(IFindTypeDao.class);
        List<SysArea> list=dao.findAreaByAreaId(id);
        session.commit();
        session.close();
        return list;


    }
}
