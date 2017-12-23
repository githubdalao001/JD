package com.bwie.mytaobao.presenter;

import android.widget.Toast;

import com.bwie.mytaobao.bean.UPDataBean;
import com.bwie.mytaobao.model.IUpModel;
import com.bwie.mytaobao.model.MyUpModel;
import com.bwie.mytaobao.utils.WebSiteUtils;
import com.bwie.mytaobao.view.IUPView;

import java.util.HashMap;
import java.util.Map;

import rx.Observer;

/**
 * Created by DELL on 2017/11/14.
 */

public class MyBianJIPresenter implements IPresenter {

    private IUPView iBianJIView;
    private IUpModel iUpModel;

    public MyBianJIPresenter(IUPView iBianJIView) {
        this.iBianJIView = iBianJIView;
        iUpModel = new MyUpModel();
    }

    public void loadData(){
        String key = WebSiteUtils.lzUserInfoBean.getDatas().getKey();
        String address = iBianJIView.getAddress();
        String areaId = iBianJIView.getAreaId();
        String areaInfo = iBianJIView.getAreaInfo();
        String cityId = iBianJIView.getCityId();
        String name = iBianJIView.getName();
        String phone = iBianJIView.getPhone();
        String addressId = iBianJIView.getAddressId();
        if("".equals(addressId.trim()) || null == addressId){
            return;
        }
        if("".equals(key.trim()) || null == key){
            return;
        }
        if("".equals(address.trim()) || null == address){
            return;
        }
        if("".equals(areaId.trim()) || null == areaId){
            return;
        }
        if("".equals(areaInfo.trim()) || null == areaInfo){
            return;
        }
        if("".equals(cityId.trim()) || null == cityId){
            return;
        }
        if("".equals(name.trim()) || null == name){
            return;
        }
        if("".equals(phone.trim()) || null == phone){
            return;
        }
        Map<String ,String> map = new HashMap<>();
        map.put("key",key);
        map.put("true_name",name);
        map.put("mob_phone",phone);
        map.put("city_id",cityId);
        map.put("area_id",areaId);
        map.put("address",address);
        map.put("area_info",areaInfo);
        map.put("is_default",1+"");
        map.put("address_id",addressId);
        iUpModel.setObSerVer(new Observer<UPDataBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                System.out.println("保存数据出错="+e);
            }

            @Override
            public void onNext(UPDataBean upDataBean) {
                if(upDataBean.getCode() == 200){
                    iBianJIView.setMessage("编辑成功");
                }else{
                    System.out.println(upDataBean.getDatas()+"asdasd");
                    iBianJIView.setMessage("编辑失败");
                }

            }
        },map);
    }

    @Override
    public void deTouch() {
        iBianJIView = null;
    }




}
