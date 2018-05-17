package com.creativecompany.mes;

import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.creativecompany.R;
import com.creativecompany.data.bean.Message;
import com.creativecompany.data.bean.MyActivity;

import java.util.ArrayList;

/**
 * Created by 陈钊燚 on 2018/5/17.
 * QQ 1215638092
 * Github FourfireChen
 */
public class MessagesAdapter extends RecyclerView.Adapter<MessagesAdapter.MessagesViewHolder> {
    ArrayList<MyActivity> mActivities;

    public MessagesAdapter(ArrayList<MyActivity> activities) {
        mActivities = activities;
    }

    @Override
    public MessagesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.summary_item, parent, false);
        return new MessagesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MessagesViewHolder holder, int position) {
        holder.name.setText(mActivities.get(position).getTitle());
        holder.summary.setText(mActivities.get(position).getSummary());
    }

    @Override
    public int getItemCount() {
        return mActivities.size();
    }

    class MessagesViewHolder extends RecyclerView.ViewHolder{
        TextView summary, name;
        ImageView avator;


        public MessagesViewHolder(View itemView) {
            super(itemView);
            summary = itemView.findViewById(R.id.summary_summary);
            name = itemView.findViewById(R.id.summary_title);
            avator = itemView.findViewById(R.id.summary_avator);
        }
    }
}
