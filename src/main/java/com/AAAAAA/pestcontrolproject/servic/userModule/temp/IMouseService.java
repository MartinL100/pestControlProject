package com.AAAAAA.pestcontrolproject.servic.userModule.temp;

import com.AAAAAA.pestcontrolproject.entity.documentModule.mouseBean;

import java.util.List;
import java.util.Map;

public interface IMouseService {
    /**
     * 初始化页面
     * @return
     */
    public List<mouseBean>getLIstMouse();

    /**
     * 按id查询所有信息
     * @param MouseId
     * @return
     */
    public  mouseBean AllMouse(int MouseId);

    /**
     * 添加鼠害
     * @param mouseBean
     * @return
     */

    public boolean AddMouse(mouseBean mouseBean);

    /**
     * 判断名字是否存在
     * @param mouseName
     * @return
     */

    public int getMouuseByName(String mouseName);

    /**
     * 按名字和症状模糊查询
     * @param map 名字 症状
     * @return 病害集合
     */
    public List<mouseBean> getNameMouse(Map map);

    /**
     * 获得总行数
     * @param map 名称  主要危害 发病规律
     * @return
     */
    public int getMouse(Map map);

}
