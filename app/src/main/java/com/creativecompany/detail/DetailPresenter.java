package com.creativecompany.detail;

import com.creativecompany.BasePresenter;
import com.creativecompany.data.IdataSource;
import com.creativecompany.detail.DetailContract.DeatilPresenter;
import com.creativecompany.detail.DetailContract.DetailView;

/**
 * Created by 45089 on 2018/4/15.
 */

public class DetailPresenter extends BasePresenter implements DeatilPresenter {
    private DetailView detailView;
    private IdataSource dataRepository;

    public DetailPresenter(DetailView detailView) {
        this.detailView = detailView;
    }
}
