package com.creativecompany.all.activity;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.creativecompany.R;
import com.creativecompany.util.ID;

import java.util.ArrayList;

import static com.creativecompany.util.ID.STATUS;
import static com.creativecompany.util.ID.TIME;
import static com.creativecompany.util.ID.WORK_TIME;

/**
 * Created by 陈钊燚 on 2018/5/6.
 * QQ 1215638092
 * Github FourfireChen
 */

public class SelectorListAdapter extends RecyclerView.Adapter<SelectorListAdapter.SelectorViewHolder> {
    private ArrayList<String> items = new ArrayList<>();
    private ArrayList<Boolean> mButtonsSelected = new ArrayList<>();

    public SelectorListAdapter() {
    }

    public SelectorListAdapter(int type) {
        this.items = createButtonContent(type);
        for (int i = 0; i < items.size(); i++) {
            mButtonsSelected.add(false);
        }
    }

    @Override
    public SelectorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = new Button(parent.getContext());
        ((Button) view).setBackground(parent.getResources().getDrawable(R.drawable.buttonselector, null));
        ((Button) view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int index = items.indexOf(((Button) v).getText());
                if (index >= 0 && index <= items.size()) {
                    mButtonsSelected.set(index, true);
                }
            }
        });
        return new SelectorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SelectorViewHolder holder, int position) {
        holder.mButton.setText(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }


    public void setItems(ArrayList<String> items) {
        this.items = items;
        for (int i = 0; i < items.size(); i++) {
            mButtonsSelected.add(false);
        }
    }

    public ArrayList<Boolean> getButtonsSelected() {
        return mButtonsSelected;
    }

    class SelectorViewHolder extends RecyclerView.ViewHolder {
        private Button mButton;

        public SelectorViewHolder(View itemView) {
            super(itemView);
            mButton = (Button) itemView;
        }
    }

    private ArrayList<String> createButtonContent(int selectorType) {
        ArrayList<String> items = new ArrayList<>();
        switch (selectorType) {
            case TIME:
                items.add("周一");
                items.add("周二");
                items.add("周三");
                items.add("周四");
                items.add("周五");
                items.add("周六");
                items.add("周日");
                break;
            case WORK_TIME:
                items.add(" 1h ");
                items.add("1—3h");
                items.add(" 3h ");
                items.add("全部");
                break;
            case STATUS:
                items.add("短期");
                items.add("长期");
                items.add("全部");
                break;
            default:
                break;
        }
        return items;
    }

}
