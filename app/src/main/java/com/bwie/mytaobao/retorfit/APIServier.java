package com.bwie.mytaobao.retorfit;

import com.bwie.mytaobao.bean.CityBean;
import com.bwie.mytaobao.bean.DeleteBean;
import com.bwie.mytaobao.bean.DingBean;
import com.bwie.mytaobao.bean.SaveBean;
import com.bwie.mytaobao.bean.ShouHuoBean;
import com.bwie.mytaobao.bean.UPDataBean;
import com.bwie.mytaobao.bean.ZuJiBean;

import java.util.Map;

import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by DELL on 2017/11/10.
 */

public interface APIServier {
    //城市的列表
    @POST("index.php?act=area&op=index")
    Observable<CityBean> getCityData(@Query("key") String key);
    //添加收货地址
    @POST("index.php?act=member_address&op=address_add")
    Observable<CityBean> insertShouHuo(@Query("key") String key, @Query("true_name") String true_name, @Query("mob_phone") String mob_phone, @Query("city_id") String city_id, @Query("area_id ") String area_id , @Query("address") String address, @Query("area_info") String area_info, @Query("is_default") String is_default);
    //收货地址列表
    @POST("index.php?act=member_address&op=address_list")
    Observable<ShouHuoBean> getShouHuo(@Query("key") String key);
    //删除收货地址
    @POST("index.php?act=member_address&op=address_del")
    Observable<DeleteBean> getDelete(@Query("key") String key , @Query("address_id") String address_id);

    @POST("index.php?act=member_address&op=address_edit")
    Observable<UPDataBean> getUoData(@QueryMap Map<String, String> map);

    @POST("index.php?act=member_order&op=order_list")
    Observable<DingBean> getDingDan(@Query("key") String key);

    //我的足迹
    @POST("index.php?act=member_goodsbrowse&op=browse_list&page=100")
    Observable<ZuJiBean> getZuJi(@Query("key") String key);

    //收藏
    @POST("index.php?act=member_favorites&op=favorites_list&page=100")
    Observable<SaveBean> getSave(@Query("key") String key);


}


