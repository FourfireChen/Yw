package com.creativecompany.main;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.ToxicBakery.viewpager.transforms.RotateUpTransformer;
import com.creativecompany.BaseActivity;
import com.creativecompany.R;
import com.creativecompany.home.HomeFragment;
import com.creativecompany.main.MainContract.ImainPresenter;
import com.creativecompany.main.MainContract.ImainView;
import com.creativecompany.me.MeFragment;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bmob.v3.Bmob;


public class MainActivity extends BaseActivity<ImainPresenter> implements View.OnClickListener, ImainView {
    private MainFragmentAdapter viewPagerAdapter;
    private ImainPresenter imainPresenter;
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
        Bmob.initialize(this, "42c73e0de9562a39238f555783e882bd");
        setPresenter(new MainPresenter(this));
        imainPresenter = getPresenter();
        //todo:这里要做一个是否已登录的判断，或者是在me中做一个未登录的提示
        initView();
    }

    private void initView() {
        HomeFragment homeFragment = new HomeFragment();
        MeFragment meFragment = new MeFragment();
        ArrayList<Fragment> mainFragments = new ArrayList<>();
        mainFragments.add(homeFragment);
        mainFragments.add(meFragment);
        viewPagerAdapter = new MainFragmentAdapter(getSupportFragmentManager(), mainFragments);
        mainViewpager.setAdapter(viewPagerAdapter);
        mainViewpager.setPageTransformer(true, new RotateUpTransformer());
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
