package com.example.jdxm.model;

import com.example.jdxm.bean.AddressBean;

import rx.Observer;


/**
 * Created by DELL on 2017/12/22.
 */

public interface IAModel {
    void setObserver(Observer<AddressBean> o);
}
