package com.colorfulmoment.itimedemo.tools;

import com.colorfulmoment.itimedemo.models.*;

import java.util.ArrayList;

public class Stat {
    public static ArrayList<Group> GROUPS = new ArrayList<Group>();
    public static ArrayList<User> USERS= new ArrayList<User>();

    public static void initStat(){
        USERS.add(new User(1, "周文轩"));
        USERS.add(new User(2, "单堔"));
        USERS.add(new User(3, "郑发淳"));
        GROUPS.add(new Group(1, "电影社", "", USERS.get(2)));
    }
}
