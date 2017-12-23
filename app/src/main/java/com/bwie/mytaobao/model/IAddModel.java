package com.bwie.mytaobao.model;

import okhttp3.Callback;
import rx.Observer;

/**
 * Created by DELL on 2017/11/10.
 */

public interface IAddModel {
    void loadData(String key, String true_name, String mob_phone, String city_id, String area_id, String address, String area_info , String is_default, Callback callback);
}
