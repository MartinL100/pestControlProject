package com.AAAAAA.pestcontrolproject.service.selectedType.impl;

import com.AAAAAA.pestcontrolproject.dao.selectedType.ISelectedTypeDao;
import com.AAAAAA.pestcontrolproject.util.GetSession;
import com.AAAAAA.pestcontrolproject.entity.Selected.SysSelectedType;
import com.AAAAAA.pestcontrolproject.service.selectedType.ISelectedTypeService;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class SelectedTypeImpl implements ISelectedTypeService {
    @Override
    public SysSelectedType getSelectedValueByID(long SelectedId) {
        SqlSession session= GetSession.getSession();
        ISelectedTypeDao dao=  session.getMapper(ISelectedTypeDao.class);
        SysSelectedType type=dao.getSelectedValueByID(SelectedId);
        session.close();
        return type;
    }

    @Override
    public List<SysSelectedType> getSelectValueListByTypeName(String TypeName) {
        SqlSession session= GetSession.getSession();
        ISelectedTypeDao dao=  session.getMapper(ISelectedTypeDao.class);
        List<SysSelectedType> list=dao.getSelectValueListByTypeName(TypeName);
        session.close();
        return list;
    }

    @Override
    public List<SysSelectedType> getAllClass() {
        SqlSession session= GetSession.getSession();
        ISelectedTypeDao dao=  session.getMapper(ISelectedTypeDao.class);
        List<SysSelectedType> list=dao.getAllClass();
        session.close();
        return list;
    }
}
