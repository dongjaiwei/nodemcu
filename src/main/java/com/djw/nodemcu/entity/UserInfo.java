package com.djw.nodemcu.entity;

public class UserInfo {
    private String userName;
    private String password;
    private String token;
    public UserInfo(String name, String pwd) {
        this.userName = name;
        this.password = pwd;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getToken() {
        return token;
    }
}
