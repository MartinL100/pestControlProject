package com.AAAAAA.pestcontrolproject.dao.areaAndClassModule;

import com.AAAAAA.pestcontrolproject.entity.areaAndClassModule.SysClass;

import java.util.List;
import java.util.Map;

public interface IClassDao {
    /**
     * 根据小班id查询小班对象，包括区域对象信息
     * @param map   条件集合
     * @return  小班对象
     */
    SysClass findClassByClassId(Map map);

    /**
     * 动态查询小班集合
     * 查询时需连表查询
     * @param map   条件集合 包括区域的名称
     * @return  小班集合 包括区域的名称
     */
    List<SysClass> findClassList(Map map);

    /**
     * 添加小班
     * @param sysClass  小班对象
     * @return  受影响的行数
     */
    int addSysClass(SysClass sysClass);

    /**
     * 修改小班信息
     * @param map   条件集合
     * @return  受影响的行数
     */
    int updateClass(Map map);
    /**
     * 根据区域id查询小班信息
     * @param map
     * @return
     */
    SysClass findClassByAreaId(Map map);
    /**
     * 动态统计班级总数
     * @param map 条件集合
     * @return 班级总数
     */
    int countClass(Map map);
}
