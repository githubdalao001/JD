package com.bwie.mytaobao;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void login_iamge_fan(View view){
        //返回
        setResult(120);
        finish();
    }

    public void login_login_login(View view){
        //登录界面
        startActivity(new Intent(LoginActivity.this,TaoLoginActivity.class));
    }

    public void login_newuser_zhuce(View view){
        //注册界面
        startActivity(new Intent(LoginActivity.this,ZhuCeActivity.class));
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            //返回
            setResult(120);
            finish();
        }
        return true;
    }
}
