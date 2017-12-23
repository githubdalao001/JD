package com.bwie.mytaobao.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.bwie.mytaobao.R;
import com.bwie.mytaobao.SearchActivity;
import com.bwie.mytaobao.adapter.HomePager_XlvAdapter;
import com.bwie.mytaobao.bean.XlvDataBean;
import com.bwie.mytaobao.presenter.MyXlvDataPresenter;
import com.bwie.mytaobao.utils.ViewUtils;
import com.bwie.mytaobao.view.IXlvDataView;
import com.limxing.xlistview.view.XListView;
import com.sunfusheng.marqueeview.MarqueeView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by DELL on 2017/9/29.
 */

public class HomePageFragment extends Fragment implements IXlvDataView{

    private XListView xlv;
    private View view;
    private MarqueeView homepager_taobaotoutiao_texttop,homepager_taobaotoutiao_textbom;
    private XlvDataBean.DataBean data;
    private List<String> subList,goodlist;
    private View myheadviewtoutiao;
    private View myheadviewGridView;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_homepage,null);
        //得到控件
        xlv = view.findViewById(R.id.HomePager_xlv);
        EditText editText = view.findViewById(R.id.homePager_ed_sousuo);
        subList = new ArrayList<String>();
        goodlist = new ArrayList<String>();

        //控件监听事件
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), SearchActivity.class));
            }
        });
        //添加Banner为头布局
        View myheadviewBanner = ViewUtils.XlvSetHeaderViewBanader(getActivity());
        xlv.addHeaderView(myheadviewBanner);
        //添加分类列表为头布局
        myheadviewGridView = ViewUtils.XlvSetheaderViewGridview(getActivity());
        xlv.addHeaderView(myheadviewGridView);
        //请求网络数据
        MyXlvDataPresenter myXlvDataPresenter = new MyXlvDataPresenter(getActivity(),this);
        myXlvDataPresenter.loadData();
        return this.view;
    }

    private void mySendMessager() {
        List<XlvDataBean.DataBean.SubjectsBean> subjects = data.getSubjects();
        for (int i = 0; i < subjects.size(); i++) {
            XlvDataBean.DataBean.SubjectsBean subjectsBean = subjects.get(i);
            subList.add(subjectsBean.getTitle());
            List<XlvDataBean.DataBean.SubjectsBean.GoodsListBeanX> goodsList = subjectsBean.getGoodsList();
            for (int j = 0; j < goodsList.size(); j++) {
                goodlist.add(goodsList.get(j).getGoods_name());
            }
        }
        homepager_taobaotoutiao_texttop = myheadviewGridView.findViewById(R.id.homepager_taobaotoutiao_texttop);
        homepager_taobaotoutiao_textbom = myheadviewGridView.findViewById(R.id.homepager_taobaotoutiao_textbom);
        homepager_taobaotoutiao_texttop.startWithList(subList);
        // 在代码里设置自己的动画
        homepager_taobaotoutiao_texttop.startWithList(subList, R.anim.anim_bottom_in, R.anim.anim_top_out);
        homepager_taobaotoutiao_textbom.startWithList(goodlist);
        // 在代码里设置自己的动画
        homepager_taobaotoutiao_textbom.startWithList(goodlist, R.anim.anim_bottom_in, R.anim.anim_top_out);
    }


    //设置数据
    @Override
    public void setData(XlvDataBean xlvDataBean) {
        if(xlv == null){
            Toast.makeText(getActivity(), "xlv=null", Toast.LENGTH_SHORT).show();
            return;
        }else if(xlvDataBean == null){
            Toast.makeText(getActivity(), "没网啊啊啊啊啊啊！！！", Toast.LENGTH_SHORT).show();
            return;
        }else{
            data = xlvDataBean.getData();
            //设置数据
            mySendMessager();
            xlv.setAdapter(new HomePager_XlvAdapter(data,getActivity()));
        }
    }


}

