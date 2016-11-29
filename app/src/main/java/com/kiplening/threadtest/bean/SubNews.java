package com.kiplening.threadtest.bean;

/**
 * Created by kiplening on 16/11/2016.
 */
public class SubNews {
    private int id;
    private String name;
    private String APIName;

    public SubNews(int id) {
        this.id = id;
        switch (id){
            case 1:this.name = "头条";this.APIName = "toutiao";break;
            case 2:this.name = "科技";this.APIName = "keji";break;
            case 3:this.name = "娱乐";this.APIName = "yule";break;
            case 4:this.name = "社会";this.APIName = "shehui";break;
            case 5:this.name = "国内";this.APIName = "guonei";break;
            case 6:this.name = "体育";this.APIName = "tiyu";break;
            case 7:this.name = "军事";this.APIName = "junshi";break;
            case 8:this.name = "财经";this.APIName = "caijing";break;
            case 9:this.name = "时尚";this.APIName = "shishang";break;
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

}
