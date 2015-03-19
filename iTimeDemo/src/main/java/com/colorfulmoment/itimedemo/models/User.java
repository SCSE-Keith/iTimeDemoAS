package com.colorfulmoment.itimedemo.models;

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

    public void getEventCount(){
        mEvent.size();
    }
}
