package com.example.jdxm.bean;

import java.util.List;

/**
 * Created by DELL on 2017/12/22.
 */

public class DDBean {
    private String name;
    private ShowCarBean.DataBean.ListBean list;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ShowCarBean.DataBean.ListBean getList() {
        return list;
    }

    public void setList(ShowCarBean.DataBean.ListBean list) {
        this.list = list;
    }

    public DDBean(String name, ShowCarBean.DataBean.ListBean list) {
        this.name = name;
        this.list = list;
    }
}
