package com.example.jdxm.view;

import com.example.jdxm.bean.LoginBean;

/**
 * Created by DELL on 2017/12/19.
 */

public interface IDVIew {
    void setData(LoginBean loginBean);

    String getPas();
    String getName();
}
