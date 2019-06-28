package com.AAAAAA.pestcontrolproject.entity.specialistModule;

import com.AAAAAA.pestcontrolproject.entity.eventModule.Event;

public class TConference {

  private long conferenceId; //专家会商ID
  private Event event;   //事件对象


  public long getConferenceId() {
    return conferenceId;
  }

  public void setConferenceId(long conferenceId) {
    this.conferenceId = conferenceId;
  }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
