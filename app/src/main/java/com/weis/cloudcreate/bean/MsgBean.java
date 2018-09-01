package com.weis.cloudcreate.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/8/4.
 */

public class MsgBean implements Serializable{
    private int imgID;
    private String name;
    private String content;
    private String num;

    public MsgBean(int imgID, String name, String content, String num) {
        this.imgID = imgID;
        this.name = name;
        this.content = content;
        this.num = num;
    }

    public int getImgID() {
        return imgID;
    }

    public void setImgID(int imgID) {
        this.imgID = imgID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
