package com.example.mylibrary.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by MOON on 11/29/2016.
 */


public class SharedPreferencesUtils {
    private SharedPreferences mSharedPreferences;

    public SharedPreferencesUtils(Context context, String name){
        this.mSharedPreferences = context.getSharedPreferences(name,Context.MODE_PRIVATE);
    }

    /**
     * 获取特定的 SharedPreferences 中存储的对象，type 为该对象的类型。
     * @param target
     * @param type
     * @param <T>
     * @return
     */
    public <T> T get(Class<T> target, String type){
        String temp = mSharedPreferences.getString(type,"");
        return JsonUtils.deserialize(temp,target);
    }

    /**
     * 保存特定的 type 数据到 SharedPreferences 当中。
     * @param target
     * @param type
     * @param <T>
     */
    public <T> void save(Class<T> target, String type){
        SharedPreferences.Editor mEditor = mSharedPreferences.edit();
        mEditor.putString("all",JsonUtils.serialize(target));
        mEditor.commit();
    }

}
