package com.example.javawebproject.model;

import java.io.Serializable;

public class studentBaseDate implements Serializable {
    private String name;
    private String id;
    private String num;
    private String school;
    private String major;
    private String Class;
    private String phone;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNum() {
        return num;
    }
    public void setNum(String number) {
        this.num = number;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSchool() {
        return school;
    }
    public void setSchool(String school) {
        this.school = school;
    }
    public String getMajor() {
        return major;
    }
    public void setMajor(String major) {
        this.major = major;
    }
    public String get_Class() {
        return Class;
    }
    public void set_Class(String Class) {
        this.Class = Class;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

}
