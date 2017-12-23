package com.bwie.mytaobao;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import com.bwie.mytaobao.adapter.MyShouHuoAdapter;
import com.bwie.mytaobao.bean.EventBusMessage;
import com.bwie.mytaobao.bean.EventMessage;
import com.bwie.mytaobao.bean.ShouHuoBean;
import com.bwie.mytaobao.presenter.MyShouHuoPresnter;
import com.bwie.mytaobao.view.IShouHuoView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

public class SheZhiActivity extends AppCompatActivity implements IShouHuoView{

    private ListView mLv;
    private MyShouHuoPresnter myShouHuoPresnter;
    private List<ShouHuoBean.DatasBean.AddressListBean> newaddress_list;
    private MyShouHuoAdapter myShouHuoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_she_zhi);
        initView();
        myShouHuoPresnter = new MyShouHuoPresnter(this);
        myShouHuoPresnter.loadData();
        EventBus.getDefault().register(this);
    }


    private void initView() {
        mLv = (ListView) findViewById(R.id.lv);
    }
    //添加新的收货地址
    public void addDizhi(View view){
        startActivityForResult(new Intent(SheZhiActivity.this,AddAddressActivity.class),147);
    }
    //显示数据
    @Override
    public void setList(List<ShouHuoBean.DatasBean.AddressListBean> address_list) {
        newaddress_list = address_list;
        myShouHuoAdapter = new MyShouHuoAdapter(newaddress_list, SheZhiActivity.this);
        mLv.setAdapter(myShouHuoAdapter);
    }

    //EventBus的回调方法
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getDeleteAddressId(EventBusMessage eventBusMessage){
        if(eventBusMessage.isFlag()){
            newaddress_list.remove(eventBusMessage.getPosition());
            myShouHuoAdapter.notifyDataSetChanged();
        }
    }
    //回调方法
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        myShouHuoPresnter.loadData();
    }
    //销毁方法
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        myShouHuoPresnter.deTouch();
    }
}
