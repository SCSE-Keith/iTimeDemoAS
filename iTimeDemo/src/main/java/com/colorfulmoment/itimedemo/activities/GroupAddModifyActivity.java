package com.colorfulmoment.itimedemo.activities;

import com.colorfulmoment.itimedemo.R;
import com.colorfulmoment.itimedemo.R.layout;
import com.colorfulmoment.itimedemo.adapters.GroupAddAdapter;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class GroupAddModifyActivity extends Activity {

    private ListView mListView;
    private BaseAdapter mAdapter;
    private TextView mHead;
    private ArrayList<String> mTag;
    private ArrayList<String> mTitles;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_group_activity);

        initTitles();
        mListView = (ListView)findViewById(R.id.list_view_group_add_modify);
        mListView.setAdapter(mAdapter);
        mHead = (TextView)findViewById(R.id.text_head_group_add_modify);
	}

    private void initTitles() {
        mTag.add("基本信息");
        mTag.add("领导者");
        mTitles.add("基本信息");
        mTitles.add("组名");
        mTitles.add("描述");
        mTitles.add("领导者");
        mTitles.add("1");

        mAdapter = new GroupAddAdapter(mTag, mTitles, getApplicationContext());
    }

}
