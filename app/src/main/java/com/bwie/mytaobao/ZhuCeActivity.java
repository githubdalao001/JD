package com.bwie.mytaobao;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.bwie.mytaobao.bean.LZUserInfoBean;
import com.bwie.mytaobao.utils.OKhttpUtils;
import com.bwie.mytaobao.utils.Utils;
import com.bwie.mytaobao.utils.WebSiteUtils;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


public class ZhuCeActivity extends AppCompatActivity{


    private EditText mZhanghaoZhuce;
    private EditText mMimaZhuce;
    private EditText mMimaZaiciZhuce;
    private EditText mYouxiangZhuce;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String str = (String) msg.obj;
            if(str != null){
                Gson gson  = new Gson();
                LZUserInfoBean lzUserInfoBean = gson.fromJson(str, LZUserInfoBean.class);
                if(lzUserInfoBean.getCode() == 200){
                    startActivity(new Intent(ZhuCeActivity.this,TaoLoginActivity.class));
                    finish();
                }else{
                    Toast.makeText(ZhuCeActivity.this, "注册失败", Toast.LENGTH_SHORT).show();
                }
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhu_ce);
        initView();

    }

    public void zhuce(View view){
        String zhuceWebsite = WebSiteUtils.ZHUCE_WEBSITE;
        String zhangHao = mZhanghaoZhuce.getText().toString();
        String mima = mMimaZhuce.getText().toString();
        String mima2 = mMimaZaiciZhuce.getText().toString();
        String youxiang = mYouxiangZhuce.getText().toString();
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("username",zhangHao);
        hashMap.put("password",mima);
        hashMap.put("password_confirm",mima2);
        hashMap.put("email",youxiang);
        hashMap.put("client","android");
        OKhttpUtils.getInstance().doPost(zhuceWebsite, hashMap, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(ZhuCeActivity.this, "注册失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Message msg = Message.obtain();
                msg.obj = response.body().string();
                handler.sendMessage(msg);
            }
        });
    }

    private void initView() {
        mZhanghaoZhuce = (EditText) findViewById(R.id.zhuce_zhanghao);
        mMimaZhuce = (EditText) findViewById(R.id.zhuce_mima);
        mMimaZaiciZhuce = (EditText) findViewById(R.id.zhuce_mima_zaici);
        mYouxiangZhuce = (EditText) findViewById(R.id.zhuce_youxiang);
    }


}
