package com.bwie.mytaobao.presenter;

import com.bwie.mytaobao.bean.CityBean;
import com.bwie.mytaobao.model.ICityModel;
import com.bwie.mytaobao.model.MyCityModel;
import com.bwie.mytaobao.view.ICityVIew;

import java.util.List;

import rx.Observer;

/**
 * Created by DELL on 2017/11/10.
 */

public class MyCityPresenter implements IPresenter {

    private ICityVIew iCityVIew;
    private ICityModel iCityModel;

    public MyCityPresenter(ICityVIew iCityVIew) {
        this.iCityVIew = iCityVIew;
        iCityModel = new MyCityModel();
    }

    public void loadData(){
        iCityModel.setObSerVer(new Observer<CityBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(CityBean o) {
                List<CityBean.DatasBean.AreaListBean> area_list = o.getDatas().getArea_list();
                iCityVIew.setData(area_list);

            }
        });
    }

    @Override
    public void deTouch() {
        iCityVIew = null;
    }
}
