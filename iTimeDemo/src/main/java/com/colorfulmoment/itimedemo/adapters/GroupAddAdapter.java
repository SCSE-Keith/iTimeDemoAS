package com.colorfulmoment.itimedemo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.colorfulmoment.itimedemo.R;

import java.util.ArrayList;

/**
 * Created by aa on 15/3/22.
 */
public class GroupAddAdapter extends BaseAdapter{
    private ArrayList<String> mTags;
    private ArrayList<String> mTitles;
    private LayoutInflater mInflater;

    public GroupAddAdapter(ArrayList<String> mTags, ArrayList<String> mTitles, Context context){
        this.mTags = mTags;
        this.mTitles = mTitles;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mTitles.size();
    }

    @Override
    public Object getItem(int position) {
        return mTitles.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(mTags.contains(getItem(position))){
            view = mInflater.inflate(R.layout.list_item_add_modify_group_gap, null);
            TextView text = (TextView)view.findViewById(R.id.text_gap);
            text.setText(getItem(position).toString());
        }
        else {
            view = mInflater.inflate(R.layout.list_item_add_modify_group_text, null);
            TextView text = (TextView)view.findViewById(R.id.text_title);
            text.setText(getItem(position).toString());
        }
        return view;
    }
}
