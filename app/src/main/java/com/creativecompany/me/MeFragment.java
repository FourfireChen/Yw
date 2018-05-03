package com.creativecompany.me;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.creativecompany.BaseFragment;
import com.creativecompany.R;
import com.creativecompany.data.bean.User;
import com.creativecompany.login.LoginActivity;
import com.creativecompany.me.MeContract.ImeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import cn.bmob.v3.BmobUser;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by 45089 on 2018/4/7.
 */

public class MeFragment extends BaseFragment implements ImeView {
    @BindView(R.id.me_header_background)
    ImageView meHeaderBackground;
    @BindView(R.id.me_myicon)
    CircleImageView meMyicon;
    @BindView(R.id.logout)
    Button logout;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_me_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.logout)
    public void onViewClicked() {
        User currentUser = User.getCurrentUser(User.class);
        if (currentUser != null) {
            BmobUser.logOut();
        }
        jumpToAnotherActivity(LoginActivity.class);
        selfFinish();
    }

    @Override
    public void jumpToAnotherActivity(Class nextActivity) {
        Intent intent = new Intent(getActivity(), nextActivity);
        startActivity(intent);
    }

    @Override
    public void toast(String content) {
        Toast.makeText(getActivity(), content, Toast.LENGTH_LONG).show();
    }

    @Override
    public void selfFinish() {
        getActivity().finish();
    }
}
