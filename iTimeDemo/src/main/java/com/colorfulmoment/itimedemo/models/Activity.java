package com.colorfulmoment.itimedemo.models;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Activity extends Event {
    private User mRaiser;
    private Group mGroupOfRaiser;
    private ArrayList<User> mParticipants;

    public Activity(long id,
                    String title,
                    Calendar startTime,
                    Calendar endTime,
                    String description,
                    boolean enableAlarm,
                    int alarmTime,
                    ArrayList<User> raiser,
                    Group groupOfRaiser,
                    ArrayList<User> participants){
        super(id, title, startTime, endTime, description, enableAlarm, alarmTime);
        this.mRaiser = mRaiser;
        this.mGroupOfRaiser = mGroupOfRaiser;
        this.mParticipants = mParticipants;
    }

    public User getRaiser(){
        return mRaiser;
    }

    public void setRaiser(User user){
        mRaiser = user;
    }

    public User getParticipant(int index){
        return mParticipants.get(index);
    }

    public int getParticipantCount(){
        return mParticipants.size();
    }

    public void addParticipant(User user){
        mParticipants.add(user);
    }

    public void removeParticipant(int index){
        mParticipants.remove(index);
    }


}
