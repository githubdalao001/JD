package com.bwie.mytaobao.model;

import android.content.Context;

import com.bwie.mytaobao.bean.XlvDataBean;
import com.bwie.mytaobao.view.IXlvDataView;

/**
 * Created by DELL on 2017/10/10.
 */

public interface IXlvDataModel {
    public String loadDataFromNet(Context context, String string);
}
