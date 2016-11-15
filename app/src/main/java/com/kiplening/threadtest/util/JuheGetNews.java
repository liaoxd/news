package com.kiplening.threadtest.util;

import android.content.Context;
import android.widget.Toast;

import com.example.mylibrary.utils.JsonUtils;
import com.google.gson.Gson;
import com.kiplening.threadtest.bean.JuheJsonData;
import com.kiplening.threadtest.bean.NewsBean;
import com.kiplening.threadtest.view.fragmentInterface.fragmentPresenter;
import com.thinkland.sdk.android.DataCallBack;
import com.thinkland.sdk.android.JuheData;
import com.thinkland.sdk.android.Parameters;

import java.util.List;

/**
 * Created by MOON on 11/3/2016.
 */

public class JuheGetNews {
    private Context context;
    private List<NewsBean> data;
    private fragmentPresenter presenter;

    public JuheGetNews(Context context,fragmentPresenter presenter){
        this.context = context;
        this.presenter = presenter;
    }

    public void getNews(String type){
        Parameters params = new Parameters();
        params.add("type",type);
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
        JuheData.executeWithAPI(context, 235, "http://v.juhe.cn/toutiao/index",
                JuheData.GET, params, new DataCallBack() {
                    /**
                     * 请求成功时调用的方法 statusCode为http状态码,responseString为请求返回数据.
                     */
                    @Override
                    public void onSuccess(int statusCode, String responseString) {
                        // TODO Auto-generated method stub

                        JuheJsonData mJuheJsonData = JsonUtils.deserialize(responseString,JuheJsonData.class);
                        data = mJuheJsonData.getResult().getData();
                        //presenter.onFinish();
                    }

                    /**
                     * 请求完成时调用的方法,无论成功或者失败都会调用.
                     */
                    @Override
                    public void onFinish() {
                        // TODO Auto-generated method stub
                        Toast.makeText(context, "finish",
                                Toast.LENGTH_SHORT).show();
                        presenter.onFinish(data);
                        System.out.println("超级*************************************************");
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
                        presenter.onFailure();

                    }
                });
    }
}
