package com.colorfulmoment.itimedemo.models;

import com.alamkanak.weekview.WeekView;
import com.alamkanak.weekview.WeekViewEvent;

import java.util.ArrayList;

public class User {
    private long mId;
    private String mName;
    private ArrayList<Group> mGroups;
    private ArrayList<PersonalEvent> mEvent;

    public User(long mId, String mName){
        this.mId = mId;
        this.mName = mName;
        this.mGroups = new ArrayList<Group>();
        this.mEvent = new ArrayList<PersonalEvent>();
    }

    public long getId(){
        return mId;
    }

    public String getName(){
        return mName;
    }

    public void addGroup(Group group){
        mGroups.add(group);
    }

    public void addEvent(PersonalEvent event){
        mEvent.add(event);
    }

    public PersonalEvent getEvent(int index){
        return mEvent.get(index);
    }

    public int getEventCount(){
        return mEvent.size();
    }

    public Group getGroup(int index){
        return mGroups.get(index);
    }

    public int getGroupCount(){
        return mGroups.size();
    }

    public WeekViewEvent getWeekViewEvent(int index) {
        PersonalEvent event = mEvent.get(index);
        return new WeekViewEvent(event.getId(), event.getTitle(), event.getStartTime(), event.getEndTime());
    }
}
