package com.creativecompany.all.sponor;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.creativecompany.R;
import com.creativecompany.data.bean.Sponsor;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 陈钊燚 on 2018/5/3.
 * QQ 1215638092
 * Github FourfireChen
 */

public class SponorFragment extends Fragment {
    @BindView(R.id.all_sponsor_good_sponsors)
    ImageView mAllSponsorGoodSponsors;
    @BindView(R.id.all_sponsors_list)
    RecyclerView mAllSponsorsList;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.all_sponsor_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        init();
        return view;
    }

    private void init() {
        //todo:获得优秀主办方的图片，并设置



        ArrayList<Sponsor> sponsors = new ArrayList<>();
        sponsors.add(new Sponsor("软院义工部", "来自我科的一个可爱的部门", null, 2000, null));
        sponsors.add(new Sponsor("软院义工部", "来自我科的一个可爱的部门", null, 2000, null));
        sponsors.add(new Sponsor("软院义工部", "来自我科的一个可爱的部门", null, 2000, null));
        SponsorListAdapter sponsorListAdapter = new SponsorListAdapter(sponsors);
        mAllSponsorsList.setAdapter(sponsorListAdapter);
        mAllSponsorsList.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
