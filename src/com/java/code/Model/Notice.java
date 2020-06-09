package com.java.code.Model;

//公告表
public class Notice {
    //公告id
    private int id;
    //公告标题
    private String title;
    //公告发布时间
    private String sendtime;
    //所属人员
    private String sender;
    //公告内容
    private String content;

    public Notice() {
    }

    public Notice(String title, String sendtime, String sender, String content) {
        this.title = title;
        this.sendtime = sendtime;
        this.sender = sender;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSendtime() {
        return sendtime;
    }

    public void setSendtime(String sendtime) {
        this.sendtime = sendtime;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
