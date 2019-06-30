package com.AAAAAA.pestcontrolproject.servic.documentModule;

import com.AAAAAA.pestcontrolproject.entity.documentModule.mouseBean;
import com.AAAAAA.pestcontrolproject.entity.documentModule.pestisBean;

import java.util.List;
import java.util.Map;

public interface IpestisService {
    /**
     * 初始化
     * @return
     */
    public List<pestisBean>getListPestis(Map map);

    /**
     * 按id查询详细信息
     * @param pestisId 虫害id
     * @return 虫害对象
     */
    public pestisBean AllPestis(int pestisId);

    /**
     * 添加虫害
     * @param pestisBean
     * @return
     */
    public boolean AddPestis(pestisBean pestisBean);

    /**
     * 判断名字是否存在
     * @param pestisName
     * @return
     */
    public int  getPestisByName(String pestisName);

    /**
     * 按名字和症状模糊查询
     * @param map 名字 症状
     * @return 病害集合
     */
    public List<pestisBean> getNamePestis(Map map);

    /**
     * 获得总行数
     * @param map 名称  主要危害 发病规律
     * @return
     */
    public int getPestis(Map map);
}
