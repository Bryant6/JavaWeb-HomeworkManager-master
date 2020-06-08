package com.java.code.Model;

public class User {
    private int id;
    private String username;
    private String password;
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
