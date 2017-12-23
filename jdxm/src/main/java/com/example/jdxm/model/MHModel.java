package com.example.jdxm.model;

import android.database.Observable;

import com.example.jdxm.bean.HomeBean;
import com.example.jdxm.retrofit.RetrofitUtils;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by DELL on 2017/12/18.
 */

public class MHModel implements IHModel {
    @Override
    public void setObserver(Observer<HomeBean> observer) {
        RetrofitUtils.getInstance().getAPI()
                .getHData()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(observer);
    }
}
