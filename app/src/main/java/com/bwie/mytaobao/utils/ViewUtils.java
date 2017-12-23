package com.bwie.mytaobao.utils;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.GridView;

import com.bwie.mytaobao.R;
import com.bwie.mytaobao.adapter.HomePager_GvAdapter;
import com.bwie.mytaobao.bean.GradBean;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 2017/10/13.
 */

public class ViewUtils {
    //初始化集合数据
    private static List<GradBean> initList(){
        List<GradBean> list = new ArrayList<>();
        list.add(new GradBean(R.mipmap.g1,"天猫"));
        list.add(new GradBean(R.mipmap.g2,"聚划算"));
        list.add(new GradBean(R.mipmap.g3,"天猫国际"));
        list.add(new GradBean(R.mipmap.g4,"外卖"));
        list.add(new GradBean(R.mipmap.g5,"天猫超时"));
        list.add(new GradBean(R.mipmap.g6,"充值中心"));
        list.add(new GradBean(R.mipmap.g7,"飞猪旅行"));
        list.add(new GradBean(R.mipmap.g8,"领金币"));
        list.add(new GradBean(R.mipmap.g9,"拍卖"));
        list.add(new GradBean(R.mipmap.g10,"分类"));
        return list;
    }
    //分类列表
    public static View XlvSetheaderViewGridview(Context context){
        List<GradBean> gradBeen = initList();
        View view = View.inflate(context, R.layout.homepager_gridview,null);
        GridView gridView = view.findViewById(R.id.mygridview);
        gridView.setAdapter(new HomePager_GvAdapter(context,gradBeen));
        return view;
    }

    //我的界面添加布局
//    public static View MySelfXlvAddHeadView(Context context){
//        View.inflate(context,)
//        return view;
//    }

    //轮播图
    public static View XlvSetHeaderViewBanader(Context context){
        List<String> bannerList = new ArrayList<>();
        bannerList.add("http://pic.58pic.com/58pic/14/34/62/39S58PIC9jV_1024.jpg");
        bannerList.add("http://img5.imgtn.bdimg.com/it/u=715064758,3888987881&fm=27&gp=0.jpg");
        bannerList.add("http://pic2.ooopic.com/12/09/64/46bOOOPICf5_1024.jpg");
        bannerList.add("http://pic2.ooopic.com/13/58/87/63bOOOPICb3_1024.jpg");
        View view = View.inflate(context, R.layout.homepager_banader,null);
        Banner banner = view.findViewById(R.id.mybanner);
        //自动轮播
        banner.isAutoPlay(true);
        //轮播时间间隔
        banner.setDelayTime(1000);
        //轮播图片
        banner.setImages(bannerList);
        //没有这行代码不能显示
        banner.setBannerStyle(Banner.ACCESSIBILITY_LIVE_REGION_ASSERTIVE);
        return view;
    }
}
