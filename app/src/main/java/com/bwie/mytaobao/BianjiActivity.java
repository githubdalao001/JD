package com.bwie.mytaobao;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.MainThread;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.mytaobao.bean.DeleteBean;
import com.bwie.mytaobao.bean.EventBusMessage;
import com.bwie.mytaobao.bean.EventMessage;
import com.bwie.mytaobao.presenter.MyBianJIPresenter;
import com.bwie.mytaobao.retorfit.RertofitUtils;
import com.bwie.mytaobao.utils.WebSiteUtils;
import com.bwie.mytaobao.view.IUPView;
import com.lidroid.xutils.view.annotation.event.EventBase;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class BianjiActivity extends AppCompatActivity implements IUPView {

    private TextView mTextViewBianji;
    private EditText mNameTure;
    private EditText mPhoneTrue;
    private EditText mChengshiBianji;
    private EditText mJiedaoBianji;
    private EditText mXiangxiBianji;
    private String city_id;
    private String area_id;
    private String addressId;
    private MyBianJIPresenter myBianJIPresenter;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bianji);
        initView();
        EventBus.getDefault().register(this);
        myBianJIPresenter = new MyBianJIPresenter(this);

    }

    //点击删除按钮
    public void BianJiShanChu(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(BianjiActivity.this);
        builder.setMessage("确定删除吗?")
                .setNegativeButton("取消",null)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int a) {
                        shanchu();
                    }
                })
                .create()
                .show();
    }

    //删除方法
    private void shanchu() {
        String key = WebSiteUtils.lzUserInfoBean.getDatas().getKey();
        //调用删除方法得到被观察者
        RertofitUtils.getAPIService().getDelete(key, addressId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<DeleteBean>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(DeleteBean deleteBean) {
                        int code = deleteBean.getCode();
                        String datas = deleteBean.getDatas();
                        if (code == 200) {
                            EventBus.getDefault().post(new EventBusMessage(position,true));
                            finish();
                        }
                    }
                });
    }

    //点击返回按钮
    public void BianBack(View view){
        setResult(111);
        finish();
    }

    private void initView() {
        mTextViewBianji = (TextView) findViewById(R.id.Bianji_textView);
        mNameTure = (EditText) findViewById(R.id.ture_name);
        mPhoneTrue = (EditText) findViewById(R.id.true_phone);
        mChengshiBianji = (EditText) findViewById(R.id.bianji_chengshi);
        mJiedaoBianji = (EditText) findViewById(R.id.bianji_jiedao);
        mXiangxiBianji = (EditText) findViewById(R.id.bianji_xiangxi);
        mTextViewBianji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(BianjiActivity.this, "sss", Toast.LENGTH_SHORT).show();
                myBianJIPresenter.loadData();
            }
        });
    }

    //EventBus的接收粘性事件的方法 sticky = true接收粘性事件
    @Subscribe(threadMode = ThreadMode.MAIN , sticky = true)
    public void jieshouxiaoxi(EventBusMessage eventBusMessage){
        position = eventBusMessage.getPosition();
        city_id = eventBusMessage.getCity_id();
        area_id = eventBusMessage.getArea_id();
        addressId = eventBusMessage.getAddress_id();
        mNameTure.setText(eventBusMessage.getTrue_name());
        mPhoneTrue.setText(eventBusMessage.getMob_phone());
        mChengshiBianji.setText(eventBusMessage.getArea_info());
        mJiedaoBianji.setText(eventBusMessage.getAddress());
        mXiangxiBianji.setText(eventBusMessage.getArea_info()+eventBusMessage.getAddress());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        myBianJIPresenter.deTouch();
    }

    @Override
    public void setMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
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
        return city_id;
    }

    @Override
    public String getAreaId() {
        return area_id;
    }

    @Override
    public String getAddress() {
        return mJiedaoBianji.getText().toString();
    }

    @Override
    public String getAreaInfo() {
        return mChengshiBianji.getText().toString();
    }

    @Override
    public String getAddressId() {
        return addressId;
    }

}
