package com.creativecompany.data.net;

import android.content.Context;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.LogInCallback;
import com.avos.avoscloud.SignUpCallback;
import com.creativecompany.data.IdataSource;
import com.creativecompany.data.bean.Participant;

/**
 * Created by 45089 on 2018/4/5.
 */

public class NetModel implements InetModel {
    private NetModel() {}

    @Override
    public void cancelTasks() {

    }

    @Override
    public void login(String username, String password, final IdataSource.Callback<Participant> callback) throws AVException {
        AVUser.logInInBackground(username, password, new LogInCallback<Participant>() {
            @Override
            public void done(Participant avParticipant, AVException e) {
                if (e == null) {
                    callback.onSuccess(avParticipant);
                } else {
                    callback.onFail(e);
                }
            }
        }, Participant.class);
    }

    @Override
    public void register(Participant participant, final IdataSource.Callback<Participant> callback) {
        participant.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(AVException e) {
                if (e == null) {
                    callback.onSuccess(participant);
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
