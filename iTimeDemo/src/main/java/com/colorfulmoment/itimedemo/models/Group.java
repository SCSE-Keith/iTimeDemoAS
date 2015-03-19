package com.colorfulmoment.itimedemo.models;

import java.util.ArrayList;
import java.util.Date;

public class Group {
    private long mId;
    private String mName;
//    private Date mFoundationTimestamp;
    private String mDescription;
    private ArrayList<User> mLeaders;
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
        this.mLeaders = new ArrayList<User>();
        mLeaders.add(leader);
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
}
