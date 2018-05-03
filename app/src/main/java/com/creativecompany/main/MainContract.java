package com.creativecompany.main;

import com.creativecompany.IBasePresenter;
import com.creativecompany.IBaseView;

/**
 * Created by 45089 on 2018/4/5.
 */

public interface MainContract {
    interface ImainPresenter extends IBasePresenter {
        void initUser();
    }

    interface ImainView extends IBaseView {}
}
