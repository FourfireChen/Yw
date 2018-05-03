package com.creativecompany.data.bean;

import cn.bmob.v3.BmobUser;

/**
 * Created by 45089 on 2018/4/14.
 */
public class User extends BmobUser {
    private String positon;
    private String gender;
    private Integer age;


    public User() {
        super();
        positon = "";
        gender = "";
        age = 0;
    }

    public User(String positon, String gender, Integer age) {
        super();
        this.positon = positon;
        this.gender = gender;
        this.age = age;
    }

    public String getPositon() {
        return positon;
    }

    public void setPositon(String positon) {
        this.positon = positon;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
