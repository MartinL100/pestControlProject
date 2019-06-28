package com.AAAAAA.pestcontrolproject.entity.Dto;

public class ConferenceDto {
    //专家会商ID
    private long conferenceId;
    /*事件名称*/
    private String eventName;
    /*发生时间*/
    private String occurTime;
    /*图片路径*/
    private String photoPath;
    /*发生位置*/
    private String areaName;
    /*灾情描述*/
    private String eventDescribe;
    /*影响面积*/
    private String eventArea;
    /*灾害状态*/
    private int disasterStage;
    /*防治方案*/
    private String plan;

    public ConferenceDto() {
    }

    public ConferenceDto(String eventName, String occurTime, String photoPath, String areaName, String eventDescribe, String eventArea, int disasterStage, String plan) {
        this.eventName = eventName;
        this.occurTime = occurTime;
        this.photoPath = photoPath;
        this.areaName = areaName;
        this.eventDescribe = eventDescribe;
        this.eventArea = eventArea;
        this.disasterStage = disasterStage;
        this.plan = plan;
    }

    public long getConferenceId() {
        return conferenceId;
    }

    public void setConferenceId(long conferenceId) {
        this.conferenceId = conferenceId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getOccurTime() {
        return occurTime;
    }

    public void setOccurTime(String occurTime) {
        this.occurTime = occurTime;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getEventDescribe() {
        return eventDescribe;
    }

    public void setEventDescribe(String eventDescribe) {
        this.eventDescribe = eventDescribe;
    }

    public String getEventArea() {
        return eventArea;
    }

    public void setEventArea(String eventArea) {
        this.eventArea = eventArea;
    }

    public int getDisasterStage() {
        return disasterStage;
    }

    public void setDisasterStage(int disasterStage) {
        this.disasterStage = disasterStage;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    @Override
    public String toString() {
        return "ConferenceDto{" +
                "conferenceId=" + conferenceId +
                ", eventName='" + eventName + '\'' +
                ", occurTime='" + occurTime + '\'' +
                ", photoPath='" + photoPath + '\'' +
                ", areaName='" + areaName + '\'' +
                ", eventDescribe='" + eventDescribe + '\'' +
                ", eventArea='" + eventArea + '\'' +
                ", disasterStage=" + disasterStage +
                ", plan='" + plan + '\'' +
                '}';
    }
}
