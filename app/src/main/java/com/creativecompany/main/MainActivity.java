package com.creativecompany.main;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.ToxicBakery.viewpager.transforms.RotateUpTransformer;
import com.creativecompany.R;
import com.creativecompany.home.HomeFragment;
import com.creativecompany.me.MeFragment;
import com.creativecompany.mes.MessageFragment;
import com.creativecompany.util.ActivityCyclerListener;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private MainFragmentAdapter viewPagerAdapter;

    private ActivityCyclerListener mLifeCyclerListener;
    @BindView(R.id.main_toolbar_search)
    Button mainToolbarSearch;
    @BindView(R.id.main_toolbar)
    Toolbar mainToolbar;
    @BindView(R.id.main_viewpager)
    ViewPager mainViewpager;
    @BindView(R.id.main_nav)
    BottomNavigationViewEx mainNav;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
        mLifeCyclerListener = new ActivityCyclerListener(this, getLifecycle());
        getLifecycle().addObserver(mLifeCyclerListener);
        HomeFragment homeFragment = new HomeFragment();
        MessageFragment messageFragment = new MessageFragment();
        MeFragment meFragment = new MeFragment();
        ArrayList<Fragment> mainFragments = new ArrayList<>();
        mainFragments.add(homeFragment);
        mainFragments.add(messageFragment);
        mainFragments.add(meFragment);
        viewPagerAdapter = new MainFragmentAdapter(getSupportFragmentManager(), mainFragments);
        mainViewpager.setAdapter(viewPagerAdapter);
        mainViewpager.setPageTransformer(true, new RotateUpTransformer());
        mainViewpager.setOffscreenPageLimit(3);
        mainNav.setupWithViewPager(mainViewpager);
        mainToolbarSearch.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_toolbar_search:

                break;
        }
    }

}
