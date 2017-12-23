package com.example.jdxm.model;

import com.example.jdxm.bean.ShowCarBean;

import rx.Observer;

/**
 * Created by DELL on 2017/12/20.
 */

public interface ICModel {
    void setObserver(Observer<ShowCarBean> observer);
}
