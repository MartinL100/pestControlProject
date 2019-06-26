package com.AAAAAA.pestcontrolproject.entity.specialistModule;

public class ConferenceResult {

  private long resultId;  //会商结果ID
  private TConference conference;  //专家会商的事件对象
  private String conferenceDate; // 专家会商日期
  private String conferenceResult; // 专家会商结果

  public ConferenceResult() {
  }

  public ConferenceResult(TConference conference, String conferenceDate, String conferenceResult) {
    this.conference = conference;
    this.conferenceDate = conferenceDate;
    this.conferenceResult = conferenceResult;
  }

  public long getResultId() {
    return resultId;
  }

  public void setResultId(long resultId) {
    this.resultId = resultId;
  }

  public TConference getConference() {
    return conference;
  }

  public void setConference(TConference conference) {
    this.conference = conference;
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

  @Override
  public String toString() {
    return "ConferenceResult{" +
            "resultId=" + resultId +
            ", conference=" + conference +
            ", conferenceDate='" + conferenceDate + '\'' +
            ", conferenceResult='" + conferenceResult + '\'' +
            '}';
  }
}
