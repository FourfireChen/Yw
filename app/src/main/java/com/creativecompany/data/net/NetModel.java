package com.creativecompany.data.net;

import android.content.Context;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.creativecompany.data.IdataSource;
import com.creativecompany.data.bean.User;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by 45089 on 2018/4/5.
 */

public class NetModel implements InetModel {
    private NetModel() {}

    @Override
    public void cancelTasks() {

    }

    @Override
    public void login(User user, final IdataSource.Callback<User> callback) {
        user.login(new SaveListener<User>() {
            @Override
            public void done(User user, BmobException e) {
                if (e == null) {
                    callback.onSuccess(user);
                } else {
                    callback.onFail(e);
                }
            }
        });
    }

    @Override
    public void register(User user, final IdataSource.Callback<User> callback) {
        user.signUp(new SaveListener<User>() {
            @Override
            public void done(User user, BmobException e) {
                if (e == null) {
                    callback.onSuccess(user);
                } else {
                    callback.onFail(e);
                }
            }
        });
    }

    @Override
    public void getCurrentPosition(Context applicationContext, final IdataSource.Callback<AMapLocation> callback) {
        final AMapLocationClient locationClient = new AMapLocationClient(applicationContext);
        AMapLocationListener locationListener = new AMapLocationListener() {
            @Override
            public void onLocationChanged(AMapLocation aMapLocation) {
                if (aMapLocation.getErrorCode() == 0) {
                    callback.onSuccess(aMapLocation);
                } else {
                    callback.onFail(new Exception(aMapLocation.getErrorInfo()));
                }
                locationClient.stopLocation();
                locationClient.onDestroy();
            }
        };
        locationClient.setLocationListener(locationListener);
        AMapLocationClientOption locationClientOption = new AMapLocationClientOption();
        locationClientOption.setOnceLocationLatest(true);
        locationClientOption.setNeedAddress(true);
        locationClient.setLocationOption(locationClientOption);
        locationClient.startLocation();
    }

    private static class DataHolder {
        private static InetModel inetModel = new NetModel();
    }

    public static InetModel getNetModel() {
        return DataHolder.inetModel;
    }
}
