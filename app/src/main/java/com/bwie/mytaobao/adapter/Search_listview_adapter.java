package com.bwie.mytaobao.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.mytaobao.R;
import com.bwie.mytaobao.bean.LaolishiBean;
import com.bwie.mytaobao.myview.MyViews;
import com.bwie.mytaobao.utils.Utils;

import java.util.List;

/**
 * Created by DELL on 2017/10/13.
 */

public class Search_listview_adapter extends BaseAdapter {
    private List<LaolishiBean.DatasBean.GoodsListBean> list;
    private Context context;

    public Search_listview_adapter(List<LaolishiBean.DatasBean.GoodsListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
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
            view = View.inflate(context, R.layout.witch_listview,null);
            myAdapter.iamge = view.findViewById(R.id.witch_image);
            myAdapter.witch_listview_goods_marketprice = view.findViewById(R.id.witch_listview_goods_marketprice);
            myAdapter.witch_listview_store_name = view.findViewById(R.id.witch_listview_store_name);
            myAdapter.witch_listview_goods_name = view.findViewById(R.id.witch_listview_goods_name);
            view.setTag(myAdapter);
        }else{
           myAdapter = (MyAdapter) view.getTag();
        }
        Utils.loadImageView(context,list.get(i).getGoods_image_url(),myAdapter.iamge);
        myAdapter.witch_listview_store_name.setText(list.get(i).getStore_name()+"进店");
        myAdapter.witch_listview_goods_marketprice.setText(list.get(i).getGoods_marketprice()+"  "+list.get(i).getIs_own_shop()+"付款");
        myAdapter.witch_listview_goods_name.setText(list.get(i).getGoods_name());
        return view;
    }

    class MyAdapter{
        ImageView iamge;
        TextView witch_listview_goods_name;
        TextView witch_listview_store_name;
        TextView witch_listview_goods_marketprice;
    }

}
