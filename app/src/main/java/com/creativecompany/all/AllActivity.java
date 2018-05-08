package com.creativecompany.all;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.creativecompany.R;
import com.creativecompany.all.activity.ActivityFragment;
import com.creativecompany.all.sponor.SponorFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 陈钊燚 on 2018/5/3.
 * QQ 1215638092
 * Github FourfireChen
 */

public class AllActivity extends AppCompatActivity{

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
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        fragments.add(new ActivityFragment());
        fragments.add(new SponorFragment());
        allViewpager.setAdapter(new AllPagerAdatper(getSupportFragmentManager(), fragments));
        allTab.setupWithViewPager(allViewpager);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
