package com.bwie.mytaobao.model;

import android.content.Context;

import com.bwie.mytaobao.netutils.NetUtils;

/**
 * Created by DELL on 2017/10/20.
 */

public class MySanJiModel implements ISanjiModel {
    @Override
    public String loadDat(Context context, String path) {
        String s = NetUtils.homePagerGetData(context, path);
        return s;
    }
}
