package com.creativecompany;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.widget.Toast;

/**
 * Created by 45089 on 2018/4/15.
 */

public class BaseFragment<T extends IBasePresenter> extends Fragment implements IBaseView {
    private T presenter;

    public T getPresenter() {
        return presenter;
    }

    public void setPresenter(T presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mApplication.getRefWatcher(getActivity()).watch(this);
        if (presenter != null) presenter.destroy();
        presenter = null;
    }

    @Override
    public void jumpToAnotherActivity(Class nextActivity, @Nullable Bundle bundle) {
        Intent intent = new Intent(getActivity(), nextActivity);
        if(bundle != null)
            intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void toast(String content) {
        Toast.makeText(getActivity(), content, Toast.LENGTH_LONG).show();
    }

    @Override
    public void selfFinish() {
        getActivity().finish();
    }
}
