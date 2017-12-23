package com.bwie.mytaobao.model;

import android.content.Context;

import com.bwie.mytaobao.netutils.NetUtils;

/**
 * Created by DELL on 2017/10/13.
 */

public class MyWitchModel implements IWitchModel {
    @Override
    public String loadNewData(final Context context, String url) {
        String str = NetUtils.doGet(url);
        return str;
    }
}
