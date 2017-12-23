package com.bwie.mytaobao.bean;

/**
 * Created by DELL on 2017/10/8.
 */

public class UserInfo {
    private String Name;
    private String Pwd;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPwd() {
        return Pwd;
    }

    public void setPwd(String pwd) {
        Pwd = pwd;
    }

    public UserInfo(String name, String pwd) {

        Name = name;
        Pwd = pwd;
    }
}
