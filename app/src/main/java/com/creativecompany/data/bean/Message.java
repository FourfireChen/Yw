package com.creativecompany.data.bean;

import com.avos.avoscloud.AVObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by 陈钊燚 on 2018/5/17.
 * QQ 1215638092
 * Github FourfireChen
 */
public class Message extends AVObject {
    private Participant mParticipant;
    private String content;

    public Participant getParticipant() {
        return mParticipant;
    }

    public void setParticipant(Participant participant) {
        mParticipant = participant;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
