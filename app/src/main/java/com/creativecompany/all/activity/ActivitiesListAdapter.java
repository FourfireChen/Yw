package com.creativecompany.all.activity;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.creativecompany.R;
import com.creativecompany.data.bean.Activity;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by 陈钊燚 on 2018/5/6.
 * QQ 1215638092
 * Github FourfireChen
 */

public class ActivitiesListAdapter extends RecyclerView.Adapter<ActivitiesListAdapter.ActivitiesViewHolder> {
    private ArrayList<Activity> mActivities;

    public ActivitiesListAdapter(ArrayList<Activity> activities) {
        mActivities = activities;
    }

    public ActivitiesListAdapter() {
    }

    @Override
    public ActivitiesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.all_act_item_fragment, parent, false);
        return new ActivitiesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ActivitiesViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return mActivities == null ? 0 : mActivities.size();
    }

    public void setActivities(ArrayList<Activity> activities) {
        mActivities = activities;
    }

    class ActivitiesViewHolder extends RecyclerView.ViewHolder{
        private CircleImageView mOrganizerAvator;
        private TextView title, content;
        private ImageView mPost;
        public ActivitiesViewHolder(View itemView) {
            super(itemView);
            mOrganizerAvator = itemView.findViewById(R.id.organizer_avator);
            title = itemView.findViewById(R.id.act_title);
            content = itemView.findViewById(R.id.act_content);
            mPost = itemView.findViewById(R.id.act_post);
        }
    }
}
