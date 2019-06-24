package com.AAAAAA.pestcontrolproject.entity.userModule;


import java.util.List;

public class TRole {

  private long roleId;
  private String roleName;
  private  TUser user;
  private List<TPower> powers;

  public TUser getUser() {
    return user;
  }

  public void setUser(TUser user) {
    this.user = user;
  }

  public List<TPower> getPowers() {
    return powers;
  }

  public void setPowers(List<TPower> powers) {
    this.powers = powers;
  }

  public long getRoleId() {
    return roleId;
  }

  public void setRoleId(long roleId) {
    this.roleId = roleId;
  }


  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

}
