package com.bwie.mytaobao.presenter;

import com.bwie.mytaobao.bean.AddAddressBean;
import com.bwie.mytaobao.model.IAddModel;
import com.bwie.mytaobao.model.MyAddModel;
import com.bwie.mytaobao.utils.WebSiteUtils;
import com.bwie.mytaobao.view.IAddView;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import rx.Observer;

/**
 * Created by DELL on 2017/11/10.
 */

public class MyAddPresenter implements IPresenter {

    private IAddModel iAddModel;
    private IAddView iAddView;

    public MyAddPresenter(IAddView iAddView) {
        this.iAddView = iAddView;
        iAddModel = new MyAddModel();
    }

    public void loadData(){
        String address = iAddView.getAddress();
        String areaId = iAddView.getAreaId();
        String areaInfo = iAddView.getAreaInfo();
        String cityId = iAddView.getCityId();
        int isDefult = iAddView.getIsDefult();
        String name = iAddView.getName();
        String phone = iAddView.getPhone();
        if(null == address || address.trim().equals("")){
            return;
        }
        if(null == areaId || areaId.trim().equals("")){
            return;
        }
        if(null == areaInfo || areaInfo.trim().equals("")){
            return;
        }
        if(null == name || name.trim().equals("")){
            return;
        }
        if(null == phone || phone.trim().equals("")){
            return;
        }
        if(null == cityId || cityId.trim().equals("")){
            return;
        }
        //传进一个callback
        iAddModel.loadData(WebSiteUtils.lzUserInfoBean.getDatas().getKey(), name, phone, cityId,areaId, address, areaInfo, isDefult+"",new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(response.code() == 200){
                    System.out.println("请求结果+="+response.body().string());
                }
            }
        });
    }


    @Override
    public void deTouch() {
        iAddView = null;
    }
}
