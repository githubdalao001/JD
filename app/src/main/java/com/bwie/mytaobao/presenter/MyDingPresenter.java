package com.bwie.mytaobao.presenter;

import com.bwie.mytaobao.bean.DingBean;
import com.bwie.mytaobao.model.IDingModel;
import com.bwie.mytaobao.model.MyDingModel;
import com.bwie.mytaobao.view.IDIngVIew;

import java.util.List;

import rx.Observer;

/**
 * Created by DELL on 2017/11/16.
 */

public class MyDingPresenter implements IPresenter {

    private IDIngVIew idIngVIew;
    private IDingModel iDingModel;

    public MyDingPresenter(IDIngVIew idIngVIew) {
        this.idIngVIew = idIngVIew;
        iDingModel = new MyDingModel();
    }

    public void loadData(){
        iDingModel.setObSerVer(new Observer<DingBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(DingBean dingBean) {
                List<DingBean.DatasBean.OrderGroupListBean> order_group_list = dingBean.getDatas().getOrder_group_list();
                idIngVIew.setData(order_group_list);
            }
        });
    }

    @Override
    public void deTouch() {
        idIngVIew = null;
    }
}
