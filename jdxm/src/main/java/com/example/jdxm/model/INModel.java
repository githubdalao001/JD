package com.example.jdxm.model;

import com.example.jdxm.bean.NewAddBean;

import java.util.Map;

import rx.Observer;

/**
 * Created by DELL on 2017/12/22.
 */

public interface INModel {
    void setObserver(Observer<NewAddBean> observer, Map<String,String> map);
}
