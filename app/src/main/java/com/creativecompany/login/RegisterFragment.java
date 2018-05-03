package com.creativecompany.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.creativecompany.BaseFragment;
import com.creativecompany.R;
import com.creativecompany.login.LoginContract.IregisterPresenter;
import com.creativecompany.login.LoginContract.IregisterView;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by 45089 on 2018/4/5.
 */

public class RegisterFragment extends BaseFragment<IregisterPresenter> implements IregisterView {
    private Unbinder unbinder;
    private IregisterPresenter registerPresenter;
    @BindView(R.id.phonenumber)
    EditText phonenumber;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.confirm_password)
    EditText confirmPassword;
    @BindView(R.id.verfication)
    EditText verfication;
    @BindView(R.id.get_verfication)
    Button getVerfication;
    @BindView(R.id.register_confirm)
    Button registerConfirm;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_register_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        setPresenter(new RegisterPresenter(this));
        registerPresenter = getPresenter();
        return view;
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }


    private HashMap<String, String> getRegisterInfo() {
        HashMap<String, String> registerInfo = new HashMap<>();
        String pn = phonenumber.getText().toString();
        String pw = password.getText().toString();
        String conPw = confirmPassword.getText().toString();
        String ver = verfication.getText().toString();
        registerInfo.put("phonenumber", pn);
        registerInfo.put("password", pw);
        registerInfo.put("confirmPassword", conPw);
        registerInfo.put("verifycode", ver);
        return registerInfo;
    }


    @OnClick({R.id.get_verfication, R.id.register_confirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.get_verfication:
                registerPresenter.getVerCodeMes(getRegisterInfo());
                break;
            case R.id.register_confirm:
                registerPresenter.register(getRegisterInfo());
                break;
        }
    }
}
