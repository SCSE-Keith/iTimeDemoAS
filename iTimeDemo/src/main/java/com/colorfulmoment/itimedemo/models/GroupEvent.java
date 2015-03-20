package com.colorfulmoment.itimedemo.models;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class GroupEvent extends Event {

    public GroupEvent(long id,
                      String title,
                      Calendar startTime,
                      Calendar endTime,
                      String description,
                      boolean enableAlarm,
                      int alarmTime){
        super(id, title, startTime, endTime, description, enableAlarm, alarmTime);
    }
}
