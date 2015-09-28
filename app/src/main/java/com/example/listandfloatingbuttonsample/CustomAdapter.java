package com.example.listandfloatingbuttonsample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<Item> {

    private Context context;
    private LayoutInflater layoutInflater;
    private Callback callback;
    private ArrayList<Item> items;
    private int res;

    public interface Callback {
        void onClickCheckBox(int position);
    }

    public CustomAdapter(Context context, int resource, List<Item> objects) {
        super(context, resource, objects);

        this.context = context;
        this.items = (ArrayList<Item>) objects;
        this.res = resource;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = layoutInflater.inflate(this.res, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder)convertView.getTag();
        }

        Item item = items.get(position);

        viewHolder.title.setText(item.getTitle());
        viewHolder.subTitle.setText(item.getSubTitle());
        viewHolder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(callback != null) callback.onClickCheckBox(position);
            }
        });
        viewHolder.checkBox.setChecked(item.isCompleted());

        return convertView;
    }

    public static class ViewHolder {
        CheckBox checkBox;
        TextView title;
        TextView subTitle;

        public ViewHolder(View v) {
            checkBox = (CheckBox) v.findViewById(R.id.checkBox);
            title = (TextView) v.findViewById(R.id.title);
            subTitle = (TextView) v.findViewById(R.id.sub_title);
        }
    }

    public void setCallback(Callback callback) { this.callback = callback; }

}
