package com.example.jdxm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jdxm.adapter.DLAdapter;
import com.example.jdxm.bean.DDBean;
import com.example.jdxm.bean.DefaultAddBean;
import com.example.jdxm.utils.OKhttpUtils;
import com.example.jdxm.utils.StaticUtils;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class ReadDingActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mNameUser;
    private TextView mMobieUser;
    private TextView mAddressUser;
    private ListView mListview;
    private Button mTijiao;
    private DLAdapter dlAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_ding);
        initView();
        EventBus.getDefault().register(this);
        HashMap<String, String> map = new HashMap<>();
        map.put("uid", StaticUtils.USER_INFO.getData().getUid() + "");
        map.put("token", StaticUtils.TOKEN);
        OKhttpUtils.getInstance().doPost("https://www.zhaoapi.cn/user/getDefaultAddr", map, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                final String string = response.body().string();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Gson gson = new Gson();
                        DefaultAddBean dbean = gson.fromJson(string, DefaultAddBean.class);
                        mNameUser.setText("姓名:" + dbean.getData().getName());
                        mAddressUser.setText("地址:" + dbean.getData().getAddr());
                        mMobieUser.setText("电话:" + dbean.getData().getMobile() + "");
                    }
                });
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void EventMEthod(List<DDBean> child) {
        dlAdapter = new DLAdapter(child, ReadDingActivity.this);
        mListview.setAdapter(dlAdapter);
    }

    private void initView() {
        mNameUser = (TextView) findViewById(R.id.user_name);
        mMobieUser = (TextView) findViewById(R.id.user_mobie);
        mAddressUser = (TextView) findViewById(R.id.user_address);
        mListview = (ListView) findViewById(R.id.listview);
        mTijiao = (Button) findViewById(R.id.tijiao);
        mTijiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mTijiao.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tijiao:
                creatorder();
                break;
            default:
                break;
        }
    }

    private void creatorder() {
        HashMap<String ,String> map = new HashMap<>();
        map.put("uid",StaticUtils.USER_INFO.getData().getUid()+"");
        map.put("price",""+dlAdapter.getPrice());
        map.put("token",StaticUtils.TOKEN);
        OKhttpUtils.getInstance().doPost("https://www.zhaoapi.cn/product/createOrder", map, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Log.i("===", "onResponse: "+string);
            }
        });
    }
}
