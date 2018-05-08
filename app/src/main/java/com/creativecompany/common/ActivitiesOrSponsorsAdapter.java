package com.creativecompany.common;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.creativecompany.R;
import com.creativecompany.data.bean.MyActivity;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by 陈钊燚 on 2018/5/2.
 * QQ 1215638092
 * Github FourfireChen
 */

public class ActivitiesOrSponsorsAdapter extends BaseAdapter {
    private CircleImageView activityavator;
    private TextView homeItemListContent;
    private ArrayList<MyActivity> activities;


    public ActivitiesOrSponsorsAdapter(ArrayList<MyActivity> activities) {
        this.activities = activities;
    }

    @Override
    public int getCount() {
        return activities == null ? 0 : activities.size();
    }

    @Override
    public Object getItem(int position) {
        return activities.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_home_item_listitem, parent, false);
        homeItemListContent = view.findViewById(R.id.home_item_list_content);
        homeItemListContent.setText(activities.get(position).getContent());
        return view;
    }

    public void setActivities(ArrayList<MyActivity> activities) {
        this.activities = activities;
    }

}
