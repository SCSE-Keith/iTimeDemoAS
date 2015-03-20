package com.colorfulmoment.itimedemo.fragments;

import com.alamkanak.weekview.WeekView;
import com.alamkanak.weekview.WeekViewEvent;
import com.colorfulmoment.itimedemo.R;
import com.colorfulmoment.itimedemo.models.User;
import com.colorfulmoment.itimedemo.tools.Stat;

import android.graphics.Color;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class PersonalFragment extends Fragment implements WeekView.MonthChangeListener{

    private WeekView mWeekView;

	public static PersonalFragment newInstance() {
		PersonalFragment fragment = new PersonalFragment();
		Bundle args = new Bundle();
		fragment.setArguments(args);
		return fragment;
	}

	public PersonalFragment() {
		// Required empty public constructor
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_personal, container, false);
        mWeekView = (WeekView)view.findViewById(R.id.weekView);

        mWeekView.setMonthChangeListener(this);

		return view;
	}

    @Override
    public List<WeekViewEvent> onMonthChange(int newYear, int newMonth) {
        List<WeekViewEvent> events = new ArrayList<WeekViewEvent>();

        User user = Stat.USERS.get(1);
        for(int i = 0; i < user.getEventCount(); i++) {
            WeekViewEvent event = user.getWeekViewEvent(i);
            if(event.getStartTime().get(Calendar.MONTH) == newMonth) {
                events.add(event);
            }
        }

        return events;
    }

}
