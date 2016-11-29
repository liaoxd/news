package com.kiplening.threadtest.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.kiplening.threadtest.R;
import com.kiplening.threadtest.bean.SubNews;
import com.kiplening.threadtest.common.MyApplication;
import com.kiplening.threadtest.common.Setting;
import com.kiplening.threadtest.util.JumpToActivity;
import com.kiplening.threadtest.util.PagerSlidingTabStrip;
import com.kiplening.threadtest.view.activity.SettingActivity;

import java.util.List;

/**
 * Created by MOON on 10/27/2016.
 */
public class MainFragment extends Fragment {
    private View view;
    private Setting setting;
    private static List<SubNews> list;

    private PagerSlidingTabStrip tabs;
    private ViewPager pager;
    private Button mButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.main_fragment_layout,container,false);
        pager = (ViewPager) view.findViewById(R.id.pager);
        mButton = (Button) view.findViewById(R.id.change);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JumpToActivity.jump(getActivity(), SettingActivity.class);
            }
        });
        setting = MyApplication.getSetting(getActivity());
        tabs = (PagerSlidingTabStrip) view.findViewById(R.id.tabs);
        if (tabs == null)
            System.out.println("获取不到tabs!");
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //TITLES = getResources().getStringArray(R.array.news_titles);
        list = setting.getmSubList();

        FragmentPagerAdapter adapter = new NewsAdapter(getChildFragmentManager());
        pager.setAdapter(adapter);

        final int pageMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                4,getResources().getDisplayMetrics());
        pager.setPageMargin(pageMargin);

        tabs.setViewPager(pager);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JumpToActivity.jump(getActivity(),SettingActivity.class);
            }
        });
    }
    class NewsAdapter extends FragmentPagerAdapter {
        public NewsAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return new TopFragment();
            }
            if (position == 1) {
                return new ScienceFragment();
            }
            if (position == 2) {
                return new EntertainmentFragment();
            }
            if (position == 3) {
                return new SocietyFragment();
            }
            if (position == 4) {
                return new InlandFragment();
            }
            if (position == 5) {
                return new SportFragment();
            }
            if (position == 6) {
                return new MilitaryFragment();
            }
            if (position == 7) {
                return new CaijingFragment();
            }
            if (position == 8) {
                return new FashionFragment();
            }
            return new TopFragment();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            //return TITLES[position % TITLES.length];
            return list.get(position % list.size()).getName();
        }

        @Override
        public int getCount() {
            //return TITLES.length;
            return list.size();
        }
    }
}
