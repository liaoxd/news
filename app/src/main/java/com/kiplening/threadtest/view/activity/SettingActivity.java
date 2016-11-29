package com.kiplening.threadtest.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mylibrary.activity.BaseActivity;
import com.kiplening.threadtest.R;
import com.kiplening.threadtest.bean.NewsBean;
import com.kiplening.threadtest.bean.SubNews;
import com.kiplening.threadtest.common.MyApplication;
import com.kiplening.threadtest.view.fragment.CaijingFragment;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by MOON on 11/16/2016.
 * 用于实现新闻栏目的编辑
 */
public class SettingActivity extends BaseActivity{
    private ListView mListView;
    @Override
    protected void initVariables() {

    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        setContentView(R.layout.activity_setting);
        mListView = (ListView) findViewById(R.id.type_list);
        mListView.setAdapter(new SubAdapter(this, MyApplication.getList(this)));

    }

    @Override
    protected void loadData() {

    }

    private class SubAdapter extends BaseAdapter{
        class ListItemView{
            TextView textView;
            CheckBox checkBox;
        }

        private List<SubNews> list;
        private Context context;
        private LayoutInflater listContainer;
        public SubAdapter(Context context, List<SubNews> list) {
            this.context = context;
            listContainer = LayoutInflater.from(context);
            this.list = list;
        }
        @Override
        public int getCount() {
            return list.size();
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
        public View getView(int position, View convertView, ViewGroup parent) {
            final int selectID = position;
            //自定义视图
            SubAdapter.ListItemView listItemView = null;
            if (convertView == null){
                listItemView = new SubAdapter.ListItemView();
                convertView = listContainer.inflate(R.layout.list_item_news,null);

                listItemView.textView = (TextView) convertView.findViewById(R.id.sub_item);
                listItemView.checkBox = (CheckBox) convertView.findViewById(R.id.isSelected);

                convertView.setTag(listItemView);
            }else {
                listItemView = (SubAdapter.ListItemView) convertView.getTag();

            }

            listItemView.textView.setText(list.get(selectID).getName());
            listItemView.checkBox.setChecked(list.get(selectID).isSelected());

            listItemView.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    list.get(selectID).setSelected(b);
                }
            });
            return convertView;
        }
    }
}
