package com.bwie.mytaobao.model;

import com.bwie.mytaobao.bean.UPDataBean;

import java.util.Map;

import rx.Observer;

/**
 * Created by DELL on 2017/11/14.
 */

public interface IUpModel {
    void setObSerVer(Observer<UPDataBean> obSerVer,Map<String,String> map);
}
