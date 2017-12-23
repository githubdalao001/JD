package com.example.jdxm.model;

import com.example.jdxm.bean.LoginBean;

import rx.Observer;

/**
 * Created by DELL on 2017/12/19.
 */

public interface IDModel {
    void setObserver(Observer<LoginBean> observer,String name,String pwd);
}
