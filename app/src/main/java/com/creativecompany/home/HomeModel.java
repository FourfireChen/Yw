package com.creativecompany.home;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;

import com.creativecompany.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 陈钊燚 on 2018/5/10.
 * QQ 1215638092
 * Github FourfireChen
 */
public class HomeModel extends ViewModel {
    private MutableLiveData<List<Integer>> postsRes = new MutableLiveData<>();
    public void loadHeaderPosts(){
        ArrayList<Integer> res = new ArrayList<>();
        res.add(R.drawable.home_header_1);
        res.add(R.drawable.home_header_2);
        res.add(R.drawable.home_header_3);
        postsRes.postValue(res);
    }
    public MutableLiveData<List<Integer>> getPostsRes() {
        return postsRes;
    }
}
