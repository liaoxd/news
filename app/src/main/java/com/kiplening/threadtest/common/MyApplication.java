package com.kiplening.threadtest.common;

import android.app.Application;
import android.content.Context;

import com.example.mylibrary.utils.MySharedPrefrences;
import com.example.mylibrary.utils.SharedPreferencesUtils;
import com.kiplening.threadtest.bean.SubNews;
import com.thinkland.sdk.android.JuheSDKInitializer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MOON on 10/10/2016.
 */

public class MyApplication extends Application {
    private static Setting setting;
    public static List<SubNews> mSubNewsList;
    public static List<SubNews> getList(Context context){
        SharedPreferencesUtils mSharedPreferencesUtils = new SharedPreferencesUtils(context,"subNews");
        mSubNewsList = mSharedPreferencesUtils.get(List.class, "added");
        if (mSubNewsList == null){
            mSubNewsList = new ArrayList<>();
            for (int i = 1; i < 10; i++) {
                mSubNewsList.add(new SubNews(i));
            }
            mSharedPreferencesUtils.save(List.class,"added");
        }
        return mSubNewsList;
    }
    public static Setting getSetting(Context context){
        SharedPreferencesUtils mSharedPrefrencesUtils = new SharedPreferencesUtils(context,"app");
        Setting result = mSharedPrefrencesUtils.get(Setting.class,"setting");
        if (result != null){
            setting = result;
        }
        else{
            setting = new Setting();
        }
        return setting;
    }
    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        JuheSDKInitializer.initialize(getApplicationContext());
    }
}
