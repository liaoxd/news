package com.kiplening.threadtest.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by MOON on 10/3/2016.
 */

public class NewsBean implements Parcelable{

    //private int uniquekey;
    private String title;
    private String date;
    private String author_name;
    private String url;
    private String type;
    private String real_type;
    private String thumbnail_pic_s;
    private String thumbnail_pic_s02;


    protected NewsBean(Parcel in) {
        //this.uniquekey = in.readInt();
        this.title = in.readString();
        this.date = in.readString();
        this.author_name = in.readString();
        this.url = in.readString();
        this.type = in.readString();
        this.real_type = in.readString();
        this.thumbnail_pic_s = in.readString();
        this.thumbnail_pic_s02 = in.readString();
    }

    public static final Creator<NewsBean> CREATOR = new Creator<NewsBean>() {
        @Override
        public NewsBean createFromParcel(Parcel in) {
            return new NewsBean(in);
        }

        @Override
        public NewsBean[] newArray(int size) {
            return new NewsBean[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        //dest.writeInt(uniquekey);
        dest.writeString(title);
        dest.writeString(date);
        dest.writeString(author_name);
        dest.writeString(url);
        dest.writeString(type);
        dest.writeString(real_type);
        dest.writeString(thumbnail_pic_s);
        dest.writeString(thumbnail_pic_s02);
    }

    //public int getUniquekey() {
    //    return uniquekey;
    //}

    //public void setUniquekey(int uniquekey) {
    //    this.uniquekey = uniquekey;
    //}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getReal_type() {
        return real_type;
    }

    public void setReal_type(String real_type) {
        this.real_type = real_type;
    }

    public String getThumbnail_pic_s() {
        return thumbnail_pic_s;
    }

    public void setThumbnail_pic_s(String thumbnail_pic_s) {
        this.thumbnail_pic_s = thumbnail_pic_s;
    }

    public String getThumbnail_pic_s02() {
        return thumbnail_pic_s02;
    }

    public void setThumbnail_pic_s02(String thumbnail_pic_s02) {
        this.thumbnail_pic_s02 = thumbnail_pic_s02;
    }
}
