package com.AAAAAA.pestcontrolproject.entity.specialistModule;


public class ResultSpecialist {

  private long resultId;//结果ID
  private TSpecialist specialist;//专家对象

  public ResultSpecialist() {
  }

  public ResultSpecialist(TSpecialist specialist) {
    this.specialist = specialist;
  }

  public long getResultId() {
    return resultId;
  }

  public void setResultId(long resultId) {
    this.resultId = resultId;
  }

  public TSpecialist getSpecialist() {
    return specialist;
  }

  public void setSpecialist(TSpecialist specialist) {
    this.specialist = specialist;
  }

  @Override
  public String toString() {
    return "ResultSpecialist{" +
            "resultId=" + resultId +
            ", specialist=" + specialist +
            '}';
  }
}
