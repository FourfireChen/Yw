package com.creativecompany.all;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.creativecompany.BaseActivity;
import com.creativecompany.R;
import com.creativecompany.all.allContract.IAllView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 陈钊燚 on 2018/5/3.
 * QQ 1215638092
 * Github FourfireChen
 */

public class AllActivity extends BaseActivity<AllPresenter> implements IAllView {

    @BindView(R.id.all_toolbar)
    Toolbar allToolbar;
    @BindView(R.id.all_tab)
    TabLayout allTab;
    @BindView(R.id.all_viewpager)
    ViewPager allViewpager;
    private ArrayList<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_activity);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        setSupportActionBar(allToolbar);
        fragments.add(new AllActivityFragment());
        fragments.add(new AllSponorFragment());
        allViewpager.setAdapter(new AllPagerAdatper(getSupportFragmentManager(), fragments));
        allTab.setupWithViewPager(allViewpager);
    }
}
