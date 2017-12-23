package com.bwie.mytaobao.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.mytaobao.R;
import com.bwie.mytaobao.bean.GradBean;

import java.util.List;

/**
 * Created by DELL on 2017/10/12.
 */

public class HomePager_GvAdapter extends BaseAdapter {

    private Context context;
    private List<GradBean> list;

    public HomePager_GvAdapter(Context context, List<GradBean> list) {
        this.context = context;
        this.list = list;
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
        MyHolder myHolder;
        if(view == null){
            myHolder = new MyHolder();
            view = View.inflate(context, R.layout.homepager_gridview_item, null);
            myHolder.imageView = view.findViewById(R.id.homepager_gridview_item_image);
            myHolder.textview = view.findViewById(R.id.homepager_gridview_item_text);
            view.setTag(myHolder);
        }else{
            myHolder = (MyHolder) view.getTag();
        }
        myHolder.textview.setText(list.get(i).getTextContent());
        myHolder.imageView.setImageResource(list.get(i).getImageId());
        return view;
    }

    class MyHolder{
        ImageView imageView;
        TextView textview;
    }

}
