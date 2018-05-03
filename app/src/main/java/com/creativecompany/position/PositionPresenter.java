package com.creativecompany.position;

import android.content.Context;
import android.util.Log;

import com.creativecompany.BasePresenter;
import com.creativecompany.data.IdataSource;
import com.creativecompany.position.PositionContract.IpositionPresenter;
import com.creativecompany.position.PositionContract.IpositionView;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 45089 on 2018/4/14.
 */

public class PositionPresenter extends BasePresenter<IpositionView> implements IpositionPresenter {
    private IpositionView positionView;
    private IdataSource idataSource;

    public PositionPresenter(IpositionView ipositionView) {
        setView(ipositionView);
        this.positionView = getIView();
        idataSource = getIdataSource();
    }

    @Override
    public void queryCity(final String editing) {
        Observable.create(new ObservableOnSubscribe<ArrayList<String>>() {
            @Override
            public void subscribe(ObservableEmitter<ArrayList<String>> emitter) throws Exception {
                ArrayList<String> results = idataSource.matchCity((Context) positionView, editing);
                emitter.onNext(results);
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<ArrayList<String>>() {
            @Override
            public void accept(ArrayList<String> strings) throws Exception {
                positionView.setSuggestionCity(strings);
            }
        });
    }

    @Override
    public void location(Context context) {
        idataSource.getLocationInfo(context, new IdataSource.Callback<String>() {
            @Override
            public void onSuccess(String back) {
                Log.i("我的位置", back);
                positionView.setLocationResult(back);
            }

            @Override
            public void onFail(Exception e) {
                positionView.toast("定位失败" + e.getMessage());
                positionView.setLocationResult("定位失败");
            }
        });
    }
}
