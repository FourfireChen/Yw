package com.creativecompany.position;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.creativecompany.BaseActivity;
import com.creativecompany.R;
import com.creativecompany.data.bean.User;
import com.creativecompany.position.PositionContract.IpositionPresenter;
import com.creativecompany.position.PositionContract.IpositionView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 45089 on 2018/4/12.
 */

public class PositionActivity extends BaseActivity<IpositionPresenter> implements IpositionView {
    private PosSugAdapter suggestionAdapter;
    private PosHotCitysAdapter hotCityAdapter;
    private IpositionPresenter ipositionPresenter;
    private ArrayList<String> suggestions = new ArrayList<>();
    @BindView(R.id.localtion_toolbar)
    Toolbar localtionToolbar;
    @BindView(R.id.localtion_searchview)
    SearchView localtionSearchview;
    @BindView(R.id.localtion_city)
    Button localtionCity;
    @BindView(R.id.hot_city_gridlist)
    GridView hotCityGridlist;
    @BindView(R.id.hint_list)
    ListView hintList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_home_localtion_activity);
        ButterKnife.bind(this);
        setPresenter(new PositionPresenter(this));
        ipositionPresenter = getPresenter();
        initView();
    }

    private void initView() {
        suggestionAdapter = new PosSugAdapter(suggestions);
        hintList.setAdapter(suggestionAdapter);
        hotCityAdapter = new PosHotCitysAdapter(getHotCity());
        hotCityGridlist.setAdapter(hotCityAdapter);
        setSupportActionBar(localtionToolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("选择城市");
        localtionSearchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(PositionActivity.this, query, Toast.LENGTH_LONG).show();
                ipositionPresenter.queryCity(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Toast.makeText(PositionActivity.this, newText, Toast.LENGTH_LONG).show();
                ipositionPresenter.queryCity(newText);
                return true;
            }
        });
        localtionSearchview.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                hintList.setVisibility(View.INVISIBLE);
                localtionSearchview.clearFocus();
                return true;
            }
        });
        ipositionPresenter.location(getApplicationContext());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void setSuggestionCity(ArrayList<String> suggestionCities) {
        hintList.setVisibility(View.VISIBLE);
        suggestionAdapter.setSuggestionCitys(suggestionCities);
        suggestionAdapter.notifyDataSetChanged();
    }

    @Override
    public void setLocationResult(String school) {
        localtionCity.setText(school);
    }

    private ArrayList<String> getHotCity() {
        ArrayList<String> hotCitys = new ArrayList<>();
        hotCitys.add("北京");
        hotCitys.add("上海");
        hotCitys.add("广州");
        hotCitys.add("深圳");
        hotCitys.add("武汉");
        hotCitys.add("乌鲁木齐");
        hotCitys.add("天津");
        hotCitys.add("长沙");
        hotCitys.add("厦门");
        hotCitys.add("杭州");
        hotCitys.add("南京");
        hotCitys.add("汕头");
        return hotCitys;
    }

    @OnClick(R.id.localtion_city)
    public void onViewClicked() {
        if (localtionCity.getText().toString().equals("定位失败")) {
            ipositionPresenter.location(getApplicationContext());
        } else {
            User.getCurrentUser(User.class).setPositon(localtionCity.getText().toString());
            finish();
        }
    }

}
