package com.bwie.mytaobao.presenter;

import com.bwie.mytaobao.SheZhiActivity;
import com.bwie.mytaobao.bean.ZuJiBean;
import com.bwie.mytaobao.model.IMySelfModel;
import com.bwie.mytaobao.model.MySelfModel;
import com.bwie.mytaobao.view.IMySelfeView;

import java.util.List;

import rx.Observer;

/**
 * Created by DELL on 2017/11/9.
 */

public class MySelfPresenter implements IPresenter {

    private IMySelfModel iMySelfModel;
    private IMySelfeView iMySelfeView;

    public MySelfPresenter(IMySelfeView iMySelfeView) {
        this.iMySelfeView = iMySelfeView;
        iMySelfModel = new MySelfModel();
    }
    //我的足迹
    public void showZuJi(){
        iMySelfModel.setObserve(new Observer<ZuJiBean>() {
            @Override
            public void onCompleted() {
            }
            @Override
            public void onError(Throwable e) {
            }
            @Override
            public void onNext(ZuJiBean zuJiBean) {
                List<ZuJiBean.DatasBean.GoodsbrowseListBean> goodsbrowse_list = zuJiBean.getDatas().getGoodsbrowse_list();
                iMySelfeView.setZuJiData(goodsbrowse_list );
            }
        });
    }

    //显示用户信息
    public void showUserInfo(){
        iMySelfeView.showUserInfo(iMySelfModel.getUserImage(),iMySelfModel.getUserName());
    }
    //点击设置按钮
    public void shezhiOnClick(){
        iMySelfeView.shezhiOnClick(SheZhiActivity.class);
    }
    @Override
    public void deTouch() {
        iMySelfeView=null;
    }
}
