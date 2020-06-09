package com.java.code.Model;

//会议表
public class Meeting {
    //会议id
    private int id;
    //会议标题
    private String title;
    //会议内容
    private String content;
    //会议地点
    private String address;
    //参会人员
    private String sender;
    //开始时间
    private String starttime;
    //结束时间
    private String endtime;

    public Meeting(){}

    public Meeting(String title, String content, String address, String sender, String starttime, String endtime) {
        this.title = title;
        this.content = content;
        this.address = address;
        this.sender = sender;
        this.starttime = starttime;
        this.endtime = endtime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }
}
