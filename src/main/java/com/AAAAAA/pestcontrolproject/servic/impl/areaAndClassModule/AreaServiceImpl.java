package com.AAAAAA.pestcontrolproject.servic.impl.areaAndClassModule;

import com.AAAAAA.pestcontrolproject.dao.areaAndClassModule.IAreaDao;
import com.AAAAAA.pestcontrolproject.entity.areaAndClassModule.SysArea;
import com.AAAAAA.pestcontrolproject.servic.areaAndClassModule.IAreaSevice;
import com.AAAAAA.pestcontrolproject.util.GetSession;
import com.AAAAAA.pestcontrolproject.util.UserModuleStringInfo;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class AreaServiceImpl implements IAreaSevice {

    @Override
    public String addArea(SysArea area) {
        SqlSession sqlSession= GetSession.getSession();
        IAreaDao dao=sqlSession.getMapper(IAreaDao.class);
        String erroInfo="";
       int influenceRow= dao.addArea(area);
        sqlSession.commit();
        sqlSession.close();
       if(1!=influenceRow){
           erroInfo= UserModuleStringInfo.ADD_FAILED;
       }else {
           erroInfo=UserModuleStringInfo.ADD_SUCCESSFUL;
       }
        return erroInfo;
    }

    @Override
    public List<SysArea> findAreaList(Map map) {
        SqlSession sqlSession= GetSession.getSession();
        IAreaDao dao=sqlSession.getMapper(IAreaDao.class);
        List<SysArea> areaList=dao.findAreaList(map);
        return areaList;
    }

    @Override
    public int countAreas(Map map) {
        SqlSession sqlSession= GetSession.getSession();
        IAreaDao dao=sqlSession.getMapper(IAreaDao.class);
        int rows=dao.countAreas(map);
        return rows;
    }


}
