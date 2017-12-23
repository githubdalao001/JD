package com.bwie.mytaobao;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
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

public class TaoLoginActivity extends AppCompatActivity {
    private boolean pwdisshow = false;
    private EditText tao_login_name,tao_login_pwd;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String str = (String) msg.obj;
            if(str != null){
                Gson gson  = new Gson();
                LZUserInfoBean lzUserInfoBean = gson.fromJson(str, LZUserInfoBean.class);
                System.out.println("我的淘宝key="+lzUserInfoBean.getDatas().getKey());
                if(lzUserInfoBean.getCode() == 200){
                    //存储数据
                    SharedPreferences sp = Utils.loginState(TaoLoginActivity.this);
                    sp.edit().putString("lzuserinfo",str).commit();
                    //更改强制进入注册界面的值
                    sp.edit().putBoolean("logintruefalse",false).commit();
                    startActivity(new Intent(TaoLoginActivity.this,MainActivity.class));
                    finish();
                }else{
                    Toast.makeText(TaoLoginActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
                }
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tao_login);
        Button button = (Button) findViewById(R.id.tao_login_showpwd);
        tao_login_name = (EditText) findViewById(R.id.tao_login_name);
        tao_login_pwd = (EditText) findViewById(R.id.tao_login_pwd);


        //是否显示密码
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pwdisshow){
                    tao_login_pwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    pwdisshow = false;
                }else{
                    tao_login_pwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    pwdisshow = true;
                }
            }
        });
    }

    public void tao_login_fan(View view){
        finish();
    }
    public void tao_login_login(View view){
        String zhuceWebsite = WebSiteUtils.DENGLU_WEBSITE;
        String zhangHao = tao_login_name.getText().toString();
        String mima = tao_login_pwd.getText().toString();
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("username",zhangHao);
        hashMap.put("password",mima);
        hashMap.put("client","android");
        OKhttpUtils.getInstance().doPost(zhuceWebsite, hashMap, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(TaoLoginActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Message msg = Message.obtain();
                msg.obj = string;
                handler.sendMessage(msg);
            }
        });
    }




}
