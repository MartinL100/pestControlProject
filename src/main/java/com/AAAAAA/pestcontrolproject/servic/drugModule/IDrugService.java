package com.AAAAAA.pestcontrolproject.servic.drugModule;

import com.AAAAAA.pestcontrolproject.entity.drugModule.SysDrug;
import com.AAAAAA.pestcontrolproject.vo.drugModule.SysDrugAddVo;

import java.util.List;
import java.util.Map;

public interface IDrugService {

    /**
     *  分页查询药剂与器械集合
     * @param map 查询条件集合
     * @return 药剂器械集合
     */

    public List<SysDrug> getListPageDrugByMap(Map<String, Object> map);


    /**
     * 根据条件查询页面总数量
     * @param map 页面输入的查询条件
     * @return 数据总数量
     */
    public int getAllCount(Map<String, Object> map);





    /**
     * 药剂器械入库
     * 如果药剂器械存在 则数量+入库数量
     * 如果不存在则新增一套数据
     * @param  drug 器械对象
     */
    public void saveSysDrug(SysDrugAddVo drug);


}
