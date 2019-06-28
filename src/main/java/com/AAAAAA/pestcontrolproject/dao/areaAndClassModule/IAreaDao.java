package com.AAAAAA.pestcontrolproject.dao.areaAndClassModule;

import com.AAAAAA.pestcontrolproject.entity.areaAndClassModule.SysArea;
import com.AAAAAA.pestcontrolproject.entity.areaAndClassModule.SysClass;

import java.util.List;
import java.util.Map;

public interface IAreaDao {
    /**
     * 添加区域
     * @param area  区域对象
     * @return  受影响的行数
     */
    int  addArea( SysArea area);

    /**
     * 动态查询区域集合,包含小班信息
     * @param map 查询条件集合
     * @return 区域集合
     */
    List<SysArea> findAreaList(Map map);

    /**
     * 动态统计总地区数
     * @param map 条件集合
     * @return 总地区数
     */
    int countAreas(Map map);

}
