package com.kiplening.threadtest.view.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.mylibrary.activity.BaseActivity;
import com.kiplening.threadtest.R;
import com.kiplening.threadtest.util.GetNews;
import com.kiplening.threadtest.view.fragment.MainFragment;

import java.io.IOException;

public class MainActivity extends BaseActivity {

    private FragmentManager fragmentManager;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */


    @Override
    protected void initVariables() {

    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = new MainFragment();
        fragmentTransaction.add(R.id.fragment, fragment).commit();

    }

    @Override
    protected void loadData() {

    }

    final private Handler handler = new Handler() {
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
        Thread thread = new Thread() {
            @Override
            public void run() {
                Drawable drawable = null;
                String string = null;
                try {
                    //drawable = Drawable.createFromStream(new URL(url).openStream(),"image.png");
                    string = (new GetNews()).run(url);
                } catch (IOException e) {
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
