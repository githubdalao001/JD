package com.example.jdxm.retrofit;

import com.example.jdxm.bean.AddCarBean;
import com.example.jdxm.bean.AddressBean;
import com.example.jdxm.bean.HomeBean;
import com.example.jdxm.bean.InfoBean;
import com.example.jdxm.bean.LoginBean;
import com.example.jdxm.bean.NewAddBean;
import com.example.jdxm.bean.ShowCarBean;


import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by DELL on 2017/12/18.
 */

public interface API {
    //首页数据
    @GET("ad/getAd")
    Observable<HomeBean> getHData();
    //登录
    @POST("user/login")
    Observable<LoginBean> getLData(@Query("mobile") String mobile,@Query("password") String password,@Query("token") String token);
    //详情
    @POST("product/getProductDetail")
    Observable<InfoBean> getIData(@Query("pid") int pin , @Query("token") String token);
    //添加购物车
    @POST("product/addCart")
    Observable<AddCarBean> getCData(@Query("uid") int uid , @Query("pid") int pid,@Query("source") String token);
    //显示购物车
    @POST("product/getCarts")
    Observable<ShowCarBean> getSData(@Query("uid") int uid ,@Query("token") String token);
    //显示收货地址
    @POST("user/getAddrs")
    Observable<AddressBean> getAData(@Query("uid") int uid , @Query("token") String token);
    @POST("user/addAddr")
    Observable<NewAddBean> getNData(@QueryMap Map<String,String > map);
}
