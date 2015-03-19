package com.colorfulmoment.itimedemo.models;

import java.util.ArrayList;
import java.util.Date;

public class GroupEvent extends Event {

    public GroupEvent(long id,
                      String title,
                      Date startTime,
                      Date endTime,
                      String description,
                      boolean isPrivate,
                      boolean enableAlarm,
                      int alarmTime){
        super(id, title, startTime, endTime, description, isPrivate, enableAlarm, alarmTime);
    }
}
