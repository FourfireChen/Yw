package com.creativecompany.me;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.avos.avoscloud.AVUser;
import com.creativecompany.BaseFragment;
import com.creativecompany.R;
import com.creativecompany.data.bean.Participant;
import com.creativecompany.login.LoginActivity;
import com.creativecompany.me.MeContract.ImeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by 45089 on 2018/4/7.
 */

public class MeFragment extends BaseFragment implements ImeView {
    @BindView(R.id.me_header_background)
    ImageView meHeaderBackground;
    @BindView(R.id.me_myicon)
    CircleImageView meMyicon;
    @BindView(R.id.logout)
    Button logout;
    Unbinder unbinder;
    @BindView(R.id.me_username)
    TextView mMeUsername;
    @BindView(R.id.me_work_hours)
    TextView mMeWorkHours;
    @BindView(R.id.me_ranking)
    TextView mMeRanking;
    @BindView(R.id.my_follow)
    Button mMyFollow;
    @BindView(R.id.my_acticities)
    Button mMyActicities;
    @BindView(R.id.my_history)
    Button mMyHistory;
    private MeModel mMeModel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_me_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);

        mMeModel = ViewModelProviders.of(this).get(MeModel.class);

        mMeModel.getUserLiveData().observe(this, user -> mMeUsername.setText(user.getUsername()));

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (AVUser.getCurrentUser() == null) {
            jumpToAnotherActivity(LoginActivity.class, null);
        } else {

        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.logout)
    public void onViewClicked() {
        Participant currentParticipant = Participant.getCurrentUser(Participant.class);
        if (currentParticipant != null) {
            AVUser.logOut();
        }
        jumpToAnotherActivity(LoginActivity.class, null);
        selfFinish();
    }


    @Override
    public void toast(String content) {
        Toast.makeText(getActivity(), content, Toast.LENGTH_LONG).show();
    }

    @Override
    public void selfFinish() {
        getActivity().finish();
    }

    @OnClick({R.id.my_follow, R.id.my_acticities, R.id.my_history})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.my_follow:

                break;
            case R.id.my_acticities:

                break;
            case R.id.my_history:

                break;
        }
    }
}
