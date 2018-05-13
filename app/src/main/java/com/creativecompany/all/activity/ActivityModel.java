package com.creativecompany.all.activity;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.creativecompany.data.bean.MyActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 陈钊燚 on 2018/5/11.
 * QQ 1215638092
 * Github FourfireChen
 */
public class ActivityModel extends ViewModel {
    private MutableLiveData<List<MyActivity>> mActivities = new MutableLiveData<>();

    public LiveData<List<MyActivity>> getActivities() {
        return mActivities;
    }

    public void loadActivity() {
        //todo:这里做了假数据，后面要从数据仓库拉下来
        ArrayList<MyActivity> mActivitiesList = new ArrayList<>();
        mActivitiesList.add(new MyActivity());
        mActivitiesList.add(new MyActivity());
        mActivitiesList.add(new MyActivity());
        mActivities.postValue(mActivitiesList);
    }
}
