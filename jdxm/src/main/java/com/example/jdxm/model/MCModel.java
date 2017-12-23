package com.example.jdxm.model;

import com.example.jdxm.bean.ShowCarBean;
import com.example.jdxm.retrofit.RetrofitUtils;
import com.example.jdxm.utils.StaticUtils;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by DELL on 2017/12/20.
 */

public class MCModel implements ICModel {
    @Override
    public void setObserver(Observer<ShowCarBean> observer) {
        int uid = 0;
        try {
            uid = StaticUtils.USER_INFO.getData().getUid();
        } catch (Exception e) {
            e.printStackTrace();
        }
        RetrofitUtils.getInstance().getAPI()
                .getSData(uid,StaticUtils.TOKEN)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(observer);
    }
}
