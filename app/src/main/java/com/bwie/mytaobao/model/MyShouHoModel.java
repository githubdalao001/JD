package com.bwie.mytaobao.model;

import com.bwie.mytaobao.retorfit.RertofitUtils;
import com.bwie.mytaobao.utils.WebSiteUtils;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by DELL on 2017/11/13.
 */

public class MyShouHoModel implements IShouHuoModel {

    private Subscription subscribe;

    @Override
    public void destory() {
        subscribe.unsubscribe();
    }

    @Override
    public void setObSerVer(Observer obSerVer) {
        subscribe = RertofitUtils.getAPIService()
                .getShouHuo(WebSiteUtils.lzUserInfoBean.getDatas().getKey())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(obSerVer);
    }
}
