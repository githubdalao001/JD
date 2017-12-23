package com.example.jdxm.presenter;

import android.util.Log;

import com.example.jdxm.bean.AddressBean;
import com.example.jdxm.model.IAModel;
import com.example.jdxm.model.MAModel;
import com.example.jdxm.view.IAVIew;

import java.lang.ref.SoftReference;

import rx.Observer;

/**
 * Created by DELL on 2017/12/22.
 */

public class APresenter implements IPresenter<IAVIew> {

    private SoftReference<IAVIew> softReference;
    private IAModel iaModel;

    public void loadData(){
        iaModel.setObserver(new Observer<AddressBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.i("===", "onError: "+e);
            }

            @Override
            public void onNext(AddressBean addressBean) {
                softReference.get().setData(addressBean);
            }
        });
    }

    public APresenter(IAVIew iavIew) {
        this.iaModel = new MAModel();
        atTouch(iavIew);
    }

    @Override
    public void atTouch(IAVIew view) {
        softReference = new SoftReference<IAVIew>(view);
    }

    @Override
    public void deTouch() {
        softReference.clear();
    }
}
