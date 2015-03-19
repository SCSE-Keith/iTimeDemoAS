package com.colorfulmoment.itimedemo.models;

import java.util.Date;

public class PersonalEvent extends Event {

    private boolean timeOnly;

    public PersonalEvent(long id,
                         String title,
                         Date startTime,
                         Date endTime,
                         String description,
                         boolean isPrivate,
                         boolean enableAlarm,
                         int alarmTime,
                         boolean timeOnly){
        super(id, title, startTime, endTime, description, isPrivate, enableAlarm, alarmTime);
        this.timeOnly = timeOnly;
    }

    public boolean timeOnly(){
        return timeOnly;
    }

    public void setTimeOnly(boolean timeOnly){
        this.timeOnly = timeOnly;
    }

}
