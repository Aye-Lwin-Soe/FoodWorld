package com.example.foodrecipe;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.ImageView;

public class GridAdapter extends BaseAdapter {
    private Context context;
    private Integer[] imageIds = {
            R.drawable.category, R.drawable.category,
            R.drawable.category, R.drawable.category
    };

    public GridAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return imageIds.length;
    }

    @Override
    public Object getItem(int i) {
        return imageIds[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView iview;
        if (view == null) {
            iview = new ImageView(context);
            iview.setLayoutParams(new GridLayout.LayoutParams());
            iview.setScaleType(ImageView.ScaleType.CENTER_CROP);
            iview.setPadding(5, 5, 5, 5);
        } else {
            iview = (ImageView) view;
        }
        iview.setImageResource(imageIds[i]);
        return iview;
    }

    protected class ImageWithUrl extends Object {
        private int imageId;
        private String imageUrlString;

        ImageWithUrl(int id, String url) {
            imageId = id;
            imageUrlString = url;
        }

        public int getImageId() {
            return imageId;
        }

        public String getImageUrlString() {
            return imageUrlString;
        }

        public void setImageId(int imageId) {
            this.imageId = imageId;
        }

        public void setImageUrlString(String imageUrlString) {
            this.imageUrlString = imageUrlString;
        }
    }
}
