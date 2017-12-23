package com.example.jdxm.model;

import com.example.jdxm.bean.NewAddBean;
import com.example.jdxm.retrofit.RetrofitUtils;

import java.util.Map;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by DELL on 2017/12/22.
 */

public class MNModel implements INModel {
    @Override
    public void setObserver(Observer<NewAddBean> observer, Map<String,String> map) {
        RetrofitUtils.getInstance().getAPI()
                .getNData(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
