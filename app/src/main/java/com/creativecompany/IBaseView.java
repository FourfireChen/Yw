package com.creativecompany;

import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by 45089 on 2018/4/5.
 */

public interface IBaseView {
    void jumpToAnotherActivity(Class nextActivity, @Nullable Bundle data);

    void toast(String content);

    void selfFinish();
}
