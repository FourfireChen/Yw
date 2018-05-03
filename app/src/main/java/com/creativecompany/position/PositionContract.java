package com.creativecompany.position;

import android.content.Context;

import com.creativecompany.IBasePresenter;
import com.creativecompany.IBaseView;

import java.util.ArrayList;

/**
 * Created by 45089 on 2018/4/14.
 */

public interface PositionContract {
    interface IpositionPresenter extends IBasePresenter {
        void queryCity(String editing);

        void location(Context applicationContext);
    }

    interface IpositionView extends IBaseView {
        void setSuggestionCity(ArrayList<String> suggestionCities);

        void setLocationResult(String school);
    }
}
