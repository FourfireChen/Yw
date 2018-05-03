package com.creativecompany.data.net;

import android.content.Context;

import com.amap.api.location.AMapLocation;
import com.creativecompany.data.BaseModel;
import com.creativecompany.data.IdataSource;
import com.creativecompany.data.bean.User;

/**
 * Created by 45089 on 2018/4/5.
 */

public interface InetModel extends BaseModel {
    void login(User user, IdataSource.Callback<User> callback);

    void register(User user, IdataSource.Callback<User> callback);

    void getCurrentPosition(Context applicationContext, IdataSource.Callback<AMapLocation> callback);
}
