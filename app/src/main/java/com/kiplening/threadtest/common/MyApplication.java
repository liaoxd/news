package com.kiplening.threadtest.common;

import android.app.Application;
import android.content.Context;

import com.example.mylibrary.utils.MySharedPrefrences;
import com.thinkland.sdk.android.JuheSDKInitializer;

/**
 * Created by MOON on 10/10/2016.
 */

public class MyApplication extends Application {
    private static Setting setting;
    public static Setting getSetting(Context context){
        MySharedPrefrences mySharedPrefrences = new MySharedPrefrences(context,"app");
        Setting result = mySharedPrefrences.load("setting",Setting.class);
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
