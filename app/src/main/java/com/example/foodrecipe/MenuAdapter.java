package com.example.foodrecipe;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MenuAdapter extends BaseAdapter{

    public final Context mContext;
    public final Menu[] menus;

    public MenuAdapter(Context mContext, Menu[] menus) {
        this.mContext = mContext;
        this.menus = menus;
    }

    @Override
    public int getCount() {
        return menus.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        /*TextView dummyTextView = new TextView(mContext);
        dummyTextView.setText(String.valueOf(position));
        return dummyTextView;*/

        // 1
        final Menu menu = menus[position];

        // 2
        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.category_list, null);
        }

        // 3
        final ImageView imageView = (ImageView)convertView.findViewById(R.id.img);
        final TextView nameTextView = (TextView)convertView.findViewById(R.id.title);
        //final ImageView imageViewShadow = (ImageView)convertView.findViewById(R.id.shadow_bottom);

        // 4
       imageView.setImageResource(menu.getImg());
        nameTextView.setText(menu.getTitle());

        return convertView;
    }
}
