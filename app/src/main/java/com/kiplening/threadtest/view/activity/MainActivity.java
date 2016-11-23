package com.kiplening.threadtest.view.activity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.mylibrary.activity.BaseActivity;
import com.kiplening.threadtest.R;
import com.kiplening.threadtest.util.GetNews;
import com.kiplening.threadtest.view.fragment.MainFragment;

import java.io.IOException;

public class MainActivity extends BaseActivity {

    private FragmentManager fragmentManager;
    private ListView mDrawerList;
    private Toolbar toolbar;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;


    @Override
    protected void initVariables() {

    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        //super.onCreate(savedInstanceState);
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = new MainFragment();
        fragmentTransaction.add(R.id.fragment, fragment).commit();

    }

    @Override
    protected void loadData() {

        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.tl_custom);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        toolbar.setTitle("Toolbar");//设置Toolbar标题
        toolbar.setTitleTextColor(Color.parseColor("#ffffff")); //设置标题颜色
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.open, R.string.close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                //mAnimationDrawable.stop();
            }
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                //mAnimationDrawable.start();
            }
        };
        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        //创建返回键，并实现打开关/闭监听

        //设置菜单列表
        //arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lvs);
        //lvLeftMenu.setAdapter(arrayAdapter);
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
