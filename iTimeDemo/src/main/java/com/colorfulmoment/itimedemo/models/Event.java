package com.colorfulmoment.itimedemo.models;

import java.util.Date;

public abstract class Event {
    private long mId;
    private String mTitle;
    private Date mStartTime;
    private Date mEndTime;
    private String mDescription;
    private boolean isPrivate;
    private boolean enableAlarm;
    private int mAlarmTime;

    public Event(long mId, String mTitle, Date mStartTime, Date mEndTime, String mDescription, boolean isPrivate, boolean enableAlarm, int mAlarmTime){
        this.mId = mId;
        this.mTitle = mTitle;
        this.mStartTime = mStartTime;
        this.mEndTime = mEndTime;
        this.mDescription = mDescription;
        this.isPrivate = isPrivate;
        this.enableAlarm = enableAlarm;
        this.mAlarmTime = mAlarmTime;
    }

    public long getId(){
        return mId;
    }

    public void setTitle(String title){
        mTitle = title;
    }

    public void setStartTime(Date startTime, Date endTime){
        mStartTime = startTime;
        mEndTime = endTime;
    }

    public void setDescription(String description){
        mDescription = description;
    }

    public void setPrivate(boolean pr){
        isPrivate = pr;
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

    public Date getStartTime(){
        return mStartTime;
    }

    public Date getEndTime(){
        return mEndTime;
    }

    public String getDescription(){
        return mDescription;
    }

    public boolean isPrivate(){
        return isPrivate;
    }

    public boolean isAlarm(){
        return enableAlarm;
    }

    public int getAlarmTime(){
        return mAlarmTime;
    }

}
