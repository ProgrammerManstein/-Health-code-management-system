package com.example.javawebproject.model;

public class Person {
    private String name;
    private String id;
    private String num;
    private String phone;
    private String type;
    private String code;
    private String q1;
    private String q2;
    private String q3;
    private String q4;
    private String[] q5;
    private int days;
    private String vaccines;
    public Person(String name, String id,String num,String phone,String type,String q1,String q2,String q3,String q4,String[] q5) //利用构造器初始化成员变量
    {
        this.name =name;
        this.num = num;
        this.id=id;
        this.phone=phone;
        this.type=type;
        this.q1=q1;
        this.q2=q2;
        this.q3=q3;
        this.q4=q4;
        this.q5=q5;
        this.days=days;
    }

    public Person() {
    }

    public String getName()
    {
        return(name);
    }
    public String getNum()
    {
        return(num);
    }
    public String getId(){return(id);}
    public String getPhone(){return phone;}
    public String getType(){return type;}
    public String getQ1(){return (q1);}
    public String getQ2(){return (q2);}
    public String getQ3(){return (q3);}
    public String getQ4(){return (q4);}
    public String[] getQ5(){return (q5);};
    public String getCode(){return (code);}
    public int getDays(){return days;}
    public String getVaccines(){return vaccines;}

    public void setName(String s)
    {
        this.name = s;
    }
    public void setNum(String s)
    {
        this.num = s;
    }
    public void setId(String s){this.id=s;}
    public void setPhone(String s){this.phone=s;}
    public void setType(String s){this.type=s;}
    public void setQ1(String s){this.q1=s;}
    public void setQ2(String s){this.q2=s;}
    public void setQ3(String s){this.q3=s;}
    public void setQ4(String s){this.q4=s;}
    public void setQ5(String[] s){this.q5=s;}
    public void setCode(String s){this.code=s;}
    public void setDays(int days){this.days=days;}
    public void setVaccines(String s){this.vaccines=s;}
}
