package com.example.mylibrary.utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

import java.lang.reflect.Type;

/**
 * Created by kiplening on 15/11/2016.
 */

public class JsonUtils {
    public static Gson mGson = new Gson();

    /**
     * 将对象转换为json字符串
     * @param object
     * @param <T>
     * @return
     */
    public static <T> String serialize(T object){
        return mGson.toJson(object);
    }
    /**
     * 将 json 字符串转换为对象
     * @param json
     * @param clz
     * @param <T>
     * @return
     */
    public static <T> T deserialize(String json, Class<T> clz){
        return mGson.fromJson(json,clz);
    }

    /**
     * 将json对象转换为实体对象
     * @param json
     * @param clz
     * @param <T>
     * @return
     * @throws JsonSyntaxException
     */
    public static <T> T deserialize(JsonObject json, Class<T> clz) throws JsonSyntaxException {
        return mGson.fromJson(json, clz);
    }

    /**
     * 将json字符串转换为对象
     * @param json
     * @param type
     * @param <T>
     * @return
     */
    public static <T> T deserialize(String json, Type type) throws JsonSyntaxException {
        return mGson.fromJson(json, type);
    }

}
