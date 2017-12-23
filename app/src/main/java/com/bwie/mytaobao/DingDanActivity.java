package com.bwie.mytaobao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.bwie.mytaobao.adapter.DingAdapter;
import com.bwie.mytaobao.bean.DingBean;
import com.bwie.mytaobao.presenter.MyDingPresenter;
import com.bwie.mytaobao.view.IDIngVIew;

import java.util.List;

public class DingDanActivity extends AppCompatActivity implements IDIngVIew {

    private ListView mLv;
    private MyDingPresenter myDingPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ding_dan);
        initView();
        myDingPresenter = new MyDingPresenter(this);
        myDingPresenter.loadData();
    }

    private void initView() {
        mLv = (ListView) findViewById(R.id.lv);
    }

    @Override
    public void setData( List<DingBean.DatasBean.OrderGroupListBean> order_group_list) {
        mLv.setAdapter(new DingAdapter(order_group_list,DingDanActivity.this));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myDingPresenter.deTouch();
    }
}
