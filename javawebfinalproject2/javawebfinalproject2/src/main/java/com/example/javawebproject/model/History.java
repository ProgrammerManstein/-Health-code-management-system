package com.example.javawebproject.model;

import java.sql.Timestamp;
import java.util.Date;

public class History {
    private String num;
    private Timestamp date;
    private String code;
    public History(String num,Timestamp date,String code) //利用构造器初始化成员变量
    {
        this.num = num;
        this.code=code;
        this.date=date;
    }

    public History() {
    }

    public String getNum()
    {
        return(num);
    }
    public Timestamp getDate()
    {
        return(date);
    }
    public String getCode(){return (code);}

    public void setNum(String s)
    {
        this.num = s;
    }
    public void setCode(String s){this.code=s;}
    public void setDate(Timestamp d){this.date=d;}
}