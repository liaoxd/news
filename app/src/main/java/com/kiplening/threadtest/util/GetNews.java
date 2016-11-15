package com.kiplening.threadtest.util;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by MOON on 10/3/2016.
 */

public class GetNews {
    //private OkHttpUtils okHttpUtils = OkHttpUtils.getOkHttpUtils();
    private OkHttpClient client;
    public GetNews(){
        client = new OkHttpClient();
    }
    public String run(String url) throws IOException{
        Request request = new Request.Builder().url(url).build();

        Response response = client.newCall(request).execute();
        String string = response.body().string();
        System.out.println(string);
        return string;
        //return response.toString();
    }
}
