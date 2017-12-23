package com.example.jdxm;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.jdxm.base.BaseActivity;
import com.example.jdxm.bean.LoginBean;
import com.example.jdxm.presenter.DPresenter;
import com.example.jdxm.utils.SPUtils;
import com.example.jdxm.utils.StaticUtils;
import com.example.jdxm.view.IDVIew;
import com.google.gson.Gson;

public class LoginActivity extends BaseActivity<DPresenter> implements View.OnClickListener , IDVIew {

    private EditText mNameLogin;
    private EditText mPwdLogin;
    private Button mLoginbtLogin;
    private Button mZhucebtLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    @Override
    public void create() {
        p = new DPresenter(this);
    }

    private void initView() {
        mNameLogin = (EditText) findViewById(R.id.login_name);
        mPwdLogin = (EditText) findViewById(R.id.login_pwd);
        mLoginbtLogin = (Button) findViewById(R.id.login_loginbt);
        mLoginbtLogin.setOnClickListener(this);
        mZhucebtLogin = (Button) findViewById(R.id.login_zhucebt);
        mZhucebtLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_loginbt:
                p.loadData();
                break;
            case R.id.login_zhucebt:
                startActivity(new Intent(LoginActivity.this,ZhuceActivity.class));
                break;
            default:
                break;
        }
    }

    @Override
    public void setData(LoginBean loginBean) {
        SharedPreferences saveUser = SPUtils.getSp("saveUser", this);
        String s = new Gson().toJson(loginBean);
        StaticUtils.USER_INFO = loginBean;
        saveUser.edit()
                .putString("userGson",s)
                .commit();
        finish();
    }

    @Override
    public String getPas() {
        return mPwdLogin.getText().toString()==null?"":mPwdLogin.getText().toString();
    }

    @Override
    public String getName() {
        return mNameLogin.getText().toString()==null?"":mNameLogin.getText().toString();
    }
}
