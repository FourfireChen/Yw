package com.creativecompany;

import com.creativecompany.data.DataRepository;
import com.creativecompany.data.IdataSource;

import java.lang.ref.SoftReference;

/**
 * Created by 45089 on 2018/4/15.
 */

public class BasePresenter<T extends IBaseView> implements IBasePresenter {
    private SoftReference<T> view;
    private IdataSource idataSource = DataRepository.getDataRes();

    @Override
    public void destroy() {
        view = null;
        idataSource = null;
    }

    @Override
    public void setView(IBaseView view) {
        this.view = new SoftReference<T>((T) view);
    }

    protected T getIView() {
        return view.get();
    }

    public IdataSource getIdataSource() {
        return idataSource;
    }
}
