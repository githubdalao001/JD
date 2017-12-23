package com.example.jdxm.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jdxm.R;
import com.example.jdxm.adapter.TJAdaper;
import com.example.jdxm.base.BaseFragment;
import com.example.jdxm.bean.HomeBean;
import com.example.jdxm.presenter.HPresenter;
import com.example.jdxm.view.IHView;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment<HPresenter> implements IHView {

    private Banner mBannerHome;
    private RecyclerView mRvMiaoshaHome;
    private RecyclerView mRvTuijianHome;
    private List<HomeBean.DataBean> data;
    private HomeBean.TuijianBean tuijian;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initView(view);
        //调用p层加载数据
        p.loadData();
        return view;
    }

    private void initView(View itemView) {
        mBannerHome = (Banner) itemView.findViewById(R.id.home_banner);
        mRvMiaoshaHome = (RecyclerView) itemView.findViewById(R.id.home_rv_miaosha);
        mRvTuijianHome = (RecyclerView) itemView.findViewById(R.id.home_rv_tuijian);
    }

    @Override
    public void create() {
        p = new HPresenter(this);
    }

    //V层的方法
    @Override
    public void setData(HomeBean homeBean) {
        data = homeBean.getData();
        HomeBean.MiaoshaBean miaosha = homeBean.getMiaosha();
        tuijian = homeBean.getTuijian();
        //banner轮播方法
        bannerLodaData();
        mRvTuijianHome.setLayoutManager(new GridLayoutManager(getActivity(),2));
        mRvTuijianHome.setAdapter(new TJAdaper(getActivity(),tuijian.getList()));
    }
    //banner加载数据
    private void bannerLodaData(){
        String[] str = new String[data.size()];
        List<String> list = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            str[i] = data.get(i).getTitle();
            list.add(data.get(i).getIcon());
        }
        mBannerHome.isAutoPlay(true);
        mBannerHome.setDelayTime(3000);
        mBannerHome.setBannerTitle(str);
        mBannerHome.setImages(list);
        mBannerHome.setBannerStyle(Banner.CENTER);
    }
    //显示推荐数据
    private void showTJ(){
    }
}
