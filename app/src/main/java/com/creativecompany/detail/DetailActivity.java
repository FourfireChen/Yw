package com.creativecompany.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.creativecompany.BaseActivity;
import com.creativecompany.R;
import com.creativecompany.act_signup.ActSignUpActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by 45089 on 2018/4/15.
 */

public class DetailActivity extends BaseActivity implements DetailContract.DetailView {
    @BindView(R.id.detail_toolbar)
    Toolbar mDetailToolbar;
    @BindView(R.id.detali_activity_post)
    ImageView mDetaliActivityPost;
    @BindView(R.id.is_signup)
    TextView mIsSignup;
    @BindView(R.id.detail_name)
    TextView mDetailName;
    @BindView(R.id.detail_time)
    TextView mDetailTime;
    @BindView(R.id.detail_contact)
    TextView mDetailContact;
    @BindView(R.id.detail_sponsor_avator)
    CircleImageView mDetailSponsorAvator;
    @BindView(R.id.detail_sponsor_name)
    TextView mDetailSponsorName;
    @BindView(R.id.detail_content)
    TextView mDetailContent;
    @BindView(R.id.joinin)
    Button mJoinin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);
        ButterKnife.bind(this);
        init();
    }

    private void init(){
        setSupportActionBar(mDetailToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @OnClick({R.id.detail_time, R.id.joinin})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.detail_time:
                break;
            case R.id.joinin:
                jumpToAnotherActivity(ActSignUpActivity.class, null);
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
