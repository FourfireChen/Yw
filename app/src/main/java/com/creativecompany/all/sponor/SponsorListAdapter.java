package com.creativecompany.all.sponor;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.creativecompany.R;
import com.creativecompany.data.bean.MyActivity;
import com.creativecompany.data.bean.Sponsor;

import java.util.ArrayList;

/**
 * Created by 陈钊燚 on 2018/5/16.
 * QQ 1215638092
 * Github FourfireChen
 */
public class SponsorListAdapter extends RecyclerView.Adapter<SponsorListAdapter.SponsorViewHolder> {
    ArrayList<Sponsor> mSponsors;

    public SponsorListAdapter(ArrayList<Sponsor> sponsors) {
        mSponsors = sponsors;
    }

    @Override
    public SponsorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.summary_item, parent, false);
        SponsorViewHolder sponsorViewHolder = new SponsorViewHolder(view);
        return sponsorViewHolder;
    }

    @Override
    public void onBindViewHolder(SponsorViewHolder holder, int position) {
        //todo:头像是假的，要获取真的图
        /**
         * Drawable d = BytesToDrawable(mSponsor.get(position).getAvator());
         * */
        Drawable drawable = holder.itemView.getResources().getDrawable(R.drawable.me_black_36dp);
        holder.sponsorAvator.setImageDrawable(drawable);

        holder.sponsorName.setText(mSponsors.get(position).getName());
        holder.sponsorSummary.setText(mSponsors.get(position).getSummary());

    }

    @Override
    public int getItemCount() {
        return mSponsors.size();
    }

    class SponsorViewHolder extends  RecyclerView.ViewHolder{
        ImageView sponsorAvator;
        TextView sponsorName;
        TextView sponsorSummary;


        public SponsorViewHolder(View itemView) {
            super(itemView);
            sponsorAvator = itemView.findViewById(R.id.summary_avator);
            sponsorName = itemView.findViewById(R.id.summary_title);
            sponsorSummary = itemView.findViewById(R.id.summary_summary);

        }
    }
}
