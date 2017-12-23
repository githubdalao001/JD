package com.bwie.mytaobao.view;

import com.bwie.mytaobao.bean.ZuJiBean;

import java.util.List;

/**
 * Created by DELL on 2017/11/9.
 */

public interface IMySelfeView {
    void showUserInfo(int url,String name);
    void shezhiOnClick(Class a);
    void setZuJiData(List<ZuJiBean.DatasBean.GoodsbrowseListBean> goodsbrowse_list );
}
