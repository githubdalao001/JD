package com.example.jdxm.model;

import com.example.jdxm.bean.HomeBean;

import rx.Observer;

/**
 * Created by DELL on 2017/12/18.
 */

public interface IHModel {
    void setObserver(Observer<HomeBean> observer);
}
