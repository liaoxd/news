package com.kiplening.threadtest.bean;

import java.util.List;

/**
 * Created by MOON on 10/12/2016.
 */
public class Result {
    private int stat;
    private List<NewsBean> data;


    public int getStat() {
        return stat;
    }

    public void setStat(int stat) {
        this.stat = stat;
    }

    public List<NewsBean> getData() {
        return data;
    }

    public void setData(List<NewsBean> data) {
        this.data = data;
    }
}
