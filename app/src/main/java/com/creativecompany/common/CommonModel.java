package com.creativecompany.common;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.util.Log;

import com.creativecompany.data.DataRepository;
import com.creativecompany.data.IdataSource;
import com.creativecompany.data.bean.MyActivity;
import com.creativecompany.data.bean.Sponsor;

import java.util.ArrayList;

/**
 * Created by 陈钊燚 on 2018/5/11.
 * QQ 1215638092
 * Github FourfireChen
 */

public class CommonModel extends ViewModel {
    private MutableLiveData<ArrayList<MyActivity>> mActivityList = new MutableLiveData<>();
    private MutableLiveData<ArrayList<Sponsor>> mSponsorList = new MutableLiveData<>();


    private IdataSource mIdataSource = new DataRepository();


    public MutableLiveData<ArrayList<MyActivity>> getActivityList() {
        return mActivityList;
    }

    public MutableLiveData<ArrayList<Sponsor>> getSponsorList() {
        return mSponsorList;
    }

    public void loadActivities(Context context) {
        mIdataSource.getActivity(context, new IdataSource.Callback<ArrayList<MyActivity>>() {
            @Override
            public void onSuccess(ArrayList<MyActivity> back) {
                mActivityList.setValue(back);
            }

            @Override
            public void onFail(Exception e) {
                Log.e("common板块没有拿到activity", "onFail: " + e.getMessage());
            }
        });
    }

    public void loadSponsors(Context context){
        mIdataSource.getSponsor(context, new IdataSource.Callback<ArrayList<Sponsor>>() {
            @Override
            public void onSuccess(ArrayList<Sponsor> back) {
                mSponsorList.setValue(back);
            }

            @Override
            public void onFail(Exception e) {

            }
        });
    }

}
