package com.example.jdxm.model;

import com.example.jdxm.bean.LoginBean;
import com.example.jdxm.retrofit.RetrofitUtils;
import com.example.jdxm.utils.StaticUtils;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by DELL on 2017/12/19.
 */

public class MLModel implements IDModel {
    @Override
    public void setObserver(Observer<LoginBean> observer,String name,String pwd) {
        RetrofitUtils.getInstance().getAPI()
                .getLData(name,pwd, StaticUtils.TOKEN)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
