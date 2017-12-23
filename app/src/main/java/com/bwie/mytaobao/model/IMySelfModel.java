package com.bwie.mytaobao.model;

import com.bwie.mytaobao.bean.ZuJiBean;

import rx.Observer;

/**
 * Created by DELL on 2017/11/9.
 */

public interface IMySelfModel {
    String getUserName();
    int getUserImage();
    void setObserve(Observer<ZuJiBean> observe);
}
