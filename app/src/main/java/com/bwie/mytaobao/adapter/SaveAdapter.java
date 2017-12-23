package com.bwie.mytaobao.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwie.mytaobao.R;
import com.bwie.mytaobao.bean.SaveBean;

import java.util.List;

/**
 * Created by DELL on 2017/11/17.
 */

public class SaveAdapter extends BaseAdapter {

    private List<SaveBean.DatasBean.FavoritesListBean> favorites_list;
    private Context context;


    public SaveAdapter(List<SaveBean.DatasBean.FavoritesListBean> favorites_list, Context context) {
        this.favorites_list = favorites_list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return favorites_list.size();
    }

    @Override
    public Object getItem(int i) {
        return favorites_list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Holder holder;
        if (view == null) {
            holder = new Holder();
            view = View.inflate(context, R.layout.savaitem, null);
            holder.save_goods_image_url = view.findViewById(R.id.save_goods_image_url);
            holder.save_goods_name = view.findViewById(R.id.save_goods_name);
            holder.save_goods_price = view.findViewById(R.id.save_goods_price);
            view.setTag(holder);
        }else{
            holder = (Holder) view.getTag();
        }
        Glide.with(context).load(favorites_list.get(i).getGoods_image_url()).into(holder.save_goods_image_url);
        holder.save_goods_name.setText(favorites_list.get(i).getGoods_name());
        holder.save_goods_price.setText(favorites_list.get(i).getGoods_price());
        return view;
    }

    class Holder {
        private ImageView save_goods_image_url;
        private TextView save_goods_name;
        private TextView save_goods_price;
    }

}
