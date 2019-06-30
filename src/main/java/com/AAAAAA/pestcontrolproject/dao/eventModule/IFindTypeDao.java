package com.AAAAAA.pestcontrolproject.dao.eventModule;

import com.AAAAAA.pestcontrolproject.entity.Selected.SysSelectedType;

import java.util.List;
import java.util.Map;

public interface IFindTypeDao {

    /**
     * 查询对应的类型
     * @return
     */
    List<SysSelectedType> findType(Map<String,Object> map);

}
