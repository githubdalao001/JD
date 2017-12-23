package com.bwie.mytaobao.model;

import com.bwie.mytaobao.bean.SaveBean;

import rx.Observer;

/**
 * Created by DELL on 2017/11/17.
 */

public interface ISaveModel {
    void setObSerVer(Observer<SaveBean> obSerVer);
}
