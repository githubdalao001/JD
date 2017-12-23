package com.example.jdxm.retrofit;

import com.example.jdxm.utils.StaticUtils;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by DELL on 2017/12/18.
 */

public class RetrofitUtils {
    private RetrofitUtils(){};
    private static RetrofitUtils retrofitUtils;
    public static RetrofitUtils getInstance(){
        return retrofitUtils==null?new RetrofitUtils():retrofitUtils;
    }

    public API getAPI(){
        //设置拦截器
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();

        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(StaticUtils.BASE_URL)
                .client(okHttpClient)
                .build();
        return retrofit.create(API.class);
    }

}
