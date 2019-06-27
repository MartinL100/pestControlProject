package com.AAAAAA.pestcontrolproject.servic.impl.areaAndClassModule;

import com.AAAAAA.pestcontrolproject.dao.areaAndClassModule.IClassDao;
import com.AAAAAA.pestcontrolproject.entity.areaAndClassModule.SysClass;
import com.AAAAAA.pestcontrolproject.servic.areaAndClassModule.IClassServic;
import com.AAAAAA.pestcontrolproject.util.GetSession;
import com.AAAAAA.pestcontrolproject.util.UserModuleStringInfo;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class ClassServiceImpl implements IClassServic {
    @Override
    public SysClass findClassByClassId(Map map) {
        SqlSession session= GetSession.getSession();
        IClassDao classDao=session.getMapper(IClassDao.class);
       SysClass sysClass= classDao.findClassByClassId(map);
        return sysClass;
    }

    @Override
    public List<SysClass> findClassList(Map map) {
        SqlSession session= GetSession.getSession();
        IClassDao classDao=session.getMapper(IClassDao.class);
        List<SysClass> classList=classDao.findClassList(map);
        return classList;
    }

    @Override
    public String addSysClass(SysClass sysClass) {

        SqlSession session= GetSession.getSession();
        IClassDao classDao=session.getMapper(IClassDao.class);
        String erroInfo="";
        int influenceRow=classDao.addSysClass(sysClass);
        session.commit();
        session.close();
        if(1!=influenceRow){
            erroInfo= UserModuleStringInfo.ADD_FAILED;
        }else {
            erroInfo=UserModuleStringInfo.ADD_SUCCESSFUL;
        }

        return erroInfo;
    }

    @Override
    public String updateClass(Map map) {
        SqlSession session= GetSession.getSession();
        IClassDao classDao=session.getMapper(IClassDao.class);
        String erroInfo="";
        int influenceRow=classDao.updateClass(map);
        session.commit();
        session.close();
        if(1!=influenceRow){
            erroInfo= UserModuleStringInfo.UPDATE_FAILED;
        }else {
            erroInfo=UserModuleStringInfo.UPDATE_SUCCESSFUL;
        }

        return erroInfo;
    }

    @Override
    public SysClass findClassByAreaId(Map map) {
        SqlSession session= GetSession.getSession();
        IClassDao classDao=session.getMapper(IClassDao.class);
        SysClass classList=classDao.findClassByAreaId(map);
        return classList;
    }

    @Override
    public int countClass(Map map) {
        SqlSession session= GetSession.getSession();
        IClassDao classDao=session.getMapper(IClassDao.class);
        int rows=classDao.countClass(map);
        return rows;
    }
}
