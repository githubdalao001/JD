package com.example.jdxm.bean;

/**
 * Created by DELL on 2017/12/20.
 */

public class GBean {
    private String name;
    private boolean check;

    public GBean(String name, boolean check) {
        this.name = name;
        this.check = check;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
}
