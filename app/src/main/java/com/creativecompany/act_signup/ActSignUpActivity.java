package com.creativecompany.act_signup;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.creativecompany.BaseActivity;
import com.creativecompany.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 陈钊燚 on 2018/5/7.
 * QQ 1215638092
 * Github FourfireChen
 */

public class ActSignUpActivity extends BaseActivity {
    @BindView(R.id.takepartin_act_post)
    ImageView mTakepartinActPost;
    @BindView(R.id.takepartin_summary)
    TextView mTakepartinSummary;
    @BindView(R.id.signup_school)
    EditText mSignupSchool;
    @BindView(R.id.signup_major)
    EditText mSignupMajor;
    @BindView(R.id.signup_studentid)
    EditText mSignupStudentid;
    @BindView(R.id.signup_name)
    EditText mSignupName;
    @BindView(R.id.signup_contact)
    EditText mSignupContact;
    @BindView(R.id.signup_submit)
    Button mSignupSubmit;
    @BindView(R.id.actsignup_toolbar)
    Toolbar mActsignupToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actsignup_activity);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        setSupportActionBar(mActsignupToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @OnClick(R.id.signup_submit)
    public void onViewClicked() {
        //todo:这个要先弹出alert，后再提交，再finish
        finish();
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
