package com.AAAAAA.pestcontrolproject.dao.userModule;

import com.AAAAAA.pestcontrolproject.entity.userModule.TPower;

import java.util.List;
import java.util.Map;

public interface IPowerDao {
    /**
     * 查找菜单权限集合
     * @param map   条件集合
     * @return  权限集合
     */
    List<TPower> findMenuPowers(Map map);
}
