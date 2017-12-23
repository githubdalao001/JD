package com.example.jdxm.presenter;

import android.util.Log;

import com.example.jdxm.bean.AddCarBean;
import com.example.jdxm.bean.InfoBean;
import com.example.jdxm.bean.LoginBean;
import com.example.jdxm.model.IIModel;
import com.example.jdxm.model.MIModel;
import com.example.jdxm.utils.StaticUtils;
import com.example.jdxm.view.IIView;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

import rx.Observer;

/**
 * Created by DELL on 2017/12/20.
 */

public class InPresenter implements IPresenter<IIView> {

    private SoftReference<IIView> softReference;
    private IIModel iiModel;

    public InPresenter(IIView iiView) {
        this.iiModel = new MIModel();
        atTouch(iiView);
    }

    public void loadData(){
        int pid = softReference.get().getPid();
        if(pid == 0){
            return;
        }
        iiModel.setObservable(new Observer<InfoBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.i("===", "onError: "+e);
            }

            @Override
            public void onNext(InfoBean infoBean) {
                softReference.get().setData(infoBean);
            }
        },pid);
    }

    public void loadCData(){
        int pid = softReference.get().getPid();
        if(pid == 0){
            return;
        }
        iiModel.setCObserver(new Observer<AddCarBean>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
                Log.i("===", "onError: 添加购物车"+e);
            }

            @Override
            public void onNext(AddCarBean addCarBean) {
                String code = addCarBean.getCode();
                if ("0".equals(code)) {
                    softReference.get().setCData();
                }else{
                    Log.i("===", "onNext: 添加失败,"+addCarBean.getMsg());
                }
            }
        },pid);
    }

    @Override
    public void atTouch(IIView view) {
        softReference = new SoftReference<IIView>(view);
    }

    @Override
    public void deTouch() {
        softReference.clear();
    }
}
