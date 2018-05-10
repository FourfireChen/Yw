package com.creativecompany.util;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.support.v4.app.Fragment;

import com.creativecompany.mApplication;


/**
 * Created by 陈钊燚 on 2018/5/10.
 * QQ 1215638092
 * Github FourfireChen
 */
public class FragmentCyclerListener implements LifecycleObserver {
    private Fragment mFragment;
    private Lifecycle mLifecycle;

    public FragmentCyclerListener(Fragment fragment, Lifecycle lifecycle) {
        mFragment = fragment;
        mLifecycle = lifecycle;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void watchLeak(){
        mApplication.getRefWatcher(mFragment.getActivity()).watch(mFragment);
    }
}

