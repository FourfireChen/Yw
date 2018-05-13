package com.creativecompany.common;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.creativecompany.BaseFragment;
import com.creativecompany.R;
import com.creativecompany.all.AllActivity;
import com.creativecompany.data.bean.MyActivity;
import com.creativecompany.data.bean.Sponsor;
import com.creativecompany.detail.DetailActivity;
import com.creativecompany.sponsor.SponsorActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.creativecompany.util.ID.ACTIVITIES;
import static com.creativecompany.util.ID.FRAGEMTN_TYPE;
import static com.creativecompany.util.ID.SPONSORS;

/**
 * Created by 陈钊燚 on 2018/5/2.
 * QQ 1215638092
 * Github FourfireChen
 */

public class ActivitiesOrSponsorFragment extends BaseFragment implements AdapterView.OnItemClickListener {
    @BindView(R.id.home_item_title)
    TextView homeItemTitle;
    @BindView(R.id.home_item_all)
    Button homeItemAll;
    Unbinder unbinder;
    @BindView(R.id.home_activity_or_sponsor_list)
    ListView homelist;
    private int type;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //此处检查传入的类型，以确定该碎片是优秀主办方还是精彩活动
        checkType();

        View view = inflater.inflate(R.layout.main_home_activity_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);

        CommonModel commonModel = ViewModelProviders.of(this).get(CommonModel.class);

        String title;
        ActivitiesOrSponsorsAdapter activitiesOrSponsorsAdapter = null;


        switch (type) {

            case SPONSORS:
                title = "优秀主办方";
                activitiesOrSponsorsAdapter = new ActivitiesOrSponsorsAdapter<Sponsor>(type, commonModel.getSponsorList(), this);
                break;

            case ACTIVITIES:
                title = "精彩活动";
                activitiesOrSponsorsAdapter = new ActivitiesOrSponsorsAdapter<MyActivity>(type, commonModel.getActivityList(), this);
                break;

            default:
                title = "";
                break;
        }

        homeItemTitle.setText(title);

        homelist.setAdapter(activitiesOrSponsorsAdapter);

        homelist.setOnItemClickListener(this);

        commonModel.loadActivities(getActivity());
        commonModel.loadSponsors(getActivity());

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.home_item_all)
    public void onViewClicked() {
        Bundle types = new Bundle();
        types.putInt(FRAGEMTN_TYPE, type);
        jumpToAnotherActivity(AllActivity.class, types);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        switch (type) {
            case SPONSORS:
                jumpToAnotherActivity(SponsorActivity.class, null);
                break;
            case ACTIVITIES:
                jumpToAnotherActivity(DetailActivity.class, null);
                break;
        }

    }

    private void checkType() {
        try {
            Bundle bundle = getArguments();
            if (bundle == null) throw new Exception("没有传入该碎片的类型，无法显示");
            type = bundle.getInt(FRAGEMTN_TYPE);
            if (type != SPONSORS && type != ACTIVITIES) throw new Exception("传入类型错误");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
