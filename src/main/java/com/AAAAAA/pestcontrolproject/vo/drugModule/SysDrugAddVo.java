package com.AAAAAA.pestcontrolproject.vo.drugModule;

public class SysDrugAddVo {
    private int res;
    /**
     * 药剂名称
     */
    private String drugName;
    /**
     * 药剂防治类型id
     */
    private long drugCureTypeId;
    /**
     * 药剂类型Id
     */
    private long drugTypeId;
    /**
     * 药剂使用方式
     */
    private String drugUseWay;

    /**
     * 数量
     */
    private int drugNum;

    public SysDrugAddVo() {
    }

    public SysDrugAddVo(String drugName, long drugCureTypeId, long drugTypeId, String drugUseWay) {
        this.drugName = drugName;
        this.drugCureTypeId = drugCureTypeId;
        this.drugTypeId = drugTypeId;
        this.drugUseWay = drugUseWay;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public long getDrugCureTypeId() {
        return drugCureTypeId;
    }

    public void setDrugCureTypeId(long drugCureTypeId) {
        this.drugCureTypeId = drugCureTypeId;
    }

    public long getDrugTypeId() {
        return drugTypeId;
    }

    public void setDrugTypeId(long drugTypeId) {
        this.drugTypeId = drugTypeId;
    }

    public String getDrugUseWay() {
        return drugUseWay;
    }

    public void setDrugUseWay(String drugUseWay) {
        this.drugUseWay = drugUseWay;
    }

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public int getDrugNum() {
        return drugNum;
    }

    public void setDrugNum(int drugNum) {
        this.drugNum = drugNum;
    }

    @Override
    public String toString() {
        return "SysDrugAddVo{" +
                "res=" + res +
                ", drugName='" + drugName + '\'' +
                ", drugCureTypeId=" + drugCureTypeId +
                ", drugTypeId=" + drugTypeId +
                ", drugUseWay='" + drugUseWay + '\'' +
                ", drugNum=" + drugNum +
                '}';
    }
}
