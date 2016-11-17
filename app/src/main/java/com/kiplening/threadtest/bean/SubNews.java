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
            case 1:this.name = "top";this.APIName = "toutiao";break;
            case 2:this.name = "science";this.APIName = "keji";break;
            case 3:this.name = "entertainment";this.APIName = "yule";break;
            case 4:this.name = "society";this.APIName = "shehui";break;
            case 5:this.name = "inland";this.APIName = "guonei";break;
            case 6:this.name = "sport";this.APIName = "tiyu";break;
            case 7:this.name = "military";this.APIName = "junshi";break;
            case 8:this.name = "财经";this.APIName = "caijing";break;
            case 9:this.name = "fashion";this.APIName = "shishang";break;
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
