package com.colorfulmoment.itimedemo.models;

import java.util.Calendar;
import java.util.Date;

public class PersonalEvent extends Event {

    private boolean timeOnly;

    public PersonalEvent(long id,
                         String title,
                         Calendar startTime,
                         Calendar endTime,
                         String description,
                         boolean enableAlarm,
                         int alarmTime,
                         boolean timeOnly){
        super(id, title, startTime, endTime, description, enableAlarm, alarmTime);
        this.timeOnly = timeOnly;
    }

    public boolean timeOnly(){
        return timeOnly;
    }

    public void setTimeOnly(boolean timeOnly){
        this.timeOnly = timeOnly;
    }

}
