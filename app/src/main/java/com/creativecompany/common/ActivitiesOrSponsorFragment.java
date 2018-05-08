package com.creativecompany.common;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.creativecompany.BaseFragment;
import com.creativecompany.R;
import com.creativecompany.all.AllActivity;
import com.creativecompany.data.bean.MyActivity;
import com.creativecompany.detail.DetailActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.creativecompany.util.ID.FRAGEMTN_TYPE;

/**
 * Created by 陈钊燚 on 2018/5/2.
 * QQ 1215638092
 * Github FourfireChen
 */

public class ActivitiesOrSponsorFragment extends BaseFragment implements AdapterView.OnItemClickListener {
    @BindView(R.id.home_item_title)
    TextView homeItemTitle;
    @BindView(R.id.home_item_all)
    Button homeItemAll;
    Unbinder unbinder;
    @BindView(R.id.home_activitylist)
    ListView homeActivitylist;
    private ArrayList<MyActivity> activities = new ArrayList<>();
    private int fragmentType;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle mBundle = getArguments();
        if(mBundle == null) Log.e("activities list fragment", "没有传入数据，无法识别是哪一主办方frg还是活动frg");
        else{
            fragmentType = mBundle.getInt(FRAGEMTN_TYPE);
        }
        View view = inflater.inflate(R.layout.main_home_activity_fragment, container, false);
        for (int i = 0; i < 3; i++) {
            activities.add(new MyActivity(null, null, null, "就是我就是我我就是活动", null, "1"));
        }
        unbinder = ButterKnife.bind(this, view);
        homeActivitylist.setAdapter(new ActivitiesOrSponsorsAdapter(activities));
        homeActivitylist.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.home_item_all)
    public void onViewClicked() {
        jumpToAnotherActivity(AllActivity.class, null);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        jumpToAnotherActivity(DetailActivity.class, null);
        //Toast.makeText(getContext(), "点了活动" + position, Toast.LENGTH_SHORT).show();
    }
}
