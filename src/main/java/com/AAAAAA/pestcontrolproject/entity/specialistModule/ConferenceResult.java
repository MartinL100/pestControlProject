package com.AAAAAA.pestcontrolproject.entity.specialistModule;

import java.util.List;

public class ConferenceResult {

    private long resultId;  //会商结果ID
    private long conferenceId;//会商ID
    private String conferenceDate; // 专家会商日期
    private String conferenceResult; // 专家会商结果
    private List<TSpecialist> specialistList;//专家集合

    public ConferenceResult() {
    }

    public long getResultId() {
        return resultId;
    }

    public void setResultId(long resultId) {
        this.resultId = resultId;
    }

    public long getConferenceId() {
        return conferenceId;
    }

    public void setConferenceId(long conferenceId) {
        this.conferenceId = conferenceId;
    }

    public String getConferenceDate() {
        return conferenceDate;
    }

    public void setConferenceDate(String conferenceDate) {
        this.conferenceDate = conferenceDate;
    }

    public String getConferenceResult() {
        return conferenceResult;
    }

    public void setConferenceResult(String conferenceResult) {
        this.conferenceResult = conferenceResult;
    }

    public List<TSpecialist> getSpecialistList() {
        return specialistList;
    }

    public void setSpecialistList(List<TSpecialist> specialistList) {
        this.specialistList = specialistList;
    }

    @Override
    public String toString() {
        return "ConferenceResult{" +
                "resultId=" + resultId +
                ", conferenceId=" + conferenceId +
                ", conferenceDate='" + conferenceDate + '\'' +
                ", conferenceResult='" + conferenceResult + '\'' +
                ", specialistList=" + specialistList +
                '}';
    }
}
