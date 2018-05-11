package com.creativecompany.home;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.creativecompany.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.creativecompany.util.ID.FRAGEMTN_TYPE;

/**
 * Created by 45089 on 2018/4/15.
 */

public class HomeHeaderFragment extends Fragment {
    @BindView(R.id.main_home_header_image)
    ImageView mainHomeHeaderImage;
    Unbinder unbinder;



    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_home_header_page, container, false);
        unbinder = ButterKnife.bind(this, view);
        int fragmentid = getArguments().getInt(FRAGEMTN_TYPE);

        /**
         * todo：
         * 1、LiveData的observe
         * 2、调用model.loadHeaderPosts()方法
         * 3、该方法从本地拉取缓存并更新livedata，然后再去服务器拉数据，如果是新的，就更新Livedata
         */

        HomeModel homeModel = new HomeModel();

        homeModel.getPostsRes().observe(this, res -> {
            mainHomeHeaderImage.setImageResource(res.get(fragmentid));
        });

        homeModel.loadHeaderPosts();

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
