package com.AAAAAA.pestcontrolproject.dao.userModule;

import com.AAAAAA.pestcontrolproject.entity.userModule.TUser;

import java.util.Map;

/**
 * 用户业务层接口
 */
public interface IUserDao {
    /**
     * 用户登录
     * 首先验证用户是否存在，用户名密码是否正确
     * 如果存在查出用户的对应的角色对象以及权限集合
     * @param map  用户名  密码
     * @return 登录用户对象
     */
    public TUser login(Map map);

    /**
     * 添加用户
     * @param user 用户对象
     */

    public  void addUser(TUser user);
}
