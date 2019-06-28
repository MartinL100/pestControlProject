package com.AAAAAA.pestcontrolproject.dao.userModule;

import com.AAAAAA.pestcontrolproject.entity.userModule.TLog;

import java.util.List;
import java.util.Map;

public interface ILogDao {
    /**
     * 动态查询日志集合
     * @param map 条件集合
     * @return 日志集合
     */
    List<TLog> findLogsList(Map map);

    /**
     * 添加日志信息
     * @param log 日志对象
     *
     */
    void addLog(TLog log);
    /**
     * 动态统计日志总数
     * @param map   条件集合
     * @return  日志集合
     */
    int countLogs(Map map);
}
