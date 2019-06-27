package com.AAAAAA.pestcontrolproject.dao.drugModule;

import com.AAAAAA.pestcontrolproject.entity.drugModule.*;

import java.util.List;
import java.util.Map;

/**
 * 订单接口
 */
public interface IStockpileDao {
    /**
     * 动态查询订单状态
     * @param map 查询接口
     * @return 订单信息集合
     */
    public List<SysStockpile> getSysDrugList(Map map);


    /**
     * 通过id找到订单详情
     * @param IStockpileID
     * @return 订单对象
     */
    public SysStockpile getSysDrugByID(int IStockpileID);

    /**
     * 添加订单
     */
    public int saveStockpileDrug(StockpileVo vo);


    /**
     * 添加订单中间表
     */
    public int addStockpileDrug(StockpileDrugVo DrugVo);

    /**
     * 查询订单总数
     * @param map 条件集合
     * @return 订单总数
     */
    public int GetCounts(Map map);


    /**
     * 根据出库器材id删除信息
     * 设备库存表 数量增加
     * @param StockpileDrugID
     */
    public void removeStockpileDrug(int StockpileDrugID);

    /**
     * 根据订单表查找订单对应的数据集合
     * @param ID
     * @return
     */
    public List<stockpileDrug> getDrugListById(int ID);
}
