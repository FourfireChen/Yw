package com.creativecompany.home;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import com.creativecompany.R;
import com.creativecompany.data.DataRepository;
import com.creativecompany.data.IdataSource;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 陈钊燚 on 2018/5/10.
 * QQ 1215638092
 * Github FourfireChen
 */
public class HomeModel extends ViewModel {
    private MutableLiveData<List<Integer>> postsRes = new MutableLiveData<>();
    private IdataSource mDataRes = new DataRepository();

    public void loadHeaderPosts(Context context) {
        ArrayList<Integer> res = new ArrayList<>();
        mDataRes.getHomeHeaderPost(context, new IdataSource.Callback<ArrayList<Integer>>() {
            @Override
            public void onSuccess(ArrayList<Integer> back) {
                res.addAll(back);
                postsRes.postValue(res);
            }

            @Override
            public void onFail(Exception e) {
                //做了三个假图, 这个后面要处理的
                //todo:处理异常
                res.add(R.drawable.home_header_1);
                res.add(R.drawable.home_header_2);
                res.add(R.drawable.home_header_3);
                postsRes.postValue(res);
            }
        });
    }

    public MutableLiveData<List<Integer>> getPostsRes() {
        return postsRes;
    }
}
