package com.weis.cloudcreate.bean;

public class AddGroupBean {
    private String head;
    private String name;
    private String num;
    private String special;
    private String skill;

    public AddGroupBean(String head, String name, String num, String special, String skill) {
        this.head = head;
        this.name = name;
        this.num = num;
        this.special = special;
        this.skill = skill;
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

    public String getSpecial() {
        return special;
    }

    public void setSpecial(String special) {
        this.special = special;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
}
