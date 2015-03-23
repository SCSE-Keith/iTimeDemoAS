package com.colorfulmoment.itimedemo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.colorfulmoment.itimedemo.R;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by aa on 15/3/23.
 */
public class GroupSpinnerAdapter extends BaseAdapter{

    private ArrayList<String> mList;
    private LayoutInflater mInflater;

    public GroupSpinnerAdapter(ArrayList<String> mList, Context context){
        this.mList = mList;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        view = mInflater.inflate(R.layout.spinner_item, null);
        TextView mText = (TextView)view.findViewById(R.id.text_group_type);
        mText.setText((String)getItem(position));
        return view;
    }
}
