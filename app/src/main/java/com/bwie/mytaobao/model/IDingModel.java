package com.bwie.mytaobao.model;

import com.bwie.mytaobao.bean.DingBean;

import rx.Observer;

/**
 * Created by DELL on 2017/11/16.
 */

public interface IDingModel {
    void setObSerVer(Observer<DingBean> Observer);
}
