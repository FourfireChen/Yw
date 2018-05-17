package com.creativecompany.me;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.creativecompany.data.bean.Participant;

/**
 * Created by 陈钊燚 on 2018/5/11.
 * QQ 1215638092
 * Github FourfireChen
 */
public class MeModel extends ViewModel {
    private MutableLiveData<Participant> mUserLiveData = new MutableLiveData<>();

    public MutableLiveData<Participant> setUser(Participant participant) {
        mUserLiveData.setValue(participant);
        return mUserLiveData;
    }

    public MutableLiveData<Participant> getUserLiveData() {
        return mUserLiveData;
    }
}
