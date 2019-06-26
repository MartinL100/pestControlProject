package com.AAAAAA.pestcontrolproject.entity.specialistModule;

public class ResultSpecialist {

  private ConferenceResult conferenceResult; //会商结果对象
  private  TSpecialist specialist;  // 专家对象

  public ResultSpecialist() {
  }

  public ResultSpecialist(ConferenceResult conferenceResult, TSpecialist specialist) {
    this.conferenceResult = conferenceResult;
    this.specialist = specialist;
  }

  public ConferenceResult getConferenceResult() {
    return conferenceResult;
  }

  public void setConferenceResult(ConferenceResult conferenceResult) {
    this.conferenceResult = conferenceResult;
  }

  public TSpecialist getSpecialist() {
    return specialist;
  }

  public void setSpecialist(TSpecialist specialist) {
    this.specialist = specialist;
  }
}
