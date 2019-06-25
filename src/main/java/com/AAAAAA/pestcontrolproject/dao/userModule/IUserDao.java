package com.AAAAAA.pestcontrolproject.dao.userModule;

import com.AAAAAA.pestcontrolproject.entity.userModule.TUser;

import java.util.List;
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
    TUser login(Map map);

    /**
     * 添加用户
     * @param user 用户对象
     */

      int addUser(TUser user);

    /**
     * 根据用户名查找用户
     * @param userName  用户名
     * @return  用户对象
     */
      TUser findUserByName(String userName);
    /**
     * 动态查询用户集合
     * @param map 条件集合
     * @return  用户集合
     */
    List<TUser> findUsersList(Map map);
    /**
     * 删除用户
     * @param map 包含用户id
     */
    void delUser(Map map);
    /**
     * 根据id查找用户
     * @param map
     * @return
     */
    TUser findUserById(Map map);
    /**
     * 根据id修改用户
     * @param map 条件集合
     */
    void updateUserInfo(Map map);
    /**
     * 动态查询总用户数
     * @param map 条件集合
     * @return 总条数
     */
    int countAllUsers(Map map);

}
