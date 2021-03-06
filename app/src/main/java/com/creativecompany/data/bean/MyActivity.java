package com.creativecompany.data.bean;

import com.avos.avoscloud.AVObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 陈钊燚 on 2018/5/2.
 * QQ 1215638092
 * Github FourfireChen
 */

public class MyActivity extends AVObject {
    private String title, summary, time, content, id;
    private byte[] avator;
    private ArrayList<Participant> participants;
    private ArrayList<Message> mMessages;


    public MyActivity(String title, String summary, String time, String content, byte[] avator, String id) {
        this.title = title;
        this.summary = summary;
        this.time = time;
        this.content = content;
        this.avator = avator;
        this.id = id;
    }

    public MyActivity() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public byte[] getAvator() {
        return avator;
    }

    public void setAvator(byte[] avator) {
        this.avator = avator;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(ArrayList<Participant> participants) {
        this.participants = participants;
    }
}
