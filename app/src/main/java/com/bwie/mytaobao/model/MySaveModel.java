package com.bwie.mytaobao.model;

import com.bwie.mytaobao.bean.SaveBean;
import com.bwie.mytaobao.retorfit.RertofitUtils;
import com.bwie.mytaobao.utils.WebSiteUtils;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by DELL on 2017/11/17.
 */

public class MySaveModel implements ISaveModel {
    @Override
    public void setObSerVer(Observer<SaveBean> obSerVer) {
        RertofitUtils.getAPIService()
                .getSave(WebSiteUtils.lzUserInfoBean.getDatas().getKey())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(obSerVer);
    }
}
