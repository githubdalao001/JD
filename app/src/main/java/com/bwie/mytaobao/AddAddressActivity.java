package com.bwie.mytaobao;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.mytaobao.bean.EventMessage;
import com.bwie.mytaobao.presenter.MyAddPresenter;
import com.bwie.mytaobao.utils.OKhttpUtils;
import com.bwie.mytaobao.utils.WebSiteUtils;
import com.bwie.mytaobao.view.IAddView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class AddAddressActivity extends AppCompatActivity implements IAddView {

    private EditText mNameTure;
    private EditText mPhoneTrue;
    private EditText mChengshiAdd;
    private EditText mJiedaoAdd;
    private EditText mXiangxiAdd;
    private CheckBox mDefulatAdd;
    private String area_id;
    private String area_name;
    private MyAddPresenter myAddPresenter;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_address);
        initView();
        click();
        //注册EventBus
        EventBus.getDefault().register(this);
        //实例化P层
        myAddPresenter = new MyAddPresenter(this);

    }

    //让接收EventBus的方法再主线程中执行
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void showCity(EventMessage eventMessage) {
        area_id = eventMessage.getArea_id();
        area_name = eventMessage.getArea_name();
        Toast.makeText(this, area_id + "   " + area_name, Toast.LENGTH_SHORT).show();
        mChengshiAdd.setText(area_name);
    }

    //监听事件
    private void click() {
        mChengshiAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AddAddressActivity.this, CityActivity.class));
            }
        });
    }
    //返回上一级
    public void addBack(View view){
        setResult(258);
        finish();
    }
    //初始化控件
    private void initView() {
        mNameTure = (EditText) findViewById(R.id.ture_name);
        mPhoneTrue = (EditText) findViewById(R.id.true_phone);
        mChengshiAdd = (EditText) findViewById(R.id.add_chengshi);
        mJiedaoAdd = (EditText) findViewById(R.id.add_jiedao);
        mXiangxiAdd = (EditText) findViewById(R.id.add_xiangxi);
        mDefulatAdd = (CheckBox) findViewById(R.id.add_defulat);
        mTextView = (TextView) findViewById(R.id.textView);
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AddAddressActivity.this, "保存", Toast.LENGTH_SHORT).show();
                myAddPresenter.loadData();

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        myAddPresenter.deTouch();
    }

    @Override
    public String getName() {
        return mNameTure.getText().toString();
    }

    @Override
    public String getPhone() {
        return mPhoneTrue.getText().toString();
    }

    @Override
    public String getCityId() {
        return "36";
    }

    @Override
    public String getAreaId() {
        return area_id;
    }

    @Override
    public String getAddress() {
        return mJiedaoAdd.getText().toString();
    }

    @Override
    public String getAreaInfo() {
        return mXiangxiAdd.getText().toString();
    }

    @Override
    public int getIsDefult() {
        if(mDefulatAdd.isSelected()){
            return 1;
        }
        return 2;
    }
}
