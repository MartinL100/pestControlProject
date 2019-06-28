package com.AAAAAA.pestcontrolproject.entity.drugModule;

/**
 * 药剂器械实体类
 */
public class SysDrug {
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
     * 使用类型
     */
    private String drugUseWay;

    /**
     * 药剂主要用途
     */
    private int drugNum;


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

    public int getDrugNum() {
        return drugNum;
    }

    public void setDrugNum(int drugNum) {
        this.drugNum = drugNum;
    }


    public String getDrugUseWay() {
        return drugUseWay;
    }

    public void setDrugUseWay(String drugUseWay) {
        this.drugUseWay = drugUseWay;
    }

    @Override
    public String toString() {
        return "SysDrug{" +
                "drugId=" + drugId +
                ", drugName='" + drugName + '\'' +
                ", drugCureType='" + drugCureType + '\'' +
                ", drugType='" + drugType + '\'' +
                ", drugUseWay='" + drugUseWay + '\'' +
                ", drugNum=" + drugNum +
                '}';
    }
}
