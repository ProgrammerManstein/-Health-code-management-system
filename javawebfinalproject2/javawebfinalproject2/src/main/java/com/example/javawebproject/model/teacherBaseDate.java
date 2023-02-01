package com.example.javawebproject.model;

import java.io.Serializable;

public class teacherBaseDate implements Serializable {
    private String name;
    private String id;
    private String num;
    private String school;
    private String role;
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
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

}
