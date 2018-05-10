package com.creativecompany.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.creativecompany.BaseFragment;
import com.creativecompany.R;
import com.creativecompany.common.ActivitiesOrSponsorFragment;
import com.creativecompany.data.bean.MyActivity;
import com.creativecompany.data.bean.Sponsor;
import com.creativecompany.home.HomeContract.IhomePresenter;
import com.creativecompany.home.HomeContract.IhomeView;
import com.creativecompany.main.MainFragmentAdapter;
import com.creativecompany.position.PositionActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.relex.circleindicator.CircleIndicator;

import static com.creativecompany.util.ID.ACTIVITIES;
import static com.creativecompany.util.ID.FRAGEMTN_TYPE;
import static com.creativecompany.util.ID.SPONSORS;

/**
 * Created by 45089 on 2018/4/7.
 */

public class HomeFragment extends BaseFragment<IhomePresenter> implements IhomeView {
    @BindView(R.id.main_home_headerviewpager)
    ViewPager mainHomeHeaderviewpager;
    @BindView(R.id.main_home_headerindicator)
    CircleIndicator mainHomeHeaderindicator;
    @BindView(R.id.home_fragment)
    LinearLayout homeFragment;
    private ArrayList<Fragment> fragments = new ArrayList<>();
    private MainFragmentAdapter fragmentAdapter;
    private Unbinder unbinder;
    private Toolbar homeToolbar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_home_fragment, container, false);
        homeToolbar = getActivity().findViewById(R.id.main_toolbar);
        homeToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jumpToAnotherActivity(PositionActivity.class, null);
            }
        });
        unbinder = ButterKnife.bind(this, view);

        /**
         * todo:这段代码只是造了三个假，以后要从服务器拖数据下来，把逻辑写在fragment中
         */
        /*Bundle bundle1 = new Bundle();
        bundle1.putInt("image", R.drawable.home_header_1);
        Bundle bundle2 = new Bundle();
        bundle2.putInt("image", R.drawable.home_header_2);
        Bundle bundle3 = new Bundle();
        bundle3.putInt("image", R.drawable.home_header_3);*/
        fragments.add(new HomeHeaderFragment());
        //fragments.get(0).setArguments(bundle1);
        fragments.add(new HomeHeaderFragment());
        //fragments.get(1).setArguments(bundle2);
        fragments.add(new HomeHeaderFragment());
        //fragments.get(2).setArguments(bundle3);
        fragmentAdapter = new MainFragmentAdapter(getFragmentManager(), fragments);
        mainHomeHeaderviewpager.setAdapter(fragmentAdapter);
        mainHomeHeaderviewpager.setOffscreenPageLimit(3);
        mainHomeHeaderindicator.setViewPager(mainHomeHeaderviewpager);


        ActivitiesOrSponsorFragment activitiesFragment = new ActivitiesOrSponsorFragment();
        ActivitiesOrSponsorFragment sponsorFragment = new ActivitiesOrSponsorFragment();
        Bundle bundleActivity = new Bundle();
        bundleActivity.putInt(FRAGEMTN_TYPE, ACTIVITIES);
        Bundle bundleSponsor = new Bundle();
        bundleSponsor.putInt(FRAGEMTN_TYPE, SPONSORS);

        activitiesFragment.setArguments(bundleActivity);
        sponsorFragment.setArguments(bundleSponsor);

        replaceFragment(activitiesFragment, 1);
        replaceFragment(sponsorFragment, 2);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private void replaceFragment(Fragment fragment, int position) {
        int id = position == 1 ? R.id.activity_fragment_replace : R.id.activity_fragment_replace2;
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(id, fragment);
        fragmentTransaction.commit();
    }

}
