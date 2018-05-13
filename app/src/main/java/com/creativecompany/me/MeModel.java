package com.creativecompany.me;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.creativecompany.data.bean.User;

/**
 * Created by 陈钊燚 on 2018/5/11.
 * QQ 1215638092
 * Github FourfireChen
 */
public class MeModel extends ViewModel {
    private MutableLiveData<User> mUserLiveData = new MutableLiveData<>();

    public MutableLiveData<User> setUser(User user) {
        mUserLiveData.setValue(user);
        return mUserLiveData;
    }

    public MutableLiveData<User> getUserLiveData() {
        return mUserLiveData;
    }
}
