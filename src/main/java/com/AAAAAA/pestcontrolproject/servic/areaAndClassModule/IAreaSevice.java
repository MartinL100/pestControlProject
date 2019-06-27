package com.AAAAAA.pestcontrolproject.servic.areaAndClassModule;

import com.AAAAAA.pestcontrolproject.entity.areaAndClassModule.SysArea;
import com.AAAAAA.pestcontrolproject.entity.areaAndClassModule.SysClass;

import java.util.List;
import java.util.Map;

/**
 * 区域业务层接口
 */
public interface IAreaSevice {
    /**
     * 添加区域
     * @param area  区域对象
     * @return  出错信息
     */
  String  addArea( SysArea area);

    /**
     * 动态查询区域集合
     * @param map 查询条件集合
     * @return 区域集合
     */
  List<SysArea>findAreaList(Map map);

    /**
     * 动态统计总地区数
     * @param map 条件集合
     * @return 总地区数
     */
    int countAreas(Map map);

}
