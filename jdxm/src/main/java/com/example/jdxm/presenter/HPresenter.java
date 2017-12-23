package com.example.jdxm.presenter;

import android.util.Log;

import com.example.jdxm.bean.HomeBean;
import com.example.jdxm.model.IHModel;
import com.example.jdxm.model.MHModel;
import com.example.jdxm.view.IHView;

import java.lang.ref.SoftReference;

import rx.Observer;

/**
 * Created by DELL on 2017/12/18.
 */

public class HPresenter implements IPresenter<IHView> {

    private IHModel ihModel;
    private SoftReference<IHView> softReference;

    public HPresenter(IHView ihView) {
        ihModel = new MHModel();
        atTouch(ihView);
    }

    public void loadData(){
        ihModel.setObserver(new Observer<HomeBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.i("===", "onError: "+e);
            }

            @Override
            public void onNext(HomeBean homeBean) {
                Log.i("+++", "onNext: ");
                softReference.get().setData(homeBean);
            }
        });
    }

    @Override
    public void atTouch(IHView view) {
        softReference = new SoftReference<IHView>(view);
    }

    @Override
    public void deTouch() {
        softReference.clear();
    }
}
