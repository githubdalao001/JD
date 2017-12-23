package com.bwie.mytaobao.utils;

import java.util.HashMap;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * 1：类的用途
 * 2：@author 陈永昌
 * 3:@date 2017/10/12 13:05
 */

public class OKhttpUtils {

    //单例模式（恶汉）
    private static OKhttpUtils oKhttpUtils=new OKhttpUtils();
    private OKhttpUtils(){};
    public static OKhttpUtils getInstance(){
        return  oKhttpUtils;
    }

    private OkHttpClient client;
    private void initClient(){
        if(client==null){
            client=new OkHttpClient.Builder().build();
        }
    }

    public void GoGet(String url, Callback callback){
        initClient();
        Request request = new Request.Builder().url(url).build();
        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public void doPost(String url, HashMap<String,String> map,Callback callback)
    {
        initClient();
        FormBody.Builder builder = new FormBody.Builder();
        for (String key:map.keySet()){
            builder.add(key,map.get(key));
        }
        Request request = new Request.Builder().url(url).post(builder.build()).build();
        Call call = client.newCall(request);
        call.enqueue(callback);
    }



}
