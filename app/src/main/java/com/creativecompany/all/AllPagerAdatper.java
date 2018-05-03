package com.creativecompany.all;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by 陈钊燚 on 2018/5/3.
 * QQ 1215638092
 * Github FourfireChen
 */

public class AllPagerAdatper extends FragmentPagerAdapter {
    ArrayList<Fragment> fragments;

    public AllPagerAdatper(FragmentManager fm, ArrayList<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments == null ? 0 : fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position) {
            case 0:
                title = "活动";
                break;
            case 1:
                title = "主办方";
                break;
            default:
                break;
        }
        return title;
    }
}
