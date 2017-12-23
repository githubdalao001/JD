package com.bwie.mytaobao.retorfit;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by DELL on 2017/11/10.
 */

public class RertofitUtils {
    public static APIServier getAPIService(){

        //添加日志拦截器
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.i("aaa", "message====" + message);
            }
        });
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        OkHttpClient build = builder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Log.i("zzz", "request====" + request.headers().toString());
                okhttp3.Response proceed = chain.proceed(request);
                Log.i("zzz", "proceed====" + proceed.headers().toString());
                return proceed;
            }
        }).addInterceptor(httpLoggingInterceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(build)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(ComURl.CITY_BASE_URL)
                .build();
        APIServier apiServier = retrofit.create(APIServier.class);
        return apiServier;
    }
}
