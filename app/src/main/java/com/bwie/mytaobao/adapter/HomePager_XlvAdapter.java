package com.bwie.mytaobao.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bwie.mytaobao.R;
import com.bwie.mytaobao.bean.XlvDataBean;
import com.bwie.mytaobao.utils.Utils;
import com.bwie.mytaobao.view.IXlvDataView;

import java.util.List;

/**
 * Created by DELL on 2017/10/10.
 */

public class HomePager_XlvAdapter extends BaseAdapter{

    private XlvDataBean.DataBean dataBean;
    private Context context;
    private final List<XlvDataBean.DataBean.SubjectsBean> subjects;
    public HomePager_XlvAdapter(XlvDataBean.DataBean dataBean, Context context) {
        this.dataBean = dataBean;
        this.context = context;
        subjects = dataBean.getSubjects();
    }

    @Override
    public int getCount() {
        return subjects.size();
    }

    @Override
    public Object getItem(int i) {
        return subjects.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        MyAdapter myAdapter;
        if(view == null){
            myAdapter = new MyAdapter();
            view = View.inflate(context, R.layout.homepager_xlistview_item,null);
            myAdapter.homepager_item_button = view.findViewById(R.id.homepager_item_button);
            myAdapter.homepager_item_image1 = view.findViewById(R.id.homepager_item_image1);
            myAdapter.homepager_item_gridview = view.findViewById(R.id.homepager_item_gridview);
            view.setTag(myAdapter);
        }else{
            myAdapter = (MyAdapter) view.getTag();
        }
        Utils.loadImageView(context,subjects.get(i).getImage(),myAdapter.homepager_item_image1);
        myAdapter.homepager_item_button.setText(subjects.get(i).getTitle());
        List<XlvDataBean.DataBean.SubjectsBean.GoodsListBeanX> goodsList = subjects.get(i).getGoodsList();
        myAdapter.homepager_item_gridview.setAdapter(new HomePager_XlvItem_Adapter(context,goodsList));
        return view;
    }

    class MyAdapter{
        Button homepager_item_button;
        ImageView homepager_item_image1;
        GridView homepager_item_gridview;
    }

}
