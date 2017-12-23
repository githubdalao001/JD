package com.bwie.mytaobao;

import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bwie.mytaobao.bean.EventMessage;
import com.bwie.mytaobao.bean.ImageMessage;
import com.bwie.mytaobao.bean.LZUserInfoBean;
import com.bwie.mytaobao.fragment.HomePageFragment;
import com.bwie.mytaobao.fragment.MessageFragment;
import com.bwie.mytaobao.fragment.MySelfFragment;
import com.bwie.mytaobao.fragment.ShppingCarFragment;
import com.bwie.mytaobao.fragment.WeiTaoFragment;
import com.bwie.mytaobao.transform.GlideCircleTransform;
import com.bwie.mytaobao.utils.Utils;
import com.bwie.mytaobao.utils.WebSiteUtils;
import com.google.gson.Gson;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import io.rong.eventbus.EventBus;

public class MainActivity extends AppCompatActivity {
    private RadioButton main_shouye,main_weitao,main_xiaoxi,main_gouwu,main_wode;
    private FragmentManager fm;
    private SharedPreferences sp;
    private MySelfFragment mySelfFragment;
    private ShppingCarFragment shppingCarFragment;
    private WeiTaoFragment weiTaoFragment;
    private MessageFragment messageFragment;
    private HomePageFragment homePageFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp = Utils.loginState(MainActivity.this);
        //登陆后的操作
        if(sp.getBoolean("logintruefalse",true) == false){
            Toast.makeText(this, "用户信息已赋值", Toast.LENGTH_SHORT).show();
            String lzuserinfo = sp.getString("lzuserinfo", "");
            Gson gson  = new Gson();
            LZUserInfoBean lzUserInfoBean = gson.fromJson(lzuserinfo, LZUserInfoBean.class);
            WebSiteUtils.lzUserInfoBean = lzUserInfoBean;
            System.out.println("userName="+lzUserInfoBean.getDatas().getUsername());
        }
        initFragment();
        initView();
        radioButtonClick();
    }
    //用来radioButton改变
    private void radioButtonIsno(int flag){
        switch (flag){
            case 0:
                main_shouye.setBackgroundResource(R.mipmap.zhuye_true);
                main_xiaoxi.setBackgroundResource(R.mipmap.xiaoxi_false);
                main_wode.setBackgroundResource(R.mipmap.wode_false);
                main_gouwu.setBackgroundResource(R.mipmap.gouwu_false);
                main_weitao.setBackgroundResource(R.mipmap.weitao_false);
                break;
            case 1:
                main_shouye.setBackgroundResource(R.mipmap.zhuye_false);
                main_xiaoxi.setBackgroundResource(R.mipmap.xiaoxi_false);
                main_wode.setBackgroundResource(R.mipmap.wode_false);
                main_gouwu.setBackgroundResource(R.mipmap.gouwu_false);
                main_weitao.setBackgroundResource(R.mipmap.weitao_true);
                break;
            case 2:
                main_shouye.setBackgroundResource(R.mipmap.zhuye_false);
                main_xiaoxi.setBackgroundResource(R.mipmap.xiaoxi_true);
                main_wode.setBackgroundResource(R.mipmap.wode_false);
                main_gouwu.setBackgroundResource(R.mipmap.gouwu_false);
                main_weitao.setBackgroundResource(R.mipmap.weitao_false);
                break;
            case 3:
                main_shouye.setBackgroundResource(R.mipmap.zhuye_false);
                main_xiaoxi.setBackgroundResource(R.mipmap.xiaoxi_false);
                main_wode.setBackgroundResource(R.mipmap.wode_false);
                main_gouwu.setBackgroundResource(R.mipmap.gouwu_true);
                main_weitao.setBackgroundResource(R.mipmap.weitao_false);
                break;
            case 4:
                main_shouye.setBackgroundResource(R.mipmap.zhuye_false);
                main_xiaoxi.setBackgroundResource(R.mipmap.xiaoxi_false);
                main_wode.setBackgroundResource(R.mipmap.wode_true);
                main_gouwu.setBackgroundResource(R.mipmap.gouwu_false);
                main_weitao.setBackgroundResource(R.mipmap.weitao_false);
                break;

        }
    }

    private void initFragment(){
        homePageFragment = new HomePageFragment();
        shppingCarFragment = new ShppingCarFragment();
        weiTaoFragment = new WeiTaoFragment();
        mySelfFragment = new MySelfFragment();
        messageFragment = new MessageFragment();
    }

    private void radioButtonClick() {
        main_shouye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(main_shouye.isChecked()){
                    radioButtonIsno(0);
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.main_fragmentcontainer,homePageFragment);
                    ft.commit();
                }
            }
        });
        main_gouwu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(main_gouwu.isChecked()){
                    if(sp.getBoolean("logintruefalse",true)){
                        //进入登录界面
                        startActivityForResult(new Intent(MainActivity.this,LoginActivity.class),110);
                    }
                    radioButtonIsno(3);
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.main_fragmentcontainer,shppingCarFragment);
                    ft.commit();
                }
            }
        });
        main_weitao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(main_weitao.isChecked()){
                    radioButtonIsno(1);
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.main_fragmentcontainer,weiTaoFragment);
                    ft.commit();
                }
            }
        });
        main_wode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(main_wode.isChecked()){
                    if(sp.getBoolean("logintruefalse",true)){
                        //进入登录界面
                        startActivityForResult(new Intent(MainActivity.this,LoginActivity.class),110);
                    }
                    radioButtonIsno(4);
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.main_fragmentcontainer,mySelfFragment);
                    ft.commit();
                }
            }
        });
        main_xiaoxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(main_xiaoxi.isChecked()){
                    if(sp.getBoolean("logintruefalse",true)){
                        //进入登录界面
                        startActivityForResult(new Intent(MainActivity.this,LoginActivity.class),110);
                    }
                    radioButtonIsno(2);
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.main_fragmentcontainer,messageFragment);
                    ft.commit();
                }
            }
        });
    }

    //初始化控件
    private void initView() {
        //得到控件
        main_shouye = (RadioButton) findViewById(R.id.main_shouye);
        main_weitao = (RadioButton) findViewById(R.id.main_weitao);
        main_xiaoxi = (RadioButton) findViewById(R.id.main_xiaoxi);
        main_gouwu = (RadioButton) findViewById(R.id.main_gouwu);
        main_wode = (RadioButton) findViewById(R.id.main_wode);
        //得到FramgentManager
        fm = getSupportFragmentManager();
        //开启事务
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.main_fragmentcontainer,new HomePageFragment());
        radioButtonIsno(0);
        //提交
        ft.commit();

    }

    //的到相册的图片的地址
    private String getUriPath(Uri uri) {
        String data = null;
        if (null == uri)
            return null;
        final String scheme = uri.getScheme();
        if (scheme == null)
            data = uri.getPath();
        else if (ContentResolver.SCHEME_FILE.equals(scheme)) {
            data = uri.getPath();
        } else if (ContentResolver.SCHEME_CONTENT.equals(scheme)) {
            Cursor cursor = getContentResolver().query(uri, new String[] { MediaStore.Images.ImageColumns.DATA }, null, null, null);
            if (null != cursor) {
                if (cursor.moveToFirst()) {
                    int index = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
                    if (index > -1) {
                        data = cursor.getString(index);
                    }
                }
                cursor.close();
            }
        }
        return data;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 110 && resultCode == 120) {
            //取消登录后默认回到首页
            radioButtonIsno(0);
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.main_fragmentcontainer,new HomePageFragment());
            ft.commit();
        }
        //拍照
        if(requestCode == 1){
            mySelfFragment.setImagePath(WebSiteUtils.MyPhotoPath);
        }
        //相册
        if(requestCode == 2){
            if(data != null){
                Uri uri = data.getData();
                if (uri != null) {
                    String path = getUriPath(uri);
                    try {
                        mySelfFragment.setImagePath(path);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    //退出的判断
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("确定要退出么?");
            builder.setPositiveButton("确定退出", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });
            builder.setNegativeButton("点错了,不退出",null);
            builder.create().show();
        }
        return true;
    }

}
