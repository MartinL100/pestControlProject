package com.AAAAAA.pestcontrolproject.entity.userModule;


import java.sql.Date;

public class TLog {

  private long logId;
  private String logDescrip;
  private String logDate=new Date(System.currentTimeMillis()).toString();


  public long getLogId() {
    return logId;
  }

  public void setLogId(long logId) {
    this.logId = logId;
  }


  public String getLogDescrip() {
    return logDescrip;
  }

  public void setLogDescrip(String logDescrip) {
    this.logDescrip = logDescrip;
  }


  public String getLogDate() {
    return logDate;
  }

  public void setLogDate(String logDate) {
    this.logDate = logDate;
  }

}
