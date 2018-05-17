package com.creativecompany.mes;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.creativecompany.BaseFragment;
import com.creativecompany.R;
import com.creativecompany.data.bean.MyActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by 陈钊燚 on 2018/5/16.
 * QQ 1215638092
 * Github FourfireChen
 */
public class MessageFragment extends BaseFragment {
    @BindView(R.id.summary_avator)
    CircleImageView mSysMesAvator;
    @BindView(R.id.summary_title)
    TextView mSysMesTitle;
    @BindView(R.id.summary_summary)
    TextView mSysMesSummary;
    @BindView(R.id.group_messages)
    RecyclerView mGroupMessages;
    Unbinder unbinder;

    private MessagesAdapter mMessagesAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_message_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        init();
        return view;
    }


    public void init() {

        //todo:这里又是假数据，后面还得加进来

        ArrayList<MyActivity> activities = new ArrayList<>();
        activities.add(new MyActivity("东湖义工", "玩一天", "就今天", "玩玩玩", null, "111"));
        activities.add(new MyActivity("东湖义工", "玩一天", "就今天", "玩玩玩", null, "111"));
        activities.add(new MyActivity("东湖义工", "玩一天", "就今天", "玩玩玩", null, "111"));
        mMessagesAdapter = new MessagesAdapter(activities);

        mGroupMessages.setAdapter(mMessagesAdapter);
        mGroupMessages.setLayoutManager(new LinearLayoutManager(getContext()));
        mGroupMessages.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));

        mSysMesAvator.setImageDrawable(getActivity().getDrawable(R.drawable.ic_android_cyan_400_48dp));
        mSysMesTitle.setText("小益");
        mSysMesSummary.setText("啥消息都没有呵呵呵呵");

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
