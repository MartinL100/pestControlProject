package com.AAAAAA.pestcontrolproject.entity.documentModule;

/**
 * 虫害表实体类
 */
public class pestisBean {
    /**虫害id*/
    private int id;
    /**虫害名称*/
    private String pestisName;
    /**虫害繁殖*/
    private String pestisBreed;
    /**虫害寄主*/
    private String pestisHost;
    /**虫害天敌*/
    private String pestisEnemy;
    /**主要危害*/
    private String pestisHarm;
    /**防御措施*/
    private String pestisDefense;
    /**幼虫照片*/
    private String pestisPhoto;
    /**成虫照片*/
    private String pestisAdultImages;

    @Override
    public String toString() {
        return "pestisBean{" +
                "id=" + id +
                ", pestisName='" + pestisName + '\'' +
                ", pestisBreed='" + pestisBreed + '\'' +
                ", pestisHost='" + pestisHost + '\'' +
                ", pestisEnemy='" + pestisEnemy + '\'' +
                ", pestisHarm='" + pestisHarm + '\'' +
                ", pestisDefense='" + pestisDefense + '\'' +
                ", pestisPhoto='" + pestisPhoto + '\'' +
                ", pestisAdultImages='" + pestisAdultImages + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPestisName() {
        return pestisName;
    }

    public void setPestisName(String pestisName) {
        this.pestisName = pestisName;
    }

    public String getPestisBreed() {
        return pestisBreed;
    }

    public void setPestisBreed(String pestisBreed) {
        this.pestisBreed = pestisBreed;
    }

    public String getPestisHost() {
        return pestisHost;
    }

    public void setPestisHost(String pestisHost) {
        this.pestisHost = pestisHost;
    }

    public String getPestisEnemy() {
        return pestisEnemy;
    }

    public void setPestisEnemy(String pestisEnemy) {
        this.pestisEnemy = pestisEnemy;
    }

    public String getPestisHarm() {
        return pestisHarm;
    }

    public void setPestisHarm(String pestisHarm) {
        this.pestisHarm = pestisHarm;
    }

    public String getPestisDefense() {
        return pestisDefense;
    }

    public void setPestisDefense(String pestisDefense) {
        this.pestisDefense = pestisDefense;
    }

    public String getPestisPhoto() {
        return pestisPhoto;
    }

    public void setPestisPhoto(String pestisPhoto) {
        this.pestisPhoto = pestisPhoto;
    }

    public String getPestisAdultImages() {
        return pestisAdultImages;
    }

    public void setPestisAdultImages(String pestisAdultImages) {
        this.pestisAdultImages = pestisAdultImages;
    }
}

