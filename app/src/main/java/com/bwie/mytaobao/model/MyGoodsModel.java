package com.bwie.mytaobao.model;

import android.content.Context;

import com.bwie.mytaobao.netutils.NetUtils;

/**
 * Created by DELL on 2017/10/17.
 */

public class MyGoodsModel implements IGoodsInfoModel {
    @Override
    public String LoadData(Context context, String url) {
        String s = NetUtils.homePagerGetData(context, url);
        return s;
    }

    @Override
    public void setObSerVer() {

    }
}
