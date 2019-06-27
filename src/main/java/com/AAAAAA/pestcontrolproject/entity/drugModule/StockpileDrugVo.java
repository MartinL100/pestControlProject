package com.AAAAAA.pestcontrolproject.entity.drugModule;

public class StockpileDrugVo {
    /**
     *物品id
     */
    private int drugId;
    /**
     * 订单编码
     */
    private int stockpileId;
    /**
     * 订单数量
     */
    private int stockpileNum;

    public StockpileDrugVo(int drugId, int stockpileId, int stockpileNum) {
        this.drugId = drugId;
        this.stockpileId = stockpileId;
        this.stockpileNum = stockpileNum;
    }

    public StockpileDrugVo() {
    }

    public int getDrugId() {
        return drugId;
    }

    public void setDrugId(int drugId) {
        this.drugId = drugId;
    }

    public int getStockpileId() {
        return stockpileId;
    }

    public void setStockpileId(int stockpileId) {
        this.stockpileId = stockpileId;
    }

    public int getStockpileNum() {
        return stockpileNum;
    }

    public void setStockpileNum(int stockpileNum) {
        this.stockpileNum = stockpileNum;
    }

    @Override
    public String toString() {
        return "StockpileDrugVo{" +
                "drugId=" + drugId +
                ", stockpileId=" + stockpileId +
                ", stockpileNum=" + stockpileNum +
                '}';
    }
}
