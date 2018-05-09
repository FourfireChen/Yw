package com.creativecompany.common;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.creativecompany.R;
import com.creativecompany.data.bean.MyActivity;
import com.creativecompany.data.bean.Sponsor;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.creativecompany.util.ID.ACTIVITIES;
import static com.creativecompany.util.ID.SPONSORS;

/**
 * Created by 陈钊燚 on 2018/5/2.
 * QQ 1215638092
 * Github FourfireChen
 */

public class ActivitiesOrSponsorsAdapter<T> extends BaseAdapter {
    private ArrayList<T> mItems;
    private int type;

    public ActivitiesOrSponsorsAdapter(int type, @Nullable ArrayList<T> list) {
        if(list != null)
            mItems = list;
        this.type = type;
    }

    @Override
    public int getCount() {
        return mItems == null ? 0 : mItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.summary_item_activityorsponsor, parent, false);

        TextView itemSummary = view.findViewById(R.id.summary_summary);
        CircleImageView avator1 = view.findViewById(R.id.activityavator);
        TextView itemTitle = view.findViewById(R.id.summary_title);

        Drawable avator = null;
        String summary, title;
        Resources resources = parent.getResources();


        switch (type){
            case SPONSORS:
                avator = resources.getDrawable(R.drawable.me_black_36dp, null);
                title = ((Sponsor)mItems.get(position)).getName();
                summary = ((Sponsor)mItems.get(position)).getSummary();
                break;
            case ACTIVITIES:
                avator = resources.getDrawable(R.drawable.home_black_36dp, null);
                title = ((MyActivity)mItems.get(position)).getTitle();
                summary = ((MyActivity)mItems.get(position)).getSummary();
                break;
            default:
                title = "";
                summary = "";
                break;
        }

        avator1.setImageDrawable(avator);
        itemSummary.setText(summary);
        itemTitle.setText(title);

        return view;
    }

    public void setItems(ArrayList<T> items) {
        this.mItems = items;
    }

}
