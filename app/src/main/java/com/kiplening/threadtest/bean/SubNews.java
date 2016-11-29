package com.kiplening.threadtest.bean;

/**
 * Created by kiplening on 16/11/2016.
 */
public class SubNews {
    private int id;
    private String name;
    private String APIName;
    private boolean isSelected;

    public SubNews(int id) {
        this.id = id;
        switch (id){
            case 1:this.name = "头条";this.APIName = "toutiao";this.isSelected = false;break;
            case 2:this.name = "科技";this.APIName = "keji";this.isSelected = false;break;
            case 3:this.name = "娱乐";this.APIName = "yule";this.isSelected = false;break;
            case 4:this.name = "社会";this.APIName = "shehui";this.isSelected = false;break;
            case 5:this.name = "国内";this.APIName = "guonei";this.isSelected = false;break;
            case 6:this.name = "体育";this.APIName = "tiyu";this.isSelected = false;break;
            case 7:this.name = "军事";this.APIName = "junshi";this.isSelected = false;break;
            case 8:this.name = "财经";this.APIName = "caijing";this.isSelected = false;break;
            case 9:this.name = "时尚";this.APIName = "shishang";this.isSelected = false;break;
        }
    }

    public String getAPIName() {
        return APIName;
    }

    public void setAPIName(String APIName) {
        this.APIName = APIName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
