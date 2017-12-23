package com.bwie.mytaobao.presenter;

import com.bwie.mytaobao.bean.SaveBean;
import com.bwie.mytaobao.model.ISaveModel;
import com.bwie.mytaobao.model.MySaveModel;
import com.bwie.mytaobao.view.ISaceView;

import java.util.List;

import rx.Observer;

/**
 * Created by DELL on 2017/11/17.
 */

public class MySavePresenter implements IPresenter {

    private ISaveModel iSaveModel;
    private ISaceView iSaceView;

    public MySavePresenter(ISaceView iSaceView) {
        iSaveModel = new MySaveModel();
        this.iSaceView = iSaceView;
    }

    //删除
    public void deleteItem(){

    }

    //加载数据
    public void loadData(){
        iSaveModel.setObSerVer(new Observer<SaveBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(SaveBean saveBean) {
                List<SaveBean.DatasBean.FavoritesListBean> favorites_list = saveBean.getDatas().getFavorites_list();
                iSaceView.setData(favorites_list);
            }
        });
    }

    @Override
    public void deTouch() {
        iSaceView = null;
    }
}
