package com.AAAAAA.pestcontrolproject.servic.documentModule;

import com.AAAAAA.pestcontrolproject.entity.documentModule.DiseaseBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IdiseaseService {

    /**
     * 添加病害
     * @param diseaseBean 病害对象
     * @return     判断名称是否存在
     */
    public boolean AddDisease(DiseaseBean diseaseBean);

    /**
     * 按id查询病害信息
     * @param diseaseId 病害id
     * @return 病害对象
     */
    public DiseaseBean InquireDisease(int diseaseId);

    /**
     * 按名字和症状模糊查询
     * @param map 名字 症状
     * @return 病害集合
     */
    public List<DiseaseBean> getNameDisease(Map map);

    /**
     * 获得总行数
     * @param map 名称  主要危害 发病规律
     * @return
     */
    public int getDisease(Map map);

    /**
     * 初始化面板
     * @return
     */
    public List<DiseaseBean> getList();
    /**
     * 判断名字是否存在
     * @param diseaseName
     * @return
     */
    public  int getDiseaseByName(@Param("name") String diseaseName);
}
