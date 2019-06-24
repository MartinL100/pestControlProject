package com.AAAAAA.pestcontrolproject.entity.userModule;


public class TUser {

  private long userId;
  private TRole role;
  private String userName;
  private String realName;
  private String userPassword;

  public TRole getRole() {
    return role;
  }

  public void setRole(TRole role) {
    this.role = role;
  }
  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }





  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }


  public String getRealName() {
    return realName;
  }

  public void setRealName(String realName) {
    this.realName = realName;
  }


  public String getUserPassword() {
    return userPassword;
  }

  public void setUserPassword(String userPassword) {
    this.userPassword = userPassword;
  }

}
