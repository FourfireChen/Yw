package com.creativecompany.data.local;

import android.content.Context;

import com.creativecompany.data.BaseModel;
import com.creativecompany.data.bean.Participant;

import java.util.ArrayList;

/**
 * Created by 45089 on 2018/4/5.
 */

public interface IlocalModel extends BaseModel {
    ArrayList<String> getAllCitys(Context context);

    boolean openDatabase(Context context);

    void saveUser(Participant participant);

    void clearData();

    String queryData(String key);
}
