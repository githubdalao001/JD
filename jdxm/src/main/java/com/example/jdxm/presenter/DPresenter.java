package com.example.jdxm.presenter;

import com.example.jdxm.bean.LoginBean;
import com.example.jdxm.model.IDModel;
import com.example.jdxm.model.MLModel;
import com.example.jdxm.view.IDVIew;

import java.lang.ref.SoftReference;

import rx.Observer;

/**
 * Created by DELL on 2017/12/19.
 */

public class DPresenter implements IPresenter<IDVIew> {

    private SoftReference<IDVIew> softReference;
    private IDModel idModel;

    public DPresenter(IDVIew idvIew) {
        this.idModel = new MLModel();
        atTouch(idvIew);
    }

    public void loadData(){
        String name = softReference.get().getName();
        String pas = softReference.get().getPas();
        if(name == null || pas == null){
            return;
        }
        idModel.setObserver(new Observer<LoginBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(LoginBean loginBean) {
                softReference.get().setData(loginBean);
            }
        },name,pas);
    }

    @Override
    public void atTouch(IDVIew view) {
        softReference = new SoftReference<IDVIew>(view);
    }

    @Override
    public void deTouch() {
        softReference.clear();
    }
}
