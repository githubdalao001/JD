package com.bwie.mytaobao.model;

import com.bwie.mytaobao.retorfit.RertofitUtils;
import com.bwie.mytaobao.utils.WebSiteUtils;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by DELL on 2017/11/10.
 */

public class MyCityModel implements ICityModel {
    @Override
    public void setObSerVer(Observer obSerVer) {
        //得到存储在静态常量中的用户key传到网络请求方法中
        RertofitUtils.getAPIService().getCityData(WebSiteUtils.lzUserInfoBean.getDatas().getKey())
                //观察者在主线程
                .observeOn(AndroidSchedulers.mainThread())
                //被观察者在子线程
                .subscribeOn(Schedulers.io())
                //订阅观察者
                .subscribe(obSerVer);
    }
}
