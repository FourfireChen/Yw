package com.creativecompany.data.local;

import android.content.Context;
import android.content.SharedPreferences;

import com.creativecompany.data.bean.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

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
            BufferedReader reader = new BufferedReader(new InputStreamReader(context.getAssets().open("city.json")));
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuffer.append(line);
            }
            String result = stringBuffer.toString();
            JSONObject json = new JSONObject(result);
            JSONArray provinceArray = json.getJSONArray("provinces");
            //todo:数据解析没做好
            for (int i = 0; i < provinceArray.length(); i++) {
                JSONArray cityArray = provinceArray.getJSONObject(i).getJSONArray("citys");
                for (int j = 0; j < cityArray.length(); j++) {
                    citys.add(cityArray.getJSONObject(j).getString("citysName"));
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
        sharedPreferences = context.getSharedPreferences("user", Context.MODE_PRIVATE);
        if (sharedPreferences != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void saveUser(User user) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", user.getUsername());
        editor.putString("objectid", user.getObjectId());
        editor.putString("phonenumber", user.getMobilePhoneNumber());
        editor.putString("email", user.getEmail());
        editor.putString("position", user.getPositon());
        editor.putString("gender", user.getGender());
        editor.putInt("age", user.getAge());
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
        if (key.equals("age")) result = String.valueOf(sharedPreferences.getInt(key, 0));
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
