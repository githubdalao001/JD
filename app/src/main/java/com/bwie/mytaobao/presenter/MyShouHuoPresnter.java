package com.bwie.mytaobao.presenter;

import com.bwie.mytaobao.bean.ShouHuoBean;
import com.bwie.mytaobao.model.IShouHuoModel;
import com.bwie.mytaobao.model.MyShouHoModel;
import com.bwie.mytaobao.view.IShouHuoView;

import java.util.List;

import rx.Observer;

/**
 * Created by DELL on 2017/11/13.
 */

public class MyShouHuoPresnter implements IPresenter {

    private IShouHuoView iShouHuoView;
    private IShouHuoModel iShouHuoModel;

    public MyShouHuoPresnter(IShouHuoView iShouHuoView) {
        this.iShouHuoView = iShouHuoView;
        iShouHuoModel = new MyShouHoModel();
    }

    public void loadData(){
        iShouHuoModel.setObSerVer(new Observer<ShouHuoBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onNext(ShouHuoBean o) {
                List<ShouHuoBean.DatasBean.AddressListBean> address_list = o.getDatas().getAddress_list();
                iShouHuoView.setList(address_list);
            }
        });
    }

    @Override
    public void deTouch() {
        iShouHuoView = null;
        iShouHuoModel.destory();
    }
}
