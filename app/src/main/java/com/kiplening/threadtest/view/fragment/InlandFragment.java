package com.kiplening.threadtest.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.kiplening.threadtest.R;
import com.kiplening.threadtest.bean.NewsBean;
import com.kiplening.threadtest.util.JuheGetNews;
import com.kiplening.threadtest.view.activity.NewsActivity;
import com.kiplening.threadtest.view.fragmentInterface.fragmentPresenter;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by MOON on 11/3/2016.
 */
public class InlandFragment extends Fragment implements fragmentPresenter {
    private Gson gson;
    private View view;
    private ListView listView;
    private JuheGetNews getNews;
    private MyAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.top_list, null);
        listView = (ListView) view.findViewById(R.id.news_list);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getNews = new JuheGetNews(getActivity(),this);
        getNews.getNews("guonei");
    }

    @Override
    public void onResume() {
        super.onResume();
//        adapter.notifyDataSetChanged();
    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void onFailure() {

    }

    @Override
    public void onFinish(List<NewsBean> list) {
        adapter = new MyAdapter(getActivity(),list);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private class MyAdapter extends BaseAdapter {
        public class ListItemView{   //自定义控件集合
            ImageView pic;
            TextView title;
            TextView type;
        }
        private List<NewsBean> list;
        private Context context;
        private LayoutInflater listContainer;
        public MyAdapter(Context context, List<NewsBean> list) {
            this.context = context;
            listContainer = LayoutInflater.from(context);
            this.list = list;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final int selectID = position;
            //自定义视图
            MyAdapter.ListItemView listItemView = null;
            if (convertView == null){
                listItemView = new MyAdapter.ListItemView();
                convertView = listContainer.inflate(R.layout.list_item,null);

                listItemView.pic = (ImageView) convertView.findViewById(R.id.pic);
                listItemView.title = (TextView) convertView.findViewById(R.id.title);
                listItemView.type = (TextView) convertView.findViewById(R.id.type);

                convertView.setTag(listItemView);
            }else {
                listItemView = (MyAdapter.ListItemView) convertView.getTag();

            }

            Picasso.with(getActivity())
                    .load(list.get(selectID).getThumbnail_pic_s())
                    .into(listItemView.pic);

            listItemView.title.setText(list.get(selectID).getTitle());
            listItemView.type.setText(list.get(selectID).getType());

            listItemView.title.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), NewsActivity.class);
                    intent.putExtra("url",list.get(selectID).getUrl());
                    startActivity(intent);
                }
            });
            return convertView;
        }

    }
}
