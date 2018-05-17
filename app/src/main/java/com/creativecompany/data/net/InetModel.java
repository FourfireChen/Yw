package com.creativecompany.data.net;

import android.content.Context;

import com.amap.api.location.AMapLocation;
import com.avos.avoscloud.AVException;
import com.creativecompany.data.BaseModel;
import com.creativecompany.data.IdataSource;
import com.creativecompany.data.bean.Participant;

/**
 * Created by 45089 on 2018/4/5.
 */

public interface InetModel extends BaseModel {

    void login(String username, String password, IdataSource.Callback<Participant> callback) throws AVException;

    void register(Participant participant, IdataSource.Callback<Participant> callback);

    void getCurrentPosition(Context applicationContext, IdataSource.Callback<AMapLocation> callback);
}
