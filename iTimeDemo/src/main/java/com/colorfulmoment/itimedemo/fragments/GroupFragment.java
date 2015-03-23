package com.colorfulmoment.itimedemo.fragments;

import com.colorfulmoment.itimedemo.R;
import com.colorfulmoment.itimedemo.R.layout;
import com.colorfulmoment.itimedemo.adapters.GroupListAdapter;
import com.colorfulmoment.itimedemo.adapters.GroupSpinnerAdapter;
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
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class GroupFragment extends Fragment{

    private GroupListAdapter mListAdapter;
    private GroupSpinnerAdapter mSpinnerAdapter;
    private ListView mListView;
    private Spinner mSpinner;

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
		View view = inflater.inflate(R.layout.fragment_group, container, false); //找到Fragment视图布局
        initSpinner(view);
        initListView(view);
		return view;
	}

    private void initSpinner(View view) {
        ArrayList<String> types = new ArrayList<String>();
        types.add("加入的团体");
        types.add("发起的团体");
        types.add("关注的团体");
        mSpinner = (Spinner)view.findViewById(R.id.spinner_group_type);
        mSpinnerAdapter = new GroupSpinnerAdapter(types, getActivity().getApplicationContext());
        mSpinner.setAdapter(mSpinnerAdapter);
    }

    private void initListView(View view) {
        final ArrayList<Group> groups = new ArrayList<Group>();
        //取得数据
        for(int i = Stat.USERS.get(0).getGroupCount() - 1; i >= 0; i--){
            groups.add(Stat.USERS.get(0).getGroup(i));
        }

        //设置Adapter
        mListAdapter = new GroupListAdapter(groups, getActivity().getApplicationContext()); //实例化控制列表项视图的Adapter
        mListView = (ListView)view.findViewById(R.id.group_list);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                return false;
            }
        });
        mListView.setAdapter(mListAdapter);
    }
}
