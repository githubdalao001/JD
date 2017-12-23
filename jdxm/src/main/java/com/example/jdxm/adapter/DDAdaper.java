package com.example.jdxm.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.jdxm.R;
import com.example.jdxm.bean.DABean;

import java.util.List;

/**
 * Created by DELL on 2017/12/22.
 */

public class DDAdaper extends BaseAdapter {

    private List<DABean.DataBean> data;
    private Context context;

    public DDAdaper(List<DABean.DataBean> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Myholder myholder;
        if(convertView == null){
            myholder = new Myholder();
            convertView = View.inflate(context, R.layout.item_dd,null);
            myholder.name = convertView.findViewById(R.id.name);
            myholder.price = convertView.findViewById(R.id.price);
            myholder.tile = convertView.findViewById(R.id.time);
            convertView.setTag(myholder);
        }else{
            myholder = (Myholder) convertView.getTag();
        }
        myholder.tile.setText("时间:"+data.get(position).getCreatetime());
        myholder.name.setText("标题:"+data.get(position).getTitle());
        myholder.price.setText("价格:"+data.get(position).getPrice());
        return convertView;
    }

    class Myholder{
        TextView name;
        TextView tile;
        TextView price;
    }

}
