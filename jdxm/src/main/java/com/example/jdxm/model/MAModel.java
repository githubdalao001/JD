package com.example.jdxm.model;

import com.example.jdxm.bean.AddressBean;
import com.example.jdxm.retrofit.RetrofitUtils;
import com.example.jdxm.utils.StaticUtils;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by DELL on 2017/12/22.
 */

public class MAModel implements IAModel {
    @Override
    public void setObserver(Observer<AddressBean> o) {
        int uid = StaticUtils.USER_INFO.getData().getUid();
        RetrofitUtils.getInstance().getAPI()
                .getAData(uid,StaticUtils.TOKEN)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(o);
    }
}
