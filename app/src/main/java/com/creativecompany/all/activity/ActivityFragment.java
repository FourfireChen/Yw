package com.creativecompany.all.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.creativecompany.BaseFragment;
import com.creativecompany.R;
import com.creativecompany.data.bean.MyActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by 陈钊燚 on 2018/5/3.
 * QQ 1215638092
 * Github FourfireChen
 */

public class ActivityFragment extends BaseFragment implements DrawerFragemnt.DrawerCallback {
    @BindView(R.id.all_peoplenumber)
    Button allPeoplenumber;
    @BindView(R.id.all_time)
    Button allTime;
    @BindView(R.id.all_selector)
    Button allSelector;
    @BindView(R.id.all_list)
    RecyclerView allList;
    Unbinder unbinder;
    @BindView(R.id.all_act_drawer)
    DrawerLayout allActDrawer;


    private ActivitiesListAdapter mActivitiesListAdapter = new ActivitiesListAdapter();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.all_act_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);

        ActivityModel activityModel = ViewModelProviders.of(this).get(ActivityModel.class);

        activityModel.getActivities().observe(this, mActivities -> {
            mActivitiesListAdapter.setActivities((ArrayList<MyActivity>) mActivities);
        });

        activityModel.loadActivity();

        init();

        return view;
    }

    private void init() {
        FragmentManager manager = getFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        DrawerFragemnt drawerFragemnt = new DrawerFragemnt();
        drawerFragemnt.setDrawerCallback(this);
        fragmentTransaction.replace(R.id.all_act_drawerplace, drawerFragemnt);
        fragmentTransaction.commit();
        allList.setAdapter(mActivitiesListAdapter);
        allList.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.all_peoplenumber, R.id.all_time, R.id.all_selector})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.all_peoplenumber:
                break;
            case R.id.all_time:
                break;
            case R.id.all_selector:
                allActDrawer.openDrawer(Gravity.END);
                break;
        }
    }

    @Override
    public void closeDrawer() {
        allActDrawer.closeDrawers();
    }
}
