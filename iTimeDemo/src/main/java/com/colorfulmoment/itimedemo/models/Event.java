package com.colorfulmoment.itimedemo.models;

import java.util.Calendar;
import java.util.Date;

public abstract class Event {
    private long mId;
    private String mTitle;
    private Calendar mStartTime;
    private Calendar mEndTime;
    private String mDescription;
    private boolean enableAlarm;
    private int mAlarmTime;

    public Event(long mId, String mTitle, Calendar mStartTime, Calendar mEndTime, String mDescription, boolean enableAlarm, int mAlarmTime){
        this.mId = mId;
        this.mTitle = mTitle;
        this.mStartTime = mStartTime;
        this.mEndTime = mEndTime;
        this.mDescription = mDescription;
        this.enableAlarm = enableAlarm;
        this.mAlarmTime = mAlarmTime;
    }

    public long getId(){
        return mId;
    }

    public void setTitle(String title){
        mTitle = title;
    }

    public void setStartTime(Calendar startTime, Calendar endTime){
        mStartTime = startTime;
        mEndTime = endTime;
    }

    public void setDescription(String description){
        mDescription = description;
    }


    public void setAlarm(boolean alarm, int alarmTime){
        enableAlarm = alarm;
        if(alarm) {
            mAlarmTime = alarmTime;
        }
    }

    public String getTitle(){
        return mTitle;
    }

    public Calendar getStartTime(){
        return mStartTime;
    }

    public Calendar getEndTime(){
        return mEndTime;
    }

    public String getDescription(){
        return mDescription;
    }

    public boolean isAlarm(){
        return enableAlarm;
    }

    public int getAlarmTime(){
        return mAlarmTime;
    }

}
