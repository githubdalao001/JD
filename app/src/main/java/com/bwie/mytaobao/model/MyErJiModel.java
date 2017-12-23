package com.bwie.mytaobao.model;

import android.content.Context;

import com.bwie.mytaobao.netutils.NetUtils;

/**
 * Created by DELL on 2017/10/20.
 */

public class MyErJiModel implements IErJiModel{
    @Override
    public String loadData(Context context,String path) {
        String s = NetUtils.homePagerGetData(context, path);
        return s;
    }
}
