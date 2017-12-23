package com.example.jdxm.presenter;

import com.example.jdxm.bean.NewAddBean;
import com.example.jdxm.model.INModel;
import com.example.jdxm.model.MNModel;
import com.example.jdxm.utils.StaticUtils;
import com.example.jdxm.view.INVIew;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

import rx.Observer;

/**
 * Created by DELL on 2017/12/22.
 */

public class NPresenter implements IPresenter<INVIew> {

    private SoftReference<INVIew> softReference;
    private INModel inModel;

    public NPresenter(INVIew invIew) {
        inModel = new MNModel();
        atTouch(invIew);
    }

    public void loadData(){
        final INVIew invIew = softReference.get();
        Map<String,String> map = new HashMap<>();
        map.put("uid", StaticUtils.USER_INFO.getData().getUid()+"");
        map.put("addr",invIew.getAdd());
        map.put("mobile",invIew.getMobie());
        map.put("name",invIew.getName());
        map.put("token",StaticUtils.TOKEN);
        inModel.setObserver(new Observer<NewAddBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(NewAddBean newAddBean) {
                invIew.setData(newAddBean);
            }
        },map);
    }

    @Override
    public void atTouch(INVIew view) {
        softReference = new SoftReference<INVIew>(view);
    }

    @Override
    public void deTouch() {
        softReference.clear();
    }
}
