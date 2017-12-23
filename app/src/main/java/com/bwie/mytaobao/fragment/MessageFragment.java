package com.bwie.mytaobao.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bwie.mytaobao.MyApp;
import com.bwie.mytaobao.R;
import com.bwie.mytaobao.rong.HomeFragment;
import com.bwie.mytaobao.rong.MsgFragment;

import java.util.ArrayList;
import java.util.List;

import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.UserInfo;

import static com.bwie.mytaobao.R.id.rg_bg;

/**
 * Created by DELL on 2017/9/29.
 */

public class MessageFragment extends Fragment implements RadioGroup.OnCheckedChangeListener {
    boolean flag=true;
    public List<Fragment> tabs = new ArrayList<>();
    public int filterPos = 0;
    private List<RadioButton> rbFilter;
    private RadioGroup rg_bg;
    private RadioButton rb1;
    private RadioButton rb2;
    private ViewPager vp;
    String yxpToken = "lkhZTn4mjwsc1OEUud2CUAT08Y22hncUGKj7XfSVQoVJf8NcsIyg6rC0ontuk1Da1g/TpY2EYjzjT4YJvd3BkA==";   //杨小胖
    String gssToken = "FSaTBWeG3lYQ4d6K+BJ07wT08Y22hncUGKj7XfSVQoVJf8NcsIyg6qSa9n/+4CPnqVPmKCVhdFHjT4YJvd3BkA==";
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.fragment_message,null);
        getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        init(view);
        initData();
        if (flag) {
            //获得连接  拿到Token身份授权 目前写死 真实开发从后台获取
            connect(yxpToken);
        } else {
            //获得连接
            connect(gssToken);
        }
        initViewPager();
        rg_bg.setOnCheckedChangeListener(this);
        rg_bg.check(R.id.rb1);
        return view;
    }

    private void init(View view) {
        vp = (ViewPager) view.findViewById(R.id.vp);
        rg_bg = (RadioGroup) view.findViewById(R.id.rg_bg);
        rb1 = (RadioButton) view.findViewById(R.id.rb1);
        rb2 = (RadioButton) view.findViewById(R.id.rb2);
    }
    private void connect(String token) {
        if (getActivity().getApplicationInfo().packageName.equals(MyApp.getCurProcessName(getActivity().getApplicationContext()))) {
            /**
             * IMKit SDK调用第二步,建立与服务器的连接
             */
            RongIM.connect(token, new RongIMClient.ConnectCallback() {
                /**
                 * Token 错误，在线上环境下主要是因为 Token 已经过期，您需要向 App Server 重新请求一个新的 Token
                 */
                @Override
                public void onTokenIncorrect() {
                    Log.i("xxx","Token失效");
                }
                @Override
                public void onSuccess(String userid) {
                    Log.i("xxx","连接成功！");
                    final UserInfo userInfo;
                    if (userid.equals("1")) {
                        Log.i("xxx", "userid:"+userid);
                        userInfo = new UserInfo(userid, "小明", Uri.parse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1509446525932&di=52e9333e6e1256f76773f6bced1a83d7&imgtype=0&src=http%3A%2F%2Fupload-images.jianshu.io%2Fupload_images%2F2846604-d998a5c20d992fff.png%3FimageMogr2%2Fauto-orient%2Fstrip%257CimageView2%2F2%2Fw%2F1240"));
                    } else {
                        Log.i("xxx", "userid:"+userid);
                        userInfo = new UserInfo(userid, "小红", Uri.parse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1509446419209&di=e3f5b831340f5bc8e952fa1577428730&imgtype=0&src=http%3A%2F%2Fimages.onccc.com%2Fi001%2F2014%2F09%2F27%2F22%2Fbig_bbfecfa203ce0aaf815e223d483d1c96.jpg"));
                    }
                    RongIM.getInstance().setCurrentUserInfo(userInfo);      //创建当前的用户实例
                    RongIM.getInstance().refreshUserInfoCache(userInfo);    //刷新用户缓存
                    RongIM.getInstance().setMessageAttachedUserInfo(true);  //消息与用户想关联
                    RongIM.getInstance().refreshUserInfoCache(userInfo);
                    RongIM.getInstance().setMessageAttachedUserInfo(true);
                    String name = userInfo.getName();
                    String currentUserId = RongIM.getInstance().getCurrentUserId();
                    Log.i("xxx", "currentUserId:"+currentUserId+",name:"+ name);
                }
                @Override
                public void onError(RongIMClient.ErrorCode errorCode) {
                    Log.i("xxx","连接失败 : "+errorCode.getMessage());
                }
            });
        }
    }

    private void initData() {
        if (flag) {
            rb1.setText("首页");
        } else {
            rb1.setText("通讯录");
        }
        rbFilter = new ArrayList<>();
        rbFilter.add(rb1);
        rbFilter.add(rb2);
        initeFilter(filterPos);
    }

    public void initeFilter(int pos) {
        for (int i = 0; i < rbFilter.size(); i++) {
            if (pos == i) {
                rbFilter.get(i).setChecked(true);
            } else {
                rbFilter.get(i).setChecked(false);
            }
        }
    }

    private void initViewPager() {
        HomeFragment homeFragment = new HomeFragment();
        tabs.add(homeFragment);
        MsgFragment msgFragment = new MsgFragment();
        tabs.add(msgFragment);

        MyViewPagerAdapter adapter = new MyViewPagerAdapter(getActivity().getSupportFragmentManager(), (ArrayList<Fragment>) tabs);
        vp.setAdapter(adapter);
        vp.setOffscreenPageLimit(2);
        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                filterPos = position;
                initeFilter(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    //RadioButton点击
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        int item = 0;
        switch (checkedId) {
            case R.id.rb1:
                item = 0;
                break;
            case R.id.rb2:
                item = 1;
        }
        vp.setCurrentItem(item);
    }
    //viewpager适配器
    private class MyViewPagerAdapter extends FragmentStatePagerAdapter {
        private ArrayList<Fragment> tabs;
        public MyViewPagerAdapter(FragmentManager fm, ArrayList<Fragment> tabs) {
            super(fm);
            this.tabs = tabs;
        }
        @Override
        public Fragment getItem(int position) {
            return tabs.get(position);
        }
        @Override
        public int getCount() {
            return tabs.size();
        }
    }

}
