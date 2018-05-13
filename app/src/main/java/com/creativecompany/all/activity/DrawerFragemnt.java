package com.creativecompany.all.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.creativecompany.R;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.creativecompany.util.ID.STATUS;
import static com.creativecompany.util.ID.TIME;
import static com.creativecompany.util.ID.WORK_TIME;

/**
 * Created by 陈钊燚 on 2018/5/6.
 * QQ 1215638092
 * Github FourfireChen
 */

public class DrawerFragemnt extends Fragment {
    @BindView(R.id.close_drawer)
    Button mCloseDrawer;
    @BindView(R.id.drawer_time_selector)
    RecyclerView mDrawerTimeSelector;
    @BindView(R.id.drawer_work_time_selector)
    RecyclerView mDrawerWorkTimeSelector;
    @BindView(R.id.drawer_status_selector)
    RecyclerView mDrawerStatusSelector;
    @BindView(R.id.drawer_cancel)
    Button mDrawerCancel;
    @BindView(R.id.drawer_confirm)
    Button mDrawerConfirm;
    Unbinder unbinder;
    private DrawerCallback mDrawerCallback;
    private onCheckBoxListListener mOnCheckBoxListListener;
    private SelectorListAdapter mTimeSelectorsAdapter = new SelectorListAdapter(TIME), mWorkTimeSelectorsAdapter = new SelectorListAdapter(WORK_TIME), mStatusSelectorsAdapter = new SelectorListAdapter(STATUS);


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.all_act_drawer, container, false);
        unbinder = ButterKnife.bind(this, view);
        init();
        return view;
    }

    private void init() {
        mDrawerTimeSelector.setAdapter(mTimeSelectorsAdapter);
        mDrawerTimeSelector.setLayoutManager(new GridLayoutManager(getContext(), 4));
        mDrawerWorkTimeSelector.setAdapter(mWorkTimeSelectorsAdapter);
        mDrawerWorkTimeSelector.setLayoutManager(new GridLayoutManager(getContext(), 4));
        mDrawerStatusSelector.setAdapter(mStatusSelectorsAdapter);
        mDrawerStatusSelector.setLayoutManager(new GridLayoutManager(getContext(), 4));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mDrawerCallback = null;
        unbinder.unbind();
    }

    public void setOnCheckBoxListListener(onCheckBoxListListener onCheckBoxListListener) {
        mOnCheckBoxListListener = onCheckBoxListListener;
    }


    @OnClick({R.id.close_drawer, R.id.drawer_cancel, R.id.drawer_confirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.close_drawer:
                mDrawerCallback.closeDrawer();
                break;
            case R.id.drawer_cancel:
                //todo:清空筛选器后关闭drawer

                mDrawerCallback.closeDrawer();
                break;
            case R.id.drawer_confirm:
                //todo:修改筛选器后关闭drawer
                HashMap<Integer, Integer> checked = new HashMap<>();
                checked.putAll(getCheckedIndexs(mStatusSelectorsAdapter, STATUS));
                checked.putAll(getCheckedIndexs(mTimeSelectorsAdapter, TIME));
                checked.putAll(getCheckedIndexs(mWorkTimeSelectorsAdapter, WORK_TIME));
                mOnCheckBoxListListener.onConfirm(checked);
                mDrawerCallback.closeDrawer();
                break;
        }
    }

    public void setDrawerCallback(DrawerCallback drawerCallback) {
        mDrawerCallback = drawerCallback;
    }

    private HashMap<Integer, Integer> getCheckedIndexs(SelectorListAdapter adapter, int type) {
        HashMap<Integer, Integer> checked = new HashMap<>();
        for (int i = 0; i < adapter.getButtonsSelected().size(); i++) {
            if (adapter.getButtonsSelected().get(i)) {
                checked.put(type, i);
            }
        }
        return checked;
    }

    interface DrawerCallback {
        void closeDrawer();
    }

    interface onCheckBoxListListener {
        void onConfirm(HashMap<Integer, Integer> checked);
    }

}
