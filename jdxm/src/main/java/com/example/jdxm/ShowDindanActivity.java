package com.example.jdxm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.jdxm.adapter.DDAdaper;
import com.example.jdxm.bean.DABean;
import com.example.jdxm.utils.OKhttpUtils;
import com.example.jdxm.utils.StaticUtils;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class ShowDindanActivity extends AppCompatActivity {

    private ListView mListDing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_dindan);
        final HashMap<String, String> map = new HashMap<>();
        map.put("uid", StaticUtils.USER_INFO.getData().getUid() + "");
        map.put("token", StaticUtils.TOKEN);
        OKhttpUtils.getInstance().doPost("https://www.zhaoapi.cn/product/getOrders", map, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(final Call call, Response response) throws IOException {
                Gson gson = new Gson();
                final DABean daBean = gson.fromJson(response.body().string(), DABean.class);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        List<DABean.DataBean> data = daBean.getData();
                        mListDing.setAdapter(new DDAdaper(data,ShowDindanActivity.this));
                    }
                });
            }
        });
        initView();
    }

    private void initView() {
        mListDing = (ListView) findViewById(R.id.ding_list);
    }
}
