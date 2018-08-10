package com.weis.cloudcreate.bean;

public class AddPublicBean {
    private String head;
    private String name;
    private String skill;

    public AddPublicBean(String head, String name, String skill) {
        this.head = head;
        this.name = name;
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

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
}
