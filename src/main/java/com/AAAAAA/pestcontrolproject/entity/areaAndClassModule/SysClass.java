package com.AAAAAA.pestcontrolproject.entity.areaAndClassModule;


public class SysClass {

  private long sclassId;

  private String sclassName;
  private String sclassLeader;
  private String sclassLeaderTel;
  private long sclassNum;
  private String sclassStartDate;
  private SysArea area;

  public SysArea getArea() {
    return area;
  }

  public void setArea(SysArea area) {
    this.area = area;
  }

  public long getSclassId() {
    return sclassId;
  }

  public void setSclassId(long sclassId) {
    this.sclassId = sclassId;
  }





  public String getSclassName() {
    return sclassName;
  }

  public void setSclassName(String sclassName) {
    this.sclassName = sclassName;
  }


  public String getSclassLeader() {
    return sclassLeader;
  }

  public void setSclassLeader(String sclassLeader) {
    this.sclassLeader = sclassLeader;
  }


  public String getSclassLeaderTel() {
    return sclassLeaderTel;
  }

  public void setSclassLeaderTel(String sclassLeaderTel) {
    this.sclassLeaderTel = sclassLeaderTel;
  }


  public long getSclassNum() {
    return sclassNum;
  }

  public void setSclassNum(long sclassNum) {
    this.sclassNum = sclassNum;
  }


  public String getSclassStartDate() {
    return sclassStartDate;
  }

  public void setSclassStartDate(String sclassStartDate) {
    this.sclassStartDate = sclassStartDate;
  }

}
