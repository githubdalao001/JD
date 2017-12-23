package com.bwie.mytaobao.model;

import android.content.Context;

import com.bwie.mytaobao.netutils.NetUtils;

/**
 * Created by DELL on 2017/10/19.
 */

public class MyYijiLeiModel implements IYiJiLeiModel {
    @Override
    public String loadDataM(Context context, String path) {
        String s = NetUtils.homePagerGetData(context, path);
        return s;
    }

}
