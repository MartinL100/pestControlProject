package com.AAAAAA.pestcontrolproject.entity.drugModule;

import java.sql.Date;

public class StockpileVo {
    /**
     * 订单id
     */
    private int stockpileId;


    /**
     * 领用班级Id
     */
    private long stockpileClassId;

    /**
     * 领用班级
     */
    private long  stockpileUserId;


    /**
     * 领用时间
     * 默认为当前时间
     */
    private Date stockpileDate=new Date(System.currentTimeMillis());

    public StockpileVo() {
    }

    public StockpileVo(int stockpileId, long stockpileClassId, long stockpileUserId, Date stockpileDate) {
        this.stockpileId = stockpileId;
        this.stockpileClassId = stockpileClassId;
        this.stockpileUserId = stockpileUserId;
        this.stockpileDate = stockpileDate;
    }

    public int getStockpileId() {
        return stockpileId;
    }

    public void setStockpileId(int stockpileId) {
        this.stockpileId = stockpileId;
    }

    public long getStockpileClassId() {
        return stockpileClassId;
    }

    public void setStockpileClassId(long stockpileClassId) {
        this.stockpileClassId = stockpileClassId;
    }

    public long getStockpileUserId() {
        return stockpileUserId;
    }

    public void setStockpileUserId(long stockpileUserId) {
        this.stockpileUserId = stockpileUserId;
    }

    public Date getStockpileDate() {
        return stockpileDate;
    }

    public void setStockpileDate(Date stockpileDate) {
        this.stockpileDate = stockpileDate;
    }

    @Override
    public String toString() {
        return "StockpileVo{" +
                "stockpileId=" + stockpileId +
                ", stockpileClassId=" + stockpileClassId +
                ", stockpileUserId=" + stockpileUserId +
                ", stockpileDate=" + stockpileDate +
                '}';
    }
}
