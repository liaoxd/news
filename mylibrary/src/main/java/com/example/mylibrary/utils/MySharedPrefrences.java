package com.example.mylibrary.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by kiplening on 15/11/2016.
 */

public class MySharedPrefrences {
    private SharedPreferences mSharedPreferences;

    public MySharedPrefrences(Context context, String name){
        this(context,name, Context.MODE_PRIVATE);
    }
    public MySharedPrefrences(Context context, String name, int mode){
        this.mSharedPreferences = context.getSharedPreferences(name,mode);
    }

    /**
     * 保存一个字符串到 SharedPreferences 中
     * @param key
     * @param value
     * @return
     */
    public boolean save(String key, String value){
        SharedPreferences.Editor mEditor = mSharedPreferences.edit();
        mEditor.putString(key, value);
        mEditor.commit();
        return true;
    }

    /**
     * 保存一个对象到 SharedPreferences 中，利用了 Json 数据的形式存入。
     * @param key
     * @param object
     * @param <T>
     * @return
     */
    public <T> boolean save(String key, T object){
        String mStr = JsonUtils.serialize(object);
        SharedPreferences.Editor mEditor = mSharedPreferences.edit();
        mEditor.putString(key,mStr);
        mEditor.commit();
        return true;
    }

    /**
     * 从 SharedPreferences 当中取出一个字符串
     * @param key
     * @return
     */
    public String load (String key){
        return mSharedPreferences.getString(key,"null");
    }

    /**
     * 从 SharedPreferences 当中取出一个对象
     * @param key
     * @param cls
     * @param <T>
     * @return
     */
    public <T> T load(String key, Class<T> cls){
        String mStr = mSharedPreferences.getString(key, null);
        if (mStr == null){
            Log.i("erro", "数据为空");
            return null;
        }
        else {
            return JsonUtils.deserialize(mStr,cls);
        }
    }


}
