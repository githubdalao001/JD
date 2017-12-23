package com.example.jdxm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.jdxm.adapter.ALAdapter;
import com.example.jdxm.base.BaseActivity;
import com.example.jdxm.bean.AddressBean;
import com.example.jdxm.presenter.APresenter;
import com.example.jdxm.view.IAVIew;

import java.util.List;

public class AddAddressActivity extends BaseActivity<APresenter> implements IAVIew, View.OnClickListener {

    private List<AddressBean.DataBean> data;
    private ListView mListAdd;
    private Button mButAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_address);
        initView();
        p.loadData();
    }

    private void initView() {
        mListAdd = (ListView) findViewById(R.id.add_list);
        mButAdd = (Button) findViewById(R.id.add_but);
        mButAdd.setOnClickListener(this);
    }

    @Override
    public void create() {
        p = new APresenter(this);
    }

    @Override
    public void setData(AddressBean addressBean) {
        data = addressBean.getData();
        if (data.size() == 0) {
            Toast.makeText(this, "还没有收货地址！！！", Toast.LENGTH_SHORT).show();
            return;
        }
        mListAdd.setAdapter(new ALAdapter(data,this));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_but:
                startActivity(new Intent(this,NewAddActivity.class));
                break;
            default:
                break;
        }
    }
}
