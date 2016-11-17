package com.kiplening.threadtest.util;

import android.content.Context;
import android.content.Intent;

/**
 * Created by MOON on 11/16/2016.
 */

public class JumpToActivity {
    /**
     * 实现 Activity 之间的跳转
     * @param origin
     * @param target
     * @param <T>
     */
    public static <T> void jump(Context origin, Class<T> target){
        Intent intent = new Intent(origin,target);
        origin.startActivity(intent);
    }

    /**
     * 实现带数据传递的 Activity跳转
     * @param origin
     * @param target
     * @param key
     * @param value
     * @param <T>
     */
    public static <T> void jump(Context origin, Class<T> target, String key, String value){
        Intent intent = new Intent(origin, target);
        intent.putExtra(key, value);
        origin.startActivity(intent);
    }
}
