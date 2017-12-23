package com.example.jdxm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.jdxm.base.BaseActivity;
import com.example.jdxm.utils.OKhttpUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class ZhuceActivity extends BaseActivity implements View.OnClickListener {

    private EditText mNameZhuce;
    private EditText mPwdZhuce;
    private Button mZhucebtZhuce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuce);
        initView();
    }

    @Override
    public void create() {
    }

    private void initView() {
        mNameZhuce = (EditText) findViewById(R.id.zhuce_name);
        mPwdZhuce = (EditText) findViewById(R.id.zhuce_pwd);
        mZhucebtZhuce = (Button) findViewById(R.id.zhuce_zhucebt);
        mZhucebtZhuce.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.zhuce_zhucebt:
                new Thread(){
                    @Override
                    public void run() {
                        super.run();
                        HashMap<String,String> map = new HashMap<>();
                        map.put("mobile","13716533133");
                        map.put("password","1111111111");
                        map.put("token","android");
                        OKhttpUtils.getInstance().doPost("https://www.zhaoapi.cn/user/reg", map, new Callback() {
                            @Override
                            public void onFailure(Call call, IOException e) {
                                Log.i("===", "onFailure: "+e);
                            }

                            @Override
                            public void onResponse(Call call, Response response) throws IOException {
                                Log.i("===", "onResponse: "+response.body().string());
                            }
                        });
                    }
                }.start();
                break;
            default:
                break;
        }
    }
}
