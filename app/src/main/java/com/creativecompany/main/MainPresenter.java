package com.creativecompany.main;

import com.creativecompany.BasePresenter;
import com.creativecompany.data.IdataSource;
import com.creativecompany.data.bean.Participant;
import com.creativecompany.login.LoginActivity;
import com.creativecompany.main.MainContract.ImainPresenter;
import com.creativecompany.main.MainContract.ImainView;

/**
 * Created by 45089 on 2018/4/5.
 */

public class MainPresenter extends BasePresenter<ImainView> implements ImainPresenter {
    private ImainView imainView;
    private IdataSource dataRepository;

    public MainPresenter(ImainView imainView) {
        dataRepository = getIdataSource();
        setView(imainView);
        imainView = getIView();
    }

    @Override
    public void initUser() {
        Participant participant = Participant.getCurrentUser(Participant.class);
        if (participant == null) {
            imainView.jumpToAnotherActivity(LoginActivity.class, null);
        }
    }
}
