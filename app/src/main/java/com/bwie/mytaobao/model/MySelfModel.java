package com.bwie.mytaobao.model;

import com.bwie.mytaobao.R;
import com.bwie.mytaobao.bean.ZuJiBean;
import com.bwie.mytaobao.retorfit.RertofitUtils;
import com.bwie.mytaobao.utils.WebSiteUtils;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by DELL on 2017/11/9.
 */

public class MySelfModel implements IMySelfModel {
    @Override
    public String getUserName() {
        if(null != WebSiteUtils.lzUserInfoBean){
            return WebSiteUtils.lzUserInfoBean.getDatas().getUsername();
        }
        return null;
    }

    @Override
    public int getUserImage() {
        return R.mipmap.uik_avatar_normal;
    }
    //我的足迹
    @Override
    public void setObserve(Observer<ZuJiBean> observe) {
        RertofitUtils.getAPIService()
                .getZuJi(WebSiteUtils.lzUserInfoBean.getDatas().getKey())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(observe);
    }
}
