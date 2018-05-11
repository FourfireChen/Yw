package com.creativecompany.util;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.util.Log;

import com.creativecompany.mApplication;
import com.squareup.leakcanary.RefWatcher;


/**
 * Created by 陈钊燚 on 2018/5/10.
 * QQ 1215638092
 * Github FourfireChen
 */
public class ActivityCyclerListener implements LifecycleObserver {


    private Activity mActivity;

    public ActivityCyclerListener(Activity activity, Lifecycle lifecycle) {
        mActivity = activity;
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void start() {
        Log.i("lifecycler observer", "start");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void addLeakWatcher() {
        RefWatcher refWatcher = mApplication.getRefWatcher(mActivity);
        refWatcher.watch(mActivity);
    }

}
