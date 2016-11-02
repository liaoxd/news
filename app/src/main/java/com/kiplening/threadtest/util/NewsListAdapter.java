package com.kiplening.threadtest.util;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by MOON on 10/3/2016.
 */
public class NewsListAdapter extends BaseAdapter{
    private ArrayList<ViewHolder> listItem ;

    public NewsListAdapter(ArrayList<ViewHolder> listItem){
        this.listItem = listItem;
    }
    @Override
    public int getCount() {
        return listItem.size();
    }

    @Override
    public Object getItem(int i) {
        return listItem.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }

    private class ViewHolder{
        ImageView imageView;
        TextView title,source;
    }
}
