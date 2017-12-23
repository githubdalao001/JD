package com.bwie.mytaobao.model;

import com.bwie.mytaobao.bean.UPDataBean;
import com.bwie.mytaobao.retorfit.RertofitUtils;

import java.util.HashMap;
import java.util.Map;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by DELL on 2017/11/14.
 */

public class MyUpModel implements IUpModel {
    @Override
    public void setObSerVer(Observer<UPDataBean> obSerVer,Map<String,String> map) {
        RertofitUtils.getAPIService().getUoData(map)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(obSerVer);
    }
}
