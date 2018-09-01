package com.weis.cloudcreate.bean;

public class DialogBean {
    private int sourceType;
    private int msgTpye;
    private String infoHeadUrl;
    private String infoName;
    private String content;
    private String imgUrl;
    private String time;

    public DialogBean(int sourceType, int msgTpye, String infoHeadUrl, String infoName, String content, String imgUrl, String time) {
        this.sourceType = sourceType;
        this.msgTpye = msgTpye;
        this.infoHeadUrl = infoHeadUrl;
        this.infoName = infoName;
        this.content = content;
        this.imgUrl = imgUrl;
        this.time = time;
    }

    public int getSourceType() {
        return sourceType;
    }

    public void setSourceType(int sourceType) {
        this.sourceType = sourceType;
    }

    public String getInfoHeadUrl() {
        return infoHeadUrl;
    }

    public void setInfoHeadUrl(String infoHeadUrl) {
        this.infoHeadUrl = infoHeadUrl;
    }

    public String getInfoName() {
        return infoName;
    }

    public void setInfoName(String infoName) {
        this.infoName = infoName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getMsgTpye() {
        return msgTpye;
    }

    public void setMsgTpye(int msgTpye) {
        this.msgTpye = msgTpye;
    }
}



