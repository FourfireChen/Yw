package com.creativecompany.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.creativecompany.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by 45089 on 2018/4/15.
 */

public class HomeHeaderFragment extends Fragment {
    @BindView(R.id.main_home_header_image)
    ImageView mainHomeHeaderImage;
    Unbinder unbinder;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_home_header_page, container, false);
        unbinder = ButterKnife.bind(this, view);
        int resId = getArguments().getInt("image", -1);
        if (resId != -1) mainHomeHeaderImage.setImageResource(resId);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.main_home_header_image)
    public void onViewClicked() {
    }
}
