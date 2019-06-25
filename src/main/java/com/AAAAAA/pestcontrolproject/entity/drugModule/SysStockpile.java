package com.AAAAAA.pestcontrolproject.entity.drugModule;

import java.sql.Date;
import java.util.List;

/**
 * 出库详情信息
 */
public class SysStockpile {
    /**
     * 订单id
     */
    private int stockpileId;

    /**
     * 领用班级
     */
    private String stockpileClass;

    /**
     * 出库人
     */
    private String  stockpileMan;

    /**
     * 领用时间
     * 默认为当前时间
     */
    private Date stockpileDate=new Date(System.currentTimeMillis());

    /**
     * 领用器械
     */
   private List<stockpileDrug> DrugList;

    public SysStockpile() {
    }

    public SysStockpile(int stockpileId, String stockpileClass, String stockpileMan, Date stockpileDate, List<stockpileDrug> drugList) {
        this.stockpileId = stockpileId;
        this.stockpileClass = stockpileClass;
        this.stockpileMan = stockpileMan;
        this.stockpileDate = stockpileDate;
        DrugList = drugList;
    }

    public int getStockpileId() {
        return stockpileId;
    }

    public void setStockpileId(int stockpileId) {
        this.stockpileId = stockpileId;
    }

    public String getStockpileClass() {
        return stockpileClass;
    }

    public void setStockpileClass(String stockpileClass) {
        this.stockpileClass = stockpileClass;
    }

    public String getStockpileMan() {
        return stockpileMan;
    }

    public void setStockpileMan(String stockpileMan) {
        this.stockpileMan = stockpileMan;
    }

    public Date getStockpileDate() {
        return stockpileDate;
    }

    public void setStockpileDate(Date stockpileDate) {
        this.stockpileDate = stockpileDate;
    }

    public List<stockpileDrug> getDrugList() {
        return DrugList;
    }

    public void setDrugList(List<stockpileDrug> drugList) {
        DrugList = drugList;
    }

    @Override
    public String toString() {
        return "SysStockpile{" +
                "stockpileId=" + stockpileId +
                ", stockpileClass='" + stockpileClass + '\'' +
                ", stockpileMan='" + stockpileMan + '\'' +
                ", stockpileDate=" + stockpileDate +
                ", DrugList=" + DrugList +
                '}';
    }
}
