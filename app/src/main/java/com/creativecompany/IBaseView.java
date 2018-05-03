package com.creativecompany;

/**
 * Created by 45089 on 2018/4/5.
 */

public interface IBaseView {
    public void jumpToAnotherActivity(Class nextActivity);

    void toast(String content);

    void selfFinish();
}
