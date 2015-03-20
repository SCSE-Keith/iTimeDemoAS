package com.colorfulmoment.itimedemo.models;

import java.util.ArrayList;
import java.util.Date;

public class Group {
    private long mId;
    private String mName;
//    private Date mFoundationTimestamp;
    private String mDescription;
    private User mLeader;
    private ArrayList<User> mMembers;
    private ArrayList<GroupEvent> mGroupEvent;
    private ArrayList<Activity> mActivity;

    public Group(long id,
//                 Date timeStamp,
                 String name,
                 String description,
                 User leader){
        this.mId = id;
        this.mName = name;
//        this.mFoundationTimestamp = timeStamp;
        this.mDescription = description;
        this.mLeader = leader;
        this.mMembers = new ArrayList<User>();
        this.mGroupEvent = new ArrayList<GroupEvent>();
        this.mActivity = new ArrayList<Activity>();
    }



    public long getId(){
        return mId;
    }

    public String getName(){
        return mName;
    }

    public void setName(String name){
        mName = name;
    }

//    public Date getFoundationTimestamp(){
//        return mFoundationTimestamp;
//    }

    public String getDescription(){
        return mDescription;
    }

    public void setDescription(String des){
        mDescription = des;
    }

    public int getMemberCount(){
        return mMembers.size() + 1;
    }

    public void joinIn(User newMember){
        mMembers.add(newMember);
    }

    public void changeLeader(User newLeader){
        mLeader = newLeader;
    }

    public void addGroupEvent(GroupEvent newEvent){
        mGroupEvent.add(newEvent);
    }

    public GroupEvent getGroupEvent(int index){
        return mGroupEvent.get(index);
    }

    public int getGroupEventCount(){
        return mGroupEvent.size();
    }

    public void addActivity(Activity newActivity){
        mActivity.add(newActivity);
    }

    public Activity getActivity(int index){
        return mActivity.get(index);
    }

    public int getActivityCount(){
        return mActivity.size();
    }

}
