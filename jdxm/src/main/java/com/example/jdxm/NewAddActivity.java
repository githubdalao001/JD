package com.example.jdxm;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jdxm.base.BaseActivity;
import com.example.jdxm.bean.NewAddBean;
import com.example.jdxm.presenter.NPresenter;
import com.example.jdxm.view.INVIew;

public class NewAddActivity extends BaseActivity<NPresenter> implements INVIew, View.OnClickListener {

    private EditText mName;
    private EditText mAddress;
    private EditText mMobie;
    private Button mAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_add);
        initView();
    }

    private void initView() {
        mName = (EditText) findViewById(R.id.name);
        mAddress = (EditText) findViewById(R.id.address);
        mMobie = (EditText) findViewById(R.id.mobie);
        mAdd = (Button) findViewById(R.id.add);
        mAdd.setOnClickListener(this);
    }

    @Override
    public void create() {
        p = new NPresenter(this);
    }

    @Override
    public void setData(NewAddBean newAddBean) {
        if ("0".equals(newAddBean.getCode())) {
            Toast.makeText(this, "添加成功", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    @Override
    public String getName() {
        return mName.getText().toString()==null?"":mName.getText().toString();
    }

    @Override
    public String getAdd() {
        return mAddress.getText().toString()==null?"":mAddress.getText().toString();
    }

    @Override
    public String getMobie() {
        return mMobie.getText().toString()==null?"":mMobie.getText().toString();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add:
                p.loadData();
                break;
            default:
                break;
        }
    }
}
