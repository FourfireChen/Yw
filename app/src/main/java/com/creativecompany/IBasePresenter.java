package com.creativecompany;

/**
 * Created by 45089 on 2018/4/5.
 */

public interface IBasePresenter {
    void destroy();

    void setView(IBaseView view);
}
