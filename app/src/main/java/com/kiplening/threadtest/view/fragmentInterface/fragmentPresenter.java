package com.kiplening.threadtest.view.fragmentInterface;

import com.kiplening.threadtest.bean.NewsBean;

import java.util.List;

/**
 * Created by MOON on 11/3/2016.
 */

public interface fragmentPresenter {
    public void onSuccess();
    public void onFailure();
    public void onFinish(List<NewsBean> list);
}
