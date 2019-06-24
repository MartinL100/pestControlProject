package com.AAAAAA.pestcontrolproject.entity.userModule;


public class TPower {

  private long powerId;
  private TRole role;
  private String powerName;
  private String powerResource;
  private long powerTag;


  public long getPowerId() {
    return powerId;
  }

  public void setPowerId(long powerId) {
    this.powerId = powerId;
  }


  public TRole getRole() {
    return role;
  }

  public void setRole(TRole role) {
    this.role = role;
  }

  public String getPowerName() {
    return powerName;
  }

  public void setPowerName(String powerName) {
    this.powerName = powerName;
  }


  public String getPowerResource() {
    return powerResource;
  }

  public void setPowerResource(String powerResource) {
    this.powerResource = powerResource;
  }


  public long getPowerTag() {
    return powerTag;
  }

  public void setPowerTag(long powerTag) {
    this.powerTag = powerTag;
  }

}
