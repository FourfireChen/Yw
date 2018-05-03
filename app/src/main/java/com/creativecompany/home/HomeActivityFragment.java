package com.creativecompany.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.creativecompany.BaseFragment;
import com.creativecompany.R;
import com.creativecompany.all.AllActivity;
import com.creativecompany.data.bean.Activity;
import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by 陈钊燚 on 2018/5/2.
 * QQ 1215638092
 * Github FourfireChen
 */

public class HomeActivityFragment extends BaseFragment implements AdapterView.OnItemClickListener {
    @BindView(R.id.home_item_title)
    TextView homeItemTitle;
    @BindView(R.id.home_item_all)
    Button homeItemAll;
    Unbinder unbinder;
    @BindView(R.id.home_activitylist)
    ListView homeActivitylist;
    private ArrayList<Activity> activities = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_home_activity_fragment, container, false);
        for (int i = 0; i < 3; i++) {
            activities.add(new Activity(null, null, null, "就是我就是我我就是活动", null, "1"));
        }
        unbinder = ButterKnife.bind(this, view);
        homeActivitylist.setAdapter(new HomeActivitiesAdapter(activities));
        homeActivitylist.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.home_item_all)
    public void onViewClicked() {
        jumpToAnotherActivity(AllActivity.class);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        /**
         * jumpToAnotherActivity(DetailActivity.class);
         */
        Toast.makeText(getContext(), "点了活动" + position, Toast.LENGTH_SHORT).show();
    }
}
