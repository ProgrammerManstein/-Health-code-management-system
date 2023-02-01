package com.example.javawebproject.model;

import java.io.Serializable;

public class admin implements Serializable {
    private String num;
    private String password;
    private String power;
    public String getNum() {
        return num;
    }
    public void setNum(String num) {
        this.num = num;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPower() {
        return power;
    }
    public void setPower(String power) {
        this.power = power;
    }
}
