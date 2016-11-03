package com.kiplening.threadtest.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.kiplening.threadtest.R;
import com.kiplening.threadtest.bean.JuheJsonData;
import com.kiplening.threadtest.bean.NewsBean;
import com.kiplening.threadtest.view.NewsActivity;
import com.squareup.picasso.Picasso;
import com.thinkland.sdk.android.DataCallBack;
import com.thinkland.sdk.android.JuheData;
import com.thinkland.sdk.android.Parameters;

import org.json.JSONTokener;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MOON on 11/3/2016.
 */
public class InlandFragment extends Fragment {
    private Gson gson;
    private View view;
    private ListView listView;
    private List<NewsBean> data;
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
        Parameters params = new Parameters();
        params.add("type","guonei");
        //params.add("ip", "www.juhe.cn");
        //params.add("dtype", "json");
        /**
         * 请求的方法 参数: 第一个参数 当前请求的context;
         * 				  第二个参数 接口id;
         * 				  第三个参数 接口请求的url;
         * 				  第四个参数 接口请求的方式;
         * 				  第五个参数 接口请求的参数,键值对com.thinkland.sdk.android.Parameters类型;
         * 				  第六个参数请求的回调方法,com.thinkland.sdk.android.DataCallBack;
         *
         */
        JuheData.executeWithAPI(getActivity(), 235, "http://v.juhe.cn/toutiao/index",
                JuheData.GET, params, new DataCallBack() {
                    /**
                     * 请求成功时调用的方法 statusCode为http状态码,responseString为请求返回数据.
                     */
                    @Override
                    public void onSuccess(int statusCode, String responseString) {
                        // TODO Auto-generated method stub
                        //textView.append(responseString + "\n");
                        ArrayList<NewsBean> newsList = new ArrayList<NewsBean>();
                        //Object object = JsonUtils.deserialize(responseString,);
                        JSONTokener jsonTokener = new JSONTokener(responseString);
                        gson = new Gson();
                        JuheJsonData juheJsonData = gson.fromJson(responseString,JuheJsonData.class);
                        data = juheJsonData.getResult().getData();
                        /*
                        try {


                            JsonObject jObject = (JsonObject) jsonTokener.nextValue();
                            JsonArray data = jObject.getAsJsonArray("data");
                            for (int i = 0; i < data.size(); i ++){
                                newsList.add(JsonUtils.deserialize(data.get(i).getAsJsonObject(),NewsBean.class));
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        */
                    }

                    /**
                     * 请求完成时调用的方法,无论成功或者失败都会调用.
                     */
                    @Override
                    public void onFinish() {
                        // TODO Auto-generated method stub
                        Toast.makeText(getContext(), "finish",
                                Toast.LENGTH_SHORT).show();
                        //System.out.println();
                        adapter = new MyAdapter(getActivity(),data);
                        listView.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                    }

                    /**
                     * 请求失败时调用的方法,statusCode为http状态码,throwable为捕获到的异常
                     * statusCode:30002 没有检测到当前网络.
                     * 			  30003 没有进行初始化.
                     * 			  0 未明异常,具体查看Throwable信息.
                     * 			  其他异常请参照http状态码.
                     */
                    @Override
                    public void onFailure(int statusCode,
                                          String responseString, Throwable throwable) {
                        // TODO Auto-generated method stub
                        //textView.append(throwable.getMessage() + "\n");
                    }
                });
        //getNews("http:\\/\\/mini.eastday.com\\/mobile\\/161003134226156.html?qid=juheshuju",1);
        //httpURLConnection.getResponseMessage();

    }

    @Override
    public void onResume() {
        super.onResume();
//        adapter.notifyDataSetChanged();
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
            //handler.handleMessage();
            /*


            try {
                listItemView.pic.setImageDrawable(Drawable.createFromStream(new URL(list.get(position).getThumbnail_pic_s()).openStream(),"image.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
*/
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

        final private Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                //image.setImageDrawable((Drawable)msg.obj);
                try {

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        private void getNews(final String url, final int id) {
            Thread thread = new Thread() {
                @Override
                public void run() {
                    Drawable drawable = null;
                    String string = null;
                    try {
                        drawable = Drawable.createFromStream(new URL(url).openStream(),"image.png");
                        //string = (new GetNews()).run(url);
                    } catch (IOException e) {
                        //Log.d("test",e.getMessage());
                    }

                    Message message = handler.obtainMessage();
                    message.obj = drawable;
                    handler.sendMessage(message);
                }
            };
            thread.start();
            thread = null;
        }
    }
}
