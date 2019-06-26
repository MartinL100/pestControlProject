package com.AAAAAA.pestcontrolproject.entity.specialistModule;


public class TSpecialist {

    private long specialistId;  //专家ID
    private String specialistName;  //专家姓名
    private String specialistSex; //专家性别
    private String specialistBirthday; //专家出生日期
    private String specialistPath; //专家相片
    private String specialistSpeciality; //专家专长
    private String specialistDuty;  // 专家职务
    private String specialistTel;  //专家电话
    private String specialistUnits; //专家工作单位
    private String specialistSite; //专家住址
    private String specialistEmail; //专家邮箱

    public TSpecialist() {
    }

    public TSpecialist(String specialistName, String specialistSex, String specialistBirthday, String specialistPath, String specialistSpeciality, String specialistDuty, String specialistTel, String specialistUnits, String specialistSite, String specialistEmail) {
        this.specialistName = specialistName;
        this.specialistSex = specialistSex;
        this.specialistBirthday = specialistBirthday;
        this.specialistPath = specialistPath;
        this.specialistSpeciality = specialistSpeciality;
        this.specialistDuty = specialistDuty;
        this.specialistTel = specialistTel;
        this.specialistUnits = specialistUnits;
        this.specialistSite = specialistSite;
        this.specialistEmail = specialistEmail;
    }

    public long getSpecialistId() {
        return specialistId;
    }

    public void setSpecialistId(long specialistId) {
        this.specialistId = specialistId;
    }


    public String getSpecialistName() {
        return specialistName;
    }

    public void setSpecialistName(String specialistName) {
        this.specialistName = specialistName;
    }


    public String getSpecialistSex() {
        return specialistSex;
    }

    public void setSpecialistSex(String specialistSex) {
        this.specialistSex = specialistSex;
    }


    public String getSpecialistBirthday() {
        return specialistBirthday;
    }

    public void setSpecialistBirthday(String specialistBirthday) {
        this.specialistBirthday = specialistBirthday;
    }


    public String getSpecialistPath() {
        return specialistPath;
    }

    public void setSpecialistPath(String specialistPath) {
        this.specialistPath = specialistPath;
    }


    public String getSpecialistSpeciality() {
        return specialistSpeciality;
    }

    public void setSpecialistSpeciality(String specialistSpeciality) {
        this.specialistSpeciality = specialistSpeciality;
    }


    public String getSpecialistDuty() {
        return specialistDuty;
    }

    public void setSpecialistDuty(String specialistDuty) {
        this.specialistDuty = specialistDuty;
    }


    public String getSpecialistTel() {
        return specialistTel;
    }

    public void setSpecialistTel(String specialistTel) {
        this.specialistTel = specialistTel;
    }


    public String getSpecialistUnits() {
        return specialistUnits;
    }

    public void setSpecialistUnits(String specialistUnits) {
        this.specialistUnits = specialistUnits;
    }


    public String getSpecialistSite() {
        return specialistSite;
    }

    public void setSpecialistSite(String specialistSite) {
        this.specialistSite = specialistSite;
    }


    public String getSpecialistEmail() {
        return specialistEmail;
    }

    public void setSpecialistEmail(String specialistEmail) {
        this.specialistEmail = specialistEmail;
    }

    @Override
    public String toString() {
        return "TSpecialist{" +
                "specialistId=" + specialistId +
                ", specialistName='" + specialistName + '\'' +
                ", specialistSex='" + specialistSex + '\'' +
                ", specialistBirthday='" + specialistBirthday + '\'' +
                ", specialistPath='" + specialistPath + '\'' +
                ", specialistSpeciality='" + specialistSpeciality + '\'' +
                ", specialistDuty='" + specialistDuty + '\'' +
                ", specialistTel='" + specialistTel + '\'' +
                ", specialistUnits='" + specialistUnits + '\'' +
                ", specialistSite='" + specialistSite + '\'' +
                ", specialistEmail='" + specialistEmail + '\'' +
                '}';
    }
}
