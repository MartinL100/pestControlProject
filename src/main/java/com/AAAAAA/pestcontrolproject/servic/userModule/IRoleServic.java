package com.AAAAAA.pestcontrolproject.servic.userModule;

import com.AAAAAA.pestcontrolproject.entity.userModule.TRole;

import java.util.List;

public interface IRoleServic {

    /**
     * 查找所有角色对象
     * @return 所有角色集合
     */
    List<TRole> findAllrolesList();
}
