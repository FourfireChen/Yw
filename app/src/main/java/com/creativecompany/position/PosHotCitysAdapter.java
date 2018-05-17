package com.creativecompany.position;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Toast;

import com.creativecompany.R;

import java.util.ArrayList;

/**
 * Created by 45089 on 2018/4/14.
 */

public class PosHotCitysAdapter extends BaseAdapter {
    ArrayList<String> citys;

    public PosHotCitysAdapter(ArrayList<String> citys) {
        this.citys = citys;
    }

    @Override
    public int getCount() {
        return citys.size();
    }

    @Override
    public Object getItem(int position) {
        return citys.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_button, parent, false);
        Button item = view.findViewById(R.id.hot_city_item);
        item.setText(citys.get(position));
        item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(parent.getContext(), citys.get(position), Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }
}
