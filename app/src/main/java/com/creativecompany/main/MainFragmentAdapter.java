package com.creativecompany.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by 45089 on 2018/4/7.
 */

public class MainFragmentAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> mainFragments;

    public MainFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    public MainFragmentAdapter(FragmentManager fm, ArrayList<Fragment> mainFragments) {
        super(fm);
        this.mainFragments = mainFragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mainFragments.get(position);
    }

    @Override
    public int getCount() {
        return mainFragments.size();
    }

}
