package com.colorfulmoment.itimedemo.fragments;

import com.colorfulmoment.itimedemo.R;
import com.colorfulmoment.itimedemo.R.layout;
import com.colorfulmoment.itimedemo.adapters.GroupListAdapter;
import com.colorfulmoment.itimedemo.models.Group;
import com.colorfulmoment.itimedemo.tools.Stat;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class GroupFragment extends Fragment {

    private GroupListAdapter mAdapter;
    private ListView mListView;

	public static GroupFragment newInstance() {
		GroupFragment fragment = new GroupFragment();
		Bundle args = new Bundle();
		fragment.setArguments(args);
		return fragment;
	}

	public GroupFragment() {
		// Required empty public constructor
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_group, container, false);
        ArrayList<Group> groups = new ArrayList<Group>();
        for(int i = Stat.USERS.get(0).getGroupCount() - 1; i >= 0; i--){
            groups.add(Stat.USERS.get(0).getGroup(i));
        }
        mAdapter = new GroupListAdapter(groups, getActivity().getApplicationContext());
        mListView = (ListView)view.findViewById(R.id.group_list);
        mListView.setAdapter(mAdapter);
		return view;
	}
}
