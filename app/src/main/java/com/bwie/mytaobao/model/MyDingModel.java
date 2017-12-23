package com.bwie.mytaobao.model;

import com.bwie.mytaobao.bean.DingBean;
import com.bwie.mytaobao.retorfit.RertofitUtils;
import com.bwie.mytaobao.utils.WebSiteUtils;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by DELL on 2017/11/16.
 */

public class MyDingModel implements IDingModel{
    @Override
    public void setObSerVer(Observer<DingBean> Observer) {
        RertofitUtils.getAPIService().getDingDan(WebSiteUtils.lzUserInfoBean.getDatas().getKey())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(Observer);
    }
}
