package com.kiplening.threadtest.common;

import com.kiplening.threadtest.bean.SubNews;

import java.util.List;

/**
 * Created by kiplening on 16/11/2016.
 */

public class Setting {
    private List<SubNews> mSubList;
    private int userID;
    private String userName;
    private String passWord;
    private boolean isLoadPic;

    public List<SubNews> getmSubList() {
        return mSubList;
    }

    public void setmSubList(List<SubNews> mSubList) {
        this.mSubList = mSubList;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public boolean isLoadPic() {
        return isLoadPic;
    }

    public void setLoadPic(boolean loadPic) {
        isLoadPic = loadPic;
    }

}
