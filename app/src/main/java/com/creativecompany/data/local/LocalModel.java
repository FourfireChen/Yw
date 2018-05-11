package com.creativecompany.data.local;

import android.content.Context;
import android.content.SharedPreferences;

import com.avos.avoscloud.AVUser;
import com.creativecompany.data.bean.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static com.creativecompany.util.ID.AGE;
import static com.creativecompany.util.ID.CITYNAME;
import static com.creativecompany.util.ID.CITYS;
import static com.creativecompany.util.ID.CITY_ASSETS;
import static com.creativecompany.util.ID.EMAIL;
import static com.creativecompany.util.ID.GENDER;
import static com.creativecompany.util.ID.OBJECTID;
import static com.creativecompany.util.ID.PHONENUMBER;
import static com.creativecompany.util.ID.POSITION;
import static com.creativecompany.util.ID.PROVINCES;
import static com.creativecompany.util.ID.USER;
import static com.creativecompany.util.ID.USERNAME;

/**
 * Created by 45089 on 2018/4/5.
 */

public class LocalModel implements IlocalModel {
    private SharedPreferences sharedPreferences;

    private LocalModel() {}

    @Override
    public void cancelTasks() {}

    @Override
    public ArrayList<String> getAllCitys(final Context context) {
        final ArrayList<String> citys = new ArrayList<>();
        StringBuffer stringBuffer = new StringBuffer();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(context.getAssets().open(CITY_ASSETS)));
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuffer.append(line);
            }
            String result = stringBuffer.toString();
            JSONObject json = new JSONObject(result);
            JSONArray provinceArray = json.getJSONArray(PROVINCES);
            //todo:数据解析没做好
            for (int i = 0; i < provinceArray.length(); i++) {
                JSONArray cityArray = provinceArray.getJSONObject(i).getJSONArray(CITYS);
                for (int j = 0; j < cityArray.length(); j++) {
                    citys.add(cityArray.getJSONObject(j).getString(CITYNAME));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return citys;
    }

    @Override
    public boolean openDatabase(Context context) {
        sharedPreferences = context.getSharedPreferences(USER, Context.MODE_PRIVATE);
        if (sharedPreferences != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void saveUser(User user) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(USERNAME, user.getUsername());
        editor.putString(OBJECTID, user.getObjectId());
        editor.putString(PHONENUMBER, user.getMobilePhoneNumber());
        editor.putString(EMAIL, user.getEmail());
        editor.putString(POSITION, user.getPosition());
        editor.putString(GENDER, user.getGender());
        editor.putInt(AGE, user.getAge());
        editor.apply();
    }

    @Override
    public void clearData() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

    @Override
    public String queryData(String key) {
        String result;
        if (key.equals(AGE)) result = String.valueOf(sharedPreferences.getInt(key, 0));
        else result = sharedPreferences.getString(key, "");
        return result;
    }

    private static class DataHolder {
        private static LocalModel localModel = new LocalModel();
    }

    public static IlocalModel getLocalModel() {
        return DataHolder.localModel;
    }
}
