package com.creativecompany.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.creativecompany.BaseActivity;
import com.creativecompany.R;
import com.creativecompany.login.LoginContract.IloginView;
import com.creativecompany.main.MainFragmentAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 45089 on 2018/4/5.
 */

public class LoginActivity extends BaseActivity implements IloginView {
    @BindView(R.id.login_tablayout)
    TabLayout loginTablayout;
    @BindView(R.id.login_frg_place)
    ViewPager loginFrgPlace;
    private MainFragmentAdapter fragmentAdapter;
    private ArrayList<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        fragments.add(new LoginFragment());
        fragments.add(new RegisterFragment());
        fragmentAdapter = new MainFragmentAdapter(getSupportFragmentManager(), fragments);
        loginFrgPlace.setAdapter(fragmentAdapter);
        loginTablayout.setupWithViewPager(loginFrgPlace);
        //傻傻的api：setupwithviewpager会把tab移除，所以设置tab要再这句后面
        loginTablayout.getTabAt(0).setText("登录");
        loginTablayout.getTabAt(1).setText("注册");
    }

}
