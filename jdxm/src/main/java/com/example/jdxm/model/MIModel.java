package com.example.jdxm.model;

import android.util.Log;
import android.widget.Toast;

import com.example.jdxm.bean.AddCarBean;
import com.example.jdxm.bean.InfoBean;
import com.example.jdxm.retrofit.RetrofitUtils;
import com.example.jdxm.utils.StaticUtils;

import java.util.Map;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by DELL on 2017/12/20.
 */

public class MIModel implements IIModel {
    @Override
    public void setObservable(Observer<InfoBean> observable,int pid) {
        RetrofitUtils.getInstance().getAPI()
                .getIData(pid, StaticUtils.TOKEN)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(observable);
    }

    @Override
    public void setCObserver(Observer<AddCarBean> observer, int pid) {
        try {
            int uid = StaticUtils.USER_INFO.getData().getUid();
            RetrofitUtils.getInstance().getAPI()
                    .getCData(uid,pid,StaticUtils.TOKEN)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(observer);
        } catch (NullPointerException e){
            Log.i("===", "setCObserver: "+e);
        }
    }
}
