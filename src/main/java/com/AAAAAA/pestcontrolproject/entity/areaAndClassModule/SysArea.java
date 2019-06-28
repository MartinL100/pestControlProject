package com.AAAAAA.pestcontrolproject.entity.areaAndClassModule;


import com.AAAAAA.pestcontrolproject.entity.Selected.SysSelectedType;

public class SysArea {

  private long areaId;
  private String areaName;
  private String areaTreeType;
  private String areaGoodTree;
  private SysSelectedType selectedType;
  private SysClass sysClass;

    public SysClass getSysClass() {
        return sysClass;
    }

    public void setSysClass(SysClass sysClass) {
        this.sysClass = sysClass;
    }

    public SysSelectedType getSelectedType() {
    return selectedType;
  }

  public void setSelectedType(SysSelectedType selectedType) {
    this.selectedType = selectedType;
  }




  public long getAreaId() {
    return areaId;
  }

  public void setAreaId(long areaId) {
    this.areaId = areaId;
  }


  public String getAreaName() {
    return areaName;
  }

  public void setAreaName(String areaName) {
    this.areaName = areaName;
  }


  public String getAreaTreeType() {
    return areaTreeType;
  }

  public void setAreaTreeType(String areaTreeType) {
    this.areaTreeType = areaTreeType;
  }


  public String getAreaGoodTree() {
    return areaGoodTree;
  }

  public void setAreaGoodTree(String areaGoodTree) {
    this.areaGoodTree = areaGoodTree;
  }



}
