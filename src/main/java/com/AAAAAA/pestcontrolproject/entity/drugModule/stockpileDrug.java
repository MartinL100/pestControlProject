package com.AAAAAA.pestcontrolproject.entity.drugModule;

/**
 * 出库药剂
 */
public class stockpileDrug {

    /**
     * 药剂器械id
     */
    private long drugId;

    /**
     * 药剂器械名称
     */
    private String drugName;

    /**
     * 药剂器械防治类型ID
     */
    private String drugCureType;

    /**
     * 器械类型
     */
    private String drugType;
    /**
     * 主要用途
     */
    private String drugUseWay;

    /**
     * 药剂数量
     */
    private int drugNum;

    public stockpileDrug() {
    }

    public stockpileDrug(long drugId, String drugName, String drugCureType, String drugType, String drugUseWay, int drugNum) {
        this.drugId = drugId;
        this.drugName = drugName;
        this.drugCureType = drugCureType;
        this.drugType = drugType;
        this.drugUseWay = drugUseWay;
        this.drugNum = drugNum;
    }

    public long getDrugId() {
        return drugId;
    }

    public void setDrugId(long drugId) {
        this.drugId = drugId;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getDrugCureType() {
        return drugCureType;
    }

    public void setDrugCureType(String drugCureType) {
        this.drugCureType = drugCureType;
    }

    public String getDrugType() {
        return drugType;
    }

    public void setDrugType(String drugType) {
        this.drugType = drugType;
    }

    public String getDrugUseWay() {
        return drugUseWay;
    }

    public void setDrugUseWay(String drugUseWay) {
        this.drugUseWay = drugUseWay;
    }

    public int getDrugNum() {
        return drugNum;
    }

    public void setDrugNum(int drugNum) {
        this.drugNum = drugNum;
    }

    @Override
    public String toString() {
        return "stockpileDrug{" +
                "drugId=" + drugId +
                ", drugName='" + drugName + '\'' +
                ", drugCureType='" + drugCureType + '\'' +
                ", drugType='" + drugType + '\'' +
                ", drugUseWay='" + drugUseWay + '\'' +
                ", drugNum=" + drugNum +
                '}';
    }
}
