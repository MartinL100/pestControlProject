package com.AAAAAA.pestcontrolproject.entity.eventModule;

public class Event {
    /*事件id*/
    private long eventId;
    /*事件名称*/
    private String eventName;
    /*发生时间*/
    private String occurTime;
    /*灾害等级*/
    private int disasterStage;
    /*灾情描述*/
    private String eventDescribe;
    /*图片路径*/
    private String photoPath;
    /*灾害类型*/
    private int disasterType;
    /*发现途径*/
    private int findWay;
    /*区域名称*/
    private int areaId;
    /*所在小班*/
    private int classId;
    /*初步损失*/
    private String eventLoss;
    /*影响面积*/
    private String eventArea;
    /*防治方案*/
    private String plan;


    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setOccurTime(String occurTime) {
        this.occurTime = occurTime;
    }

    public void setDisasterStage(int disasterStage) {
        this.disasterStage = disasterStage;
    }

    public void setEventDescribe(String eventDescribe) {
        this.eventDescribe = eventDescribe;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public void setDisasterType(int disasterType) {
        this.disasterType = disasterType;
    }

    public void setFindWay(int findWay) {
        this.findWay = findWay;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public void setEventLoss(String eventLoss) {
        this.eventLoss = eventLoss;
    }

    public void setEventArea(String eventArea) {
        this.eventArea = eventArea;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public long getEventId() {
        return eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public String getOccurTime() {
        return occurTime;
    }

    public int getDisasterStage() {
        return disasterStage;
    }

    public String getEventDescribe() {
        return eventDescribe;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public int getDisasterType() {
        return disasterType;
    }

    public int getFindWay() {
        return findWay;
    }

    public int getAreaId() {
        return areaId;
    }

    public int getClassId() {
        return classId;
    }

    public String getEventLoss() {
        return eventLoss;
    }

    public String getEventArea() {
        return eventArea;
    }

    public String getPlan() {
        return plan;
    }
}
