package com.AAAAAA.pestcontrolproject.dao.userModule.temp;


import com.AAAAAA.pestcontrolproject.entity.documentModule.pestisBean;

import java.util.List;
import java.util.Map;

public interface IpestisDao {
    /**
     *  虫害害查询初始化
     * @return 虫害集合
     */
    public List<pestisBean> getListPestis(Map map);

    /**
     * 按id查询
     * @param pestisId 虫害id
     * @return 虫害对象
     */
    public pestisBean AllPestis(int pestisId);

    /**
     * 添加虫害
     * @param pestisBean
     * @return
     */
    public int AddPestis(pestisBean pestisBean);

    /**
     * 判断名字是否存在
     * @param pestisName
     * @return
     */

    public int getPestisByName(String pestisName);

    /**
     * 动态查询
     * @param map
     * @return
     */
    public List<pestisBean>getBypestis(Map map);

    /**
     * 获得总行数
     * @param map
     * @return
     */
    public int getCountPestis(Map map);

}
