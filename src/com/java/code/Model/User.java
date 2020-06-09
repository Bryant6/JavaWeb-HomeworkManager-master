package com.java.code.Model;

public class User {
    //用户ID
    private int id;
    //用户名
    private String username;
    //密码
    private String password;
    //是否是管理员
    private int is_manager;

    public User() {
    }

    public User(String username, String password, int is_manager) {
        this.username = username;
        this.password = password;
        this.is_manager = is_manager;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIs_manager() {
        return is_manager;
    }

    public void setIs_manager(int is_manager) {
        this.is_manager = is_manager;
    }
}
