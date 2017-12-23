package com.example.jdxm.presenter;

import com.example.jdxm.bean.ShowCarBean;
import com.example.jdxm.model.ICModel;
import com.example.jdxm.model.MCModel;
import com.example.jdxm.view.ISVIew;

import java.lang.ref.SoftReference;

import rx.Observer;

/**
 * Created by DELL on 2017/12/20.
 */

public class CPresenter implements IPresenter<ISVIew> {

    private SoftReference<ISVIew> softReference;
    private ICModel icModel;

    public CPresenter(ISVIew isvIew) {
        this.icModel = new MCModel();
        atTouch(isvIew);
    }

    public void loadData(){
        icModel.setObserver(new Observer<ShowCarBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(ShowCarBean showCarBean) {
                softReference.get().setData(showCarBean);
            }
        });
    }

    @Override
    public void atTouch(ISVIew view) {
        softReference = new SoftReference<ISVIew>(view);
    }

    @Override
    public void deTouch() {
        softReference.clear();
    }
}
