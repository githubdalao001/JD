package com.bwie.mytaobao.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwie.mytaobao.R;
import com.bwie.mytaobao.bean.ZuJiBean;

import java.util.List;

/**
 * Created by DELL on 2017/11/16.
 */

public class ZuJiAdapter extends BaseAdapter {

    private Context context;
    private List<ZuJiBean.DatasBean.GoodsbrowseListBean> goodsbrowse_list;

    public ZuJiAdapter(Context context, List<ZuJiBean.DatasBean.GoodsbrowseListBean> goodsbrowse_list) {
        this.context = context;
        this.goodsbrowse_list = goodsbrowse_list;
    }

    @Override
    public int getCount() {
        return goodsbrowse_list.size();
    }

    @Override
    public Object getItem(int i) {
        return goodsbrowse_list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Holder holder;
        if(view == null){
            holder = new Holder();
            view = View.inflate(context, R.layout.zujiitem,null);
            holder.zuji_goods_image_url = view.findViewById(R.id.zuji_goods_image_url);
            holder.zuji_goods_name = view.findViewById(R.id.zuji_goods_name);
            holder.zuji_goods_promotion_price = view.findViewById(R.id.zuji_goods_promotion_price);
            view.setTag(holder);
        }else{
            holder = (Holder) view.getTag();
        }
        Glide.with(context).load(goodsbrowse_list.get(i).getGoods_image_url()).into(holder.zuji_goods_image_url);
        holder.zuji_goods_name.setText(goodsbrowse_list.get(i).getGoods_name());
        holder.zuji_goods_promotion_price.setText(goodsbrowse_list.get(i).getGoods_promotion_price());
        return view;
    }

    class Holder{
        ImageView zuji_goods_image_url;
        TextView zuji_goods_name;
        TextView zuji_goods_promotion_price;
    }

}
