package com.AAAAAA.pestcontrolproject.servic.impl.userModule;

import com.AAAAAA.pestcontrolproject.dao.userModule.ILogDao;
import com.AAAAAA.pestcontrolproject.entity.userModule.TLog;
import com.AAAAAA.pestcontrolproject.servic.userModule.ILogSevice;
import com.AAAAAA.pestcontrolproject.util.GetSession;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class LogServicImpl implements ILogSevice {
    @Override
    public List<TLog> findLogsList(Map map) {
        SqlSession sqlSession= GetSession.getSession();
        ILogDao dao=sqlSession.getMapper(ILogDao.class);
        List<TLog> logList=dao.findLogsList(map);
        return logList;
    }

    @Override
    public void addLog(TLog log) {
        SqlSession sqlSession= GetSession.getSession();
        ILogDao dao=sqlSession.getMapper(ILogDao.class);
        dao.addLog(log);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public int countLogs(Map map) {
        SqlSession sqlSession= GetSession.getSession();
        ILogDao dao=sqlSession.getMapper(ILogDao.class);
        int rows=dao.countLogs(map);
        return rows;
    }
}
