package com.creativecompany.common;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
    private MutableLiveData<ArrayList<T>> mItems;
    private int type;
    private Fragment mFragment;


    ActivitiesOrSponsorsAdapter(int type, MutableLiveData<ArrayList<T>> mutableLiveData, Fragment fragment) {
        mItems = mutableLiveData;
        this.type = type;
        this.mFragment = fragment;

    }

    @Override
    public int getCount() {
         return mItems.getValue() == null ? 0 : mItems.getValue().size();
    }

    @Override
    public Object getItem(int position) {
        return mItems.getValue().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.summary_item_activityorsponsor, parent, false);

        TextView itemSummary = view.findViewById(R.id.summary_summary);
        CircleImageView avator = view.findViewById(R.id.activityavator);
        TextView itemTitle = view.findViewById(R.id.summary_title);

        Resources resources = parent.getResources();
        switch (type) {
            case SPONSORS:
                mItems.observe(mFragment, activityOrSponsor -> {
                    avator.setImageDrawable(resources.getDrawable(R.drawable.me_black_36dp));
                    itemSummary.setText(((Sponsor)activityOrSponsor.get(position)).getSummary());
                    itemTitle.setText((((Sponsor) activityOrSponsor.get(position)).getName()));
                });
                break;
            case ACTIVITIES:
                mItems.observe(mFragment, activityOrSponsor -> {
                    avator.setImageDrawable(resources.getDrawable(R.drawable.home_black_36dp));
                    itemSummary.setText(((MyActivity)activityOrSponsor.get(position)).getSummary());
                    itemTitle.setText((((MyActivity) activityOrSponsor.get(position)).getTitle()));
                });
                break;
            default:
                break;
        }



        return view;
    }

}
