package com.bwie.mytaobao.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.mytaobao.R;
import com.bwie.mytaobao.bean.XlvDataBean;
import com.bwie.mytaobao.utils.Utils;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by DELL on 2017/10/11.
 */

public class HomePager_XlvItem_Adapter extends BaseAdapter {

    private Context context;
    List<XlvDataBean.DataBean.SubjectsBean.GoodsListBeanX> goodsList;

    public HomePager_XlvItem_Adapter(Context context, List<XlvDataBean.DataBean.SubjectsBean.GoodsListBeanX> goodsList) {
        this.context = context;
        this.goodsList = goodsList;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Object getItem(int i) {
        return goodsList.get(i);
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
            view = View.inflate(context, R.layout.homepager_sxlistview_item_gridview , null);
            myAdapter.goods_name = view.findViewById(R.id.goods_name);
            myAdapter.goodsName = view.findViewById(R.id.goodsName);
            myAdapter.goodsImage = view.findViewById(R.id.goodsImage);
            view.setTag(myAdapter);
        }else{
            myAdapter = (MyAdapter) view.getTag();
        }
        XlvDataBean.DataBean.SubjectsBean.GoodsListBeanX goodsListBeanX = goodsList.get(i);
        Utils.loadImageView(context,goodsListBeanX.getGoodsImage(),myAdapter.goodsImage);
        myAdapter.goodsName.setText(goodsListBeanX.getGoodsName());
        myAdapter.goods_name.setText(goodsListBeanX.getGoods_name());
        return view;
    }

    class MyAdapter{
        TextView goods_name;
        TextView goodsName;
        ImageView goodsImage;
    }

}
