package com.creativecompany.home;

import com.creativecompany.BasePresenter;
import com.creativecompany.data.IdataSource;
import com.creativecompany.home.HomeContract.IhomePresenter;
import com.creativecompany.home.HomeContract.IhomeView;

/**
 * Created by 45089 on 2018/4/12.
 */

public class HomePresenter extends BasePresenter<IhomeView> implements IhomePresenter {
    private IdataSource idataSource;
    private IhomeView ihomeView;

    public HomePresenter(IhomeView view) {
        idataSource = getIdataSource();
        setView(view);
        this.ihomeView = getIView();
    }

}
