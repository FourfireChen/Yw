package com.creativecompany.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.creativecompany.BaseFragment;
import com.creativecompany.R;
import com.creativecompany.login.LoginContract.IloginPresenter;
import com.creativecompany.login.LoginContract.IloginView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import info.hoang8f.widget.FButton;

/**
 * Created by 45089 on 2018/4/5.
 */

public class LoginFragment extends BaseFragment<IloginPresenter> implements IloginView {
    @BindView(R.id.login_username)
    EditText loginUsername;
    @BindView(R.id.login_password)
    EditText loginPassword;
    Unbinder unbinder;
    @BindView(R.id.login_button)
    FButton loginButton;
    private IloginPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_main_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        setPresenter(new LoginPresenter(this));
        presenter = getPresenter();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @OnClick(R.id.login_button)
    public void onViewClicked() {
        String username = loginUsername.getText().toString();
        String password = loginPassword.getText().toString();
        presenter.login(getActivity().getApplicationContext(), username, password);
    }
}
