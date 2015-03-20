package com.colorfulmoment.itimedemo.tools;

import android.graphics.Color;

import com.alamkanak.weekview.WeekViewEvent;
import com.colorfulmoment.itimedemo.models.*;

import java.util.ArrayList;
import java.util.Calendar;

public abstract class Stat {
    public static ArrayList<Group> GROUPS = new ArrayList<Group>();
    public static ArrayList<User> USERS= new ArrayList<User>();

    public static void initStat(){
        USERS.add(new User(0, "周文轩"));
        USERS.add(new User(1, "单堔"));
        USERS.add(new User(2, "郑发淳"));
        GROUPS.add(new Group(0, "电影社", "", USERS.get(2)));
        Calendar s1 = Calendar.getInstance(), e1 = Calendar.getInstance(),
            s2 = Calendar.getInstance(), e2 = Calendar.getInstance();
        s1.set(2015, 3 - 1, 19, 14, 0, 0);
        e1.set(2015, 3 - 1, 19, 16, 0, 0);

        s2.set(2015, 3 - 1, 20, 7, 0, 0);
        e2.set(2015, 3 - 1, 20, 10, 0, 0);
        USERS.get(0).addEvent(new PersonalEvent(1, "GRE课程", s1, e1, "", false, 0, true));
        USERS.get(0).addEvent(new PersonalEvent(2, "看电影", s2, e2, "", false, 0, true));
        GROUPS.get(0).joinIn(USERS.get(0));
        GROUPS.get(0).joinIn(USERS.get(1));
        USERS.get(0).addGroup(GROUPS.get(0));
    }
}
