package com.java.code.Model;

//公司表
public class Company {
    //公司id
    private int id;
    //公司名
    private String name;
    //地址
    private String address;
    //联系电话
    private String phone;
    //电子邮箱
    private String email;
    //公司性质
    private String nature;
    //公司介绍
    private String intro;

    public Company() {
    }

    public Company(String name, String address, String phone, String email, String nature, String intro) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.nature = nature;
        this.intro = intro;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", nature='" + nature + '\'' +
                ", intro='" + intro + '\'' +
                '}';
    }
}

