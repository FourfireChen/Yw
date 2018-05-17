package com.creativecompany.data.bean;

import com.avos.avoscloud.AVUser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 陈钊燚 on 2018/5/11.
 * QQ 1215638092
 * Github FourfireChen
 */
public class Participant extends AVUser {
    String position, gender;
    int age, workHours, ranking;
    ArrayList<Sponsor> mFollows;
    ArrayList<MyActivity> mJoinActivities;



    public int getWorkHours() {
        return workHours;
    }

    public void setWorkHours(int workHours) {
        this.workHours = workHours;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
