package com.AAAAAA.pestcontrolproject.servic.specialistModule;

import com.AAAAAA.pestcontrolproject.entity.specialistModule.TSpecialist;

import java.util.List;
import java.util.Map;

public interface ISpecialistService {
    /**
     * 添加专家
     * @param specialist 专家对象
     * @return 受影响的行数
     */
    public boolean addSpecialist(TSpecialist specialist);

    /**
     * 根据专家ID查询专家
     * @param specialistId
     * @return
     */
    public TSpecialist findSpecialistById(String specialistId);

    /**
     * 修改专家
     * @param map 条件集合：根据ID修改专家的电话、职务、工作单位、邮箱
     * @return 受影响的行数
     */
    public boolean updateSpecialist(Map map);

    /**
     * 根据专家ID删除专家
     * @param specialistId  专家ID
     * @return 受影响的行数
     */
    public boolean delSpecialistById(String specialistId);

    /**
     * 动态查询专家
     * @param map 动态条件：专家姓名、专长、工作单位
     * @return 专家集合
     */
    public List<TSpecialist> findSpecialistList(Map map);
    /**
     * 查询总行数
     * @return 总行数
     */
    public int findCountRow(Map map);


    /**
     * 查询所有的专家名
     * @return 专家名集合
     */
    public List<TSpecialist> findSpecialistNameList();
}
