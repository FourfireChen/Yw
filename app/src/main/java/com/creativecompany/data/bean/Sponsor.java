package com.creativecompany.data.bean;

import com.avos.avoscloud.AVObject;

import java.util.List;

/**
 * Created by 陈钊燚 on 2018/5/8.
 * QQ 1215638092
 * Github FourfireChen
 */

public class Sponsor extends AVObject{
    private String name, summary;
    private List<MyActivity> mMyActivityList;
    private int fans;
    private byte[] background;

    public Sponsor() {
    }

    public Sponsor(String name, String summary, List<MyActivity> myActivityList, int fans, byte[] background) {
        this.name = name;
        this.summary = summary;
        mMyActivityList = myActivityList;
        this.fans = fans;
        this.background = background;
    }

    public byte[] getBackground() {
        return background;
    }

    public void setBackground(byte[] background) {
        this.background = background;
    }

    public int getFans() {
        return fans;
    }

    public void setFans(int fans) {
        this.fans = fans;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List<MyActivity> getMyActivityList() {
        return mMyActivityList;
    }

    public void setMyActivityList(List<MyActivity> myActivityList) {
        mMyActivityList = myActivityList;
    }
}
