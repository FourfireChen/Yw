package com.creativecompany.data;

import android.content.Context;
import com.amap.api.location.AMapLocation;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVMobilePhoneVerifyCallback;
import com.avos.avoscloud.AVSMS;
import com.avos.avoscloud.AVSMSOption;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.RequestMobileCodeCallback;
import com.creativecompany.data.bean.User;
import com.creativecompany.data.local.IlocalModel;
import com.creativecompany.data.local.LocalModel;
import com.creativecompany.data.net.InetModel;
import com.creativecompany.data.net.NetModel;
import java.util.ArrayList;

/**
 * Created by 45089 on 2018/4/5.
 */

public class DataRepository implements IdataSource {
    private IlocalModel localData;
    private InetModel netData;

    public DataRepository() {
        localData = LocalModel.getLocalModel();
        netData = NetModel.getNetModel();
    }

    @Override
    public ArrayList<String> matchCity(Context context, String editing) {
        ArrayList<String> citys = localData.getAllCitys(context);
        ArrayList<String> results = new ArrayList<>();
        for (int i = 0; i < citys.size(); i++) {
            if (citys.get(i).contains(editing)) {
                results.add(citys.get(i));
            }
        }
        return results;
    }

    @Override
    public boolean login(final Context context, String username, String password, final Callback callback) {
        try {
            netData.login(username, password, new Callback<User>() {
                @Override
                public void onSuccess(User back) {
                    localData.openDatabase(context);
                    localData.saveUser(back);
                    callback.onSuccess(null);
                }

                @Override
                public void onFail(Exception e) {
                    callback.onFail(e);
                }
            });
        } catch (AVException e) {
            callback.onFail(e);
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean register(final Context context, String phonenumber, String password, final Callback callback) {
        final User user = new User();
        user.setUsername(phonenumber);
        user.setMobilePhoneNumber(phonenumber);
        user.setPassword(password);
        netData.register(user, new Callback<User>() {
            @Override
            public void onSuccess(User back) {
                localData.openDatabase(context);
                localData.saveUser(back);
                callback.onSuccess(null);
            }

            @Override
            public void onFail(Exception e) {
                callback.onFail(e);
            }
        });
        return false;
    }

    @Override
    public void sendVerMes(final String phonenumber, final Callback callback) {
        AVSMSOption option = new AVSMSOption();
        option.setTtl(10);
        option.setApplicationName("益务");
        AVSMS.requestSMSCodeInBackground(phonenumber, option, new RequestMobileCodeCallback() {
            @Override
            public void done(AVException e) {
                if (e == null) {
                    callback.onSuccess(null);
                } else {
                    callback.onFail(e);
                }
            }
        });
    }

    @Override
    public void verifyMesCode(String phonenumber, String code, final Callback callback) {
        AVSMS.verifySMSCodeInBackground(code, phonenumber, new AVMobilePhoneVerifyCallback() {
            @Override
            public void done(AVException e) {
                if (e == null) {
                    callback.onSuccess(null);
                } else {
                    callback.onFail(e);
                }
            }
        });
    }

    @Override
    public void getLocationInfo(final Context context, final Callback<String> callback) {
        netData.getCurrentPosition(context, new Callback<AMapLocation>() {
            @Override
            public void onSuccess(AMapLocation back) {
                PoiSearch.Query query = new PoiSearch.Query("", "高等院校", back.getCityCode());
                PoiSearch poiSearch = new PoiSearch(context, query);
                poiSearch.setBound(new PoiSearch.SearchBound(new LatLonPoint(back.getLatitude(), back.getLongitude()), 2000));
                poiSearch.setOnPoiSearchListener(new PoiSearch.OnPoiSearchListener() {
                    @Override
                    public void onPoiSearched(PoiResult poiResult, int i) {
                        if (i == 1000) {
                            int j = 0, index = 0;
                            PoiItem poiItem;
                            String title;
                            do {
                                poiItem = poiResult.getPois().get(j++);
                                title = poiItem.getTitle();
                            } while ((index = title.indexOf("大学")) == 0);
                            String result = title.substring(0, index + 2);
                            if (result.contains("大学")) callback.onSuccess(result);
                            callback.onFail(new Exception(poiResult.getSearchSuggestionCitys().get(0).getCityName()));
                        } else {
                            callback.onFail(new Exception(poiResult.getSearchSuggestionCitys().get(0).getCityName()));
                        }
                    }

                    @Override
                    public void onPoiItemSearched(PoiItem poiItem, int i) {
                    }
                });
                poiSearch.searchPOIAsyn();
            }

            @Override
            public void onFail(Exception e) {
                callback.onFail(e);
            }
        });
    }


}
