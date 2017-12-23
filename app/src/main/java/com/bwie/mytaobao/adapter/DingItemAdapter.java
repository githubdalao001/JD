package com.bwie.mytaobao.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwie.mytaobao.R;
import com.bwie.mytaobao.bean.DingBean;

import java.util.List;

/**
 * Created by DELL on 2017/11/16.
 */

public class DingItemAdapter extends BaseAdapter {

    private Context context;
    private List<DingBean.DatasBean.OrderGroupListBean.OrderListBean.ExtendOrderGoodsBean> list;

    public DingItemAdapter(Context context, List<DingBean.DatasBean.OrderGroupListBean.OrderListBean.ExtendOrderGoodsBean> extend_order_goods) {
        this.context = context;
        this.list = extend_order_goods;
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
        Holder holder;
        if(view == null){
            holder = new Holder();
            view = View.inflate(context, R.layout.dingitem_goods,null);
            holder.ding_goods_image_url = view.findViewById(R.id.ding_goods_image_url);
            holder.ding_goods_name = view.findViewById(R.id.ding_goods_name);
            holder.ding_goods_price = view.findViewById(R.id.ding_goods_price);
            holder.ding_goods_sum = view.findViewById(R.id.ding_goods_sum);
            view.setTag(holder);
        }else{
            holder = (Holder) view.getTag();
        }

        holder.ding_goods_name.setText(list.get(i).getGoods_name());
        holder.ding_goods_price.setText(list.get(i).getGoods_price());
        holder.ding_goods_sum.setText(list.get(i).getGoods_num());
        Glide.with(context).load(list.get(i).getGoods_image_url()).into(holder.ding_goods_image_url);

        return view;
    }

    class Holder {
        private ImageView ding_goods_image_url;
        private TextView ding_goods_name;
        private TextView ding_goods_price;
        private TextView ding_goods_sum;
    }

}
