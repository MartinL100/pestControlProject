package com.AAAAAA.pestcontrolproject.entity.documentModule;

/***
 * 病害表实体类
 */
public class DiseaseBean {
    /**病害id*/
    private int diseaseId;
    /**病害名称*/
    private String diseaseName;
    /**病害病源*/
    private String diseaseSource;
    /**发病症状*/
    private String diseaseSymptom;
    /**发病规律*/
    private String diseaseLaw;
    /**主要危害*/
    private String diseaseHarm;
    /**图片*/
    private String diseasePhoto;
    /**防治措施*/
    private String diseaseMeasure;

    public int getDiseaseId() {
        return diseaseId;
    }

    public void setDiseaseId(int diseaseId) {
        this.diseaseId = diseaseId;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public String getDiseaseSource() {
        return diseaseSource;
    }

    public void setDiseaseSource(String diseaseSource) {
        this.diseaseSource = diseaseSource;
    }

    public String getDiseaseSymptom() {
        return diseaseSymptom;
    }

    public void setDiseaseSymptom(String diseaseSymptom) {
        this.diseaseSymptom = diseaseSymptom;
    }

    public String getDiseaseLaw() {
        return diseaseLaw;
    }

    public void setDiseaseLaw(String diseaseLaw) {
        this.diseaseLaw = diseaseLaw;
    }

    public String getDiseaseHarm() {
        return diseaseHarm;
    }

    public void setDiseaseHarm(String diseaseHarm) {
        this.diseaseHarm = diseaseHarm;
    }

    public String getDiseasePhoto() {
        return diseasePhoto;
    }

    public void setDiseasePhoto(String diseasePhoto) {
        this.diseasePhoto = diseasePhoto;
    }

    public String getDiseaseMeasure() {
        return diseaseMeasure;
    }

    public void setDiseaseMeasure(String diseaseMeasure) {
        this.diseaseMeasure = diseaseMeasure;
    }
}
