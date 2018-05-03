package com.creativecompany.login;

import android.util.Log;

import com.creativecompany.BasePresenter;
import com.creativecompany.data.IdataSource;
import com.creativecompany.login.LoginContract.IregisterPresenter;
import com.creativecompany.login.LoginContract.IregisterView;

import java.util.HashMap;

/**
 * Created by 45089 on 2018/4/14.
 */

public class RegisterPresenter extends BasePresenter<IregisterView> implements IregisterPresenter {
    private IregisterView iregisterView;
    private IdataSource dataRepository;

    public RegisterPresenter(IregisterView iregisterView) {
        setView(iregisterView);
        this.iregisterView = getIView();
        dataRepository = getIdataSource();
    }

    @Override
    public void getVerCodeMes(HashMap<String, String> registerInfo) {
        String phonenumber = registerInfo.get("phonenumber");
        if (phonenumber != null && !phonenumber.equals("")) {
            dataRepository.sendVerMes(phonenumber, new IdataSource.Callback<String>() {
                @Override
                public void onSuccess(String back) {
                    iregisterView.toast("发送成功");
                }

                @Override
                public void onFail(Exception e) {
                    iregisterView.toast(e.getMessage());
                }
            });
        } else {
            iregisterView.toast("手机号码不能为空");
        }
    }

    @Override
    public void register(final HashMap<String, String> registerInfo) {
        final String phonenumber = registerInfo.get("phonenumber");
        String verifycode = registerInfo.get("verifycode");
        final String password = registerInfo.get("password");
        String confirmPassword = registerInfo.get("confirmPassword");
        if (phonenumber.isEmpty() || verifycode.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            iregisterView.toast("请补全信息");
            return;
        }
        if (!password.equals(confirmPassword)) {
            iregisterView.toast("两次密码输入不一致，请重新输入");
            return;
        }
        dataRepository.verifyMesCode(phonenumber, verifycode, new IdataSource.Callback<String>() {
            @Override
            public void onSuccess(String back) {
                dataRepository.register(((RegisterFragment) iregisterView).getContext(), phonenumber, password, new IdataSource.Callback<String>() {
                    @Override
                    public void onSuccess(String back) {
                        Log.i("Fourfire的Log", "注册成功了");
                        iregisterView.toast("注册成功");
                    }

                    @Override
                    public void onFail(Exception e) {
                        Log.e("Fourfire的Log", "注册失败了" + e.getMessage());
                        iregisterView.toast("注册失败" + e.getMessage());
                    }
                });
            }

            @Override
            public void onFail(Exception e) {
                iregisterView.toast(e.getMessage());
            }
        });
    }
}
