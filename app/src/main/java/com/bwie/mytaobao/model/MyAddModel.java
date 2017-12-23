package com.bwie.mytaobao.model;

import com.bwie.mytaobao.retorfit.RertofitUtils;
import com.bwie.mytaobao.utils.OKhttpUtils;
import com.bwie.mytaobao.utils.WebSiteUtils;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by DELL on 2017/11/10.
 */

public class MyAddModel implements IAddModel {

    @Override
    public void loadData(String key,String true_name,String mob_phone,String city_id,String area_id,String address,String area_info ,String is_default,Callback callback) {
        String url = WebSiteUtils.ADDSHOUHO_WEBSITE;
        HashMap<String ,String > map = new HashMap<String, String>();
        map.put("key", WebSiteUtils.lzUserInfoBean.getDatas().getKey());
        map.put("true_name" , true_name);
        map.put("mob_phone" , mob_phone);
        map.put("city_id" , "36");
        map.put("area_id" , area_id);
        map.put("address" , address);
        map.put("area_info" , area_info);
        map.put("is_default" , is_default);
        System.out.println("user="+WebSiteUtils.lzUserInfoBean.getDatas().getUsername());
        OKhttpUtils.getInstance().doPost(url, map, callback);
    }
}
