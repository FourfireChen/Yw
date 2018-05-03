package com.creativecompany;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.squareup.leakcanary.RefWatcher;

/**
 * Created by 45089 on 2018/4/15.
 */

public class BaseActivity<T extends IBasePresenter> extends AppCompatActivity implements IBaseView {
    private T presenter;

    public T getPresenter() {
        return presenter;
    }

    public void setPresenter(T presenter) {
        this.presenter = presenter;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) presenter.destroy();
        presenter = null;
        RefWatcher refWatcher = mApplication.getRefWatcher(this);
        refWatcher.watch(this);
    }

    @Override
    public void jumpToAnotherActivity(Class nextActivity) {
        Intent intent = new Intent(this, nextActivity);
        startActivity(intent);
    }

    @Override
    public void toast(String content) {
        Toast.makeText(this, content, Toast.LENGTH_LONG).show();
    }

    @Override
    public void selfFinish() {
        finish();
    }
}
