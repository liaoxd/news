package com.kiplening.threadtest.view;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.google.gson.Gson;
import com.kiplening.threadtest.R;
import com.kiplening.threadtest.util.GetNews;
import com.kiplening.threadtest.view.fragment.MainFragment;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private WebView mWebView;
    private FragmentManager fragmentManager;
    private Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = new MainFragment();
        fragmentTransaction.add(R.id.fragment,fragment).commit();

        //mWebView = (WebView) findViewById(R.id.detail);
        //mWebView.loadUrl("http:\\/\\/mini.eastday.com\\/mobile\\/161003134226156.html?qid=juheshuju");
/*
        mWebView.setWebViewClient(new WebViewClient(){
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
*/
        //textView = (TextView) findViewById(R.id.result);

    }
    final private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            //image.setImageDrawable((Drawable)msg.obj);
            try {
                //textView.setText(msg.obj.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    private void getNews(final String url, final int id) {
        Thread thread = new Thread(){
            @Override
            public void run() {
                Drawable drawable = null;
                String string = null;
                try {
                    //drawable = Drawable.createFromStream(new URL(url).openStream(),"image.png");
                    string = (new GetNews()).run(url);
                }catch (IOException e){
                    //Log.d("test",e.getMessage());
                }

                Message message = handler.obtainMessage();
                message.obj = string;
                handler.sendMessage(message);
            }
        };
        thread.start();
        thread = null;
    }
}
