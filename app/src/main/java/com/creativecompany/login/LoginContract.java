package com.creativecompany.login;

import android.content.Context;

import com.creativecompany.IBasePresenter;
import com.creativecompany.IBaseView;

import java.util.HashMap;

/**
 * Created by 45089 on 2018/4/5.
 */

public interface LoginContract {
    interface IloginPresenter extends IBasePresenter {
        void login(Context context, String username, String password);
    }

    interface IloginView extends IBaseView {

    }

    interface IregisterView extends IBaseView {

    }

    interface IregisterPresenter extends IBasePresenter {
        void getVerCodeMes(HashMap<String, String> registerInfo);

        void register(HashMap<String, String> registerInfo);
    }
}
