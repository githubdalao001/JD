package com.bwie.mytaobao;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.bwie.mytaobao.adapter.ZuJiAdapter;
import com.bwie.mytaobao.bean.ZuJiBean;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import retrofit2.http.POST;

public class ZuJiActivity extends AppCompatActivity {

    private ListView mLv;
    private List<ZuJiBean.DatasBean.GoodsbrowseListBean> goodsbrowse_list1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zu_ji);
        initView();
        EventBus.getDefault().register(this);
    }

    private void initView() {
        mLv = (ListView) findViewById(R.id.lv);
        mLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String goods_id = goodsbrowse_list1.get(i).getGoods_id();
                Intent intent = new Intent(ZuJiActivity.this,GoodInfoActivity.class);
                intent.putExtra("goods_id","goods_id="+goods_id);
                startActivity(intent);
            }
        });
    }
    //接收数据
    @Subscribe(threadMode = ThreadMode.MAIN , sticky = true)
    public void getData(List<ZuJiBean.DatasBean.GoodsbrowseListBean> goodsbrowse_list){
        goodsbrowse_list1 = goodsbrowse_list;
        mLv.setAdapter(new ZuJiAdapter(ZuJiActivity.this,goodsbrowse_list1));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
