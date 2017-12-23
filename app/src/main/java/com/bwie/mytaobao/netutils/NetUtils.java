package com.bwie.mytaobao.netutils;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.widget.Toast;

import com.bwie.mytaobao.utils.Utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by DELL on 2017/10/11.
 */

public class NetUtils {



    //公用的get请求方法  完成的功能不确定
    public static String doGet(String path){
        try {
            URL url = new URL(path);
            HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
            httpConnection.setRequestMethod("GET");
            httpConnection.setConnectTimeout(5000);
            httpConnection.setReadTimeout(5000);

            if(httpConnection.getResponseCode() == 200){
                InputStream is = httpConnection.getInputStream();
                String dataStr = Utils.FromIOtoStr(is);
                return  dataStr;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String homePagerGetData(final Context context, String NetPath){
        String dataStr = "";
        try {
            URL url = new URL(NetPath);
            HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
            httpConnection.setRequestMethod("GET");
            httpConnection.setConnectTimeout(5000);
            httpConnection.setReadTimeout(5000);
            int responseCode = httpConnection.getResponseCode();
            if(responseCode == 200){
                InputStream is = httpConnection.getInputStream();
                dataStr = Utils.FromIOtoStr(is);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataStr;
    }


}
