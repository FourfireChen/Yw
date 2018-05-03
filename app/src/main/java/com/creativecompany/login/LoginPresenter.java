package com.creativecompany.login;

import android.content.Context;

import com.creativecompany.BasePresenter;
import com.creativecompany.data.IdataSource;
import com.creativecompany.login.LoginContract.IloginPresenter;
import com.creativecompany.login.LoginContract.IloginView;

/**
 * Created by 45089 on 2018/4/5.
 */

public class LoginPresenter extends BasePresenter<IloginView> implements IloginPresenter {
    private IloginView loginView;
    private IdataSource idataSource;

    public LoginPresenter(IloginView loginView) {
        setView(loginView);
        this.loginView = getIView();
        idataSource = getIdataSource();
    }

    @Override
    public void login(Context context, String username, String password) {
        if (username.isEmpty() || password.isEmpty()) {
            loginView.toast("请填写用户名和密码");
            return;
        }
        idataSource.login(context, username, password, new IdataSource.Callback() {
            @Override
            public void onSuccess(Object back) {
                loginView.selfFinish();
            }

            @Override
            public void onFail(Exception e) {
                loginView.toast("登录失败" + e.getMessage());
            }
        });
    }
}
