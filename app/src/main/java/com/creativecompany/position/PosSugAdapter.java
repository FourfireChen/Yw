package com.creativecompany.position;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.creativecompany.R;

import java.util.ArrayList;

/**
 * Created by 45089 on 2018/4/14.
 */

public class PosSugAdapter extends BaseAdapter {
    ArrayList<String> suggestionCitys;

    public PosSugAdapter(ArrayList<String> suggestionCitys) {
        this.suggestionCitys = suggestionCitys;
    }

    @Override
    public int getCount() {
        return suggestionCitys.size();
    }

    @Override
    public Object getItem(int position) {
        return suggestionCitys.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_textview, parent, false);
        TextView textView = view.findViewById(R.id.suggestion);
        textView.setText(suggestionCitys.get(position));
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(parent.getContext(), "你点击了" + suggestionCitys.get(position), Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }

    public void setSuggestionCitys(ArrayList<String> suggestionCitys) {
        this.suggestionCitys = suggestionCitys;
    }
}
