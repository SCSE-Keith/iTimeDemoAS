package com.colorfulmoment.itimedemo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.colorfulmoment.itimedemo.R;
import com.colorfulmoment.itimedemo.models.Group;

import java.util.ArrayList;
import java.util.List;

public class GroupListAdapter extends BaseAdapter {

    private List<Group> mGroupList;
    private LayoutInflater mInflater;

    public GroupListAdapter(ArrayList<Group> groupList, Context context){
        this.mGroupList = groupList;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mGroupList.size();
    }

    @Override
    public Object getItem(int position) {
        return mGroupList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        view = mInflater.inflate(R.layout.list_item_group, null);
        TextView name = (TextView)view.findViewById(R.id.text_group_name);
        TextView info = (TextView)view.findViewById(R.id.text_other_info);
        TextView member = (TextView)view.findViewById(R.id.text_members_count);
        name.setText(((Group)getItem(position)).getName());
        member.setText(((Group)getItem(position)).getMemberCount() + "个成员");

        return view;
    }
}
