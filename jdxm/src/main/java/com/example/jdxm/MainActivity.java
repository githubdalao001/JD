package com.example.jdxm;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.jdxm.bean.LoginBean;
import com.example.jdxm.fragments.FenFragment;
import com.example.jdxm.fragments.ShopCarFragment;
import com.example.jdxm.fragments.WodeFragment;
import com.example.jdxm.fragments.HomeFragment;
import com.example.jdxm.utils.SPUtils;
import com.example.jdxm.utils.StaticUtils;
import com.google.gson.Gson;
import com.hjm.bottomtabbar.BottomTabBar;

public class MainActivity extends AppCompatActivity {
    private BottomTabBar mb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences saveUser = SPUtils.getSp("saveUser",this);
        String userGson = saveUser.getString("userGson", "");
        if(!userGson .equals("")){
            Gson gson = new Gson();
            LoginBean loginBean = gson.fromJson(userGson, LoginBean.class);
            StaticUtils.USER_INFO = loginBean;
        }
        mb =(BottomTabBar)findViewById(R.id.bottom_tab_bar);
        mb.init(getSupportFragmentManager())
                .setImgSize(50,50)
                .setFontSize(8)
                .setTabPadding(4,6,10)
                .setChangeColor(Color.RED,Color.DKGRAY)
                .setDividerColor(Color.BLACK)
                .addTabItem("首页",R.mipmap.ic_launcher , R.mipmap.ic_launcher_round , HomeFragment.class)
                .addTabItem("分类",R.mipmap.ic_launcher, R.mipmap.ic_launcher_round , FenFragment.class)
                .addTabItem("购物车",R.mipmap.ic_launcher, R.mipmap.ic_launcher_round , ShopCarFragment.class)
                .addTabItem("我的",R.mipmap.ic_launcher, R.mipmap.ic_launcher_round , WodeFragment.class)
                .isShowDivider(false);
    }
}
