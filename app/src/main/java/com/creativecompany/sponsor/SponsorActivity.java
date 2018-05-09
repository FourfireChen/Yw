package com.creativecompany.sponsor;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.creativecompany.BaseActivity;
import com.creativecompany.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by 陈钊燚 on 2018/5/8.
 * QQ 1215638092
 * Github FourfireChen
 */

public class SponsorActivity extends BaseActivity {
    @BindView(R.id.sponsor_toolbar)
    Toolbar mSponsorToolbar;
    @BindView(R.id.sponsor_background)
    ImageView mSponsorBackground;
    @BindView(R.id.sponsor_avator)
    CircleImageView mSponsorAvator;
    @BindView(R.id.sponor_name)
    TextView mSponorName;
    @BindView(R.id.sponsor_summary)
    TextView mSponsorSummary;
    @BindView(R.id.sponsor_activities)
    ListView mSponsorActivities;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sponsor_activity);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        setSupportActionBar(mSponsorToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
