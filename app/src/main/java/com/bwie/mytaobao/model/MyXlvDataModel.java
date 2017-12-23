package com.bwie.mytaobao.model;

import android.content.Context;

import com.bwie.mytaobao.netutils.NetUtils;

/**
 * Created by DELL on 2017/10/10.
 */

public class MyXlvDataModel implements IXlvDataModel{
    @Override
    public String loadDataFromNet(Context context,String string) {
        String s = NetUtils.homePagerGetData(context, string);
        return s;
    }
}
