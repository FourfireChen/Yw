package com.creativecompany.data;

import android.content.Context;
import android.telecom.Call;
import android.telecom.CallAudioState;

import com.creativecompany.data.bean.MyActivity;
import com.creativecompany.data.bean.Sponsor;

import java.util.ArrayList;

/**
 * Created by 45089 on 2018/4/5.
 */

public interface IdataSource {
    ArrayList<String> matchCity(Context context, String editing);

    boolean login(Context context, String username, String password, Callback callback);

    boolean register(Context context, String phonenumber, String password, Callback callback);

    void sendVerMes(String phonenumber, Callback callback);

    void verifyMesCode(String phonenumber, String code, Callback callback);

    void getLocationInfo(Context context, Callback<String> callback);

    void getActivity(Context context, Callback<ArrayList<MyActivity>> callback);

    void getSponsor(Context context, Callback<ArrayList<Sponsor>> callback);

    void getHomeHeaderPost(Context context, Callback<ArrayList<Integer>> callback);

    interface Callback<T> {
        void onSuccess(T back);

        void onFail(Exception e);
    }
}
