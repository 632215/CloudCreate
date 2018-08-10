package com.weis.cloudcreate.bean;

public class AddHumanBean {
    String head;
    String name;
    String num;
    String age;
    String sex;
    String skill;

    public AddHumanBean(String head, String name, String num, String age, String sex, String skill) {
        this.head = head;
        this.name = name;
        this.num = num;
        this.age = age;
        this.sex = sex;
        this.skill = skill;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getage() {
        return age;
    }

    public void setage(String age) {
        this.age = age;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
}
