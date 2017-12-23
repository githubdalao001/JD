package com.example.jdxm.model;


import com.example.jdxm.bean.AddCarBean;
import com.example.jdxm.bean.InfoBean;

import java.util.Map;

import rx.Observer;

/**
 * Created by DELL on 2017/12/20.
 */

public interface IIModel {
    void setObservable(Observer<InfoBean> observable,int pid);
    void setCObserver(Observer<AddCarBean> observer, int pid);
}
