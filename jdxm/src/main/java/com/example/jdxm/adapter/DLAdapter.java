package com.example.jdxm.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.jdxm.R;
import com.example.jdxm.bean.DDBean;

import java.util.List;

/**
 * Created by DELL on 2017/12/22.
 */

public class DLAdapter extends BaseAdapter {

    private int price;
    private List<DDBean> child;
    private Context context;

    public DLAdapter(List<DDBean> child, Context context) {
        this.child = child;
        this.context = context;
    }

    @Override
    public int getCount() {
        return child.size();
    }

    @Override
    public Object getItem(int position) {
        return child.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyHolder myHolder;
        if(convertView == null){
            convertView = View.inflate(context, R.layout.item_ding,null);
            myHolder = new MyHolder();
            myHolder.childCount = convertView.findViewById(R.id.childCount);
            myHolder.groupName = convertView.findViewById(R.id.groupName);
            myHolder.childName = convertView.findViewById(R.id.childName);
            myHolder.childPrice = convertView.findViewById(R.id.childPrice);
            convertView.setTag(myHolder);
        }else{
            myHolder = (MyHolder) convertView.getTag();
        }
        price += child.get(position).getList().getBargainPrice();
        myHolder.childPrice.setText("价格:"+child.get(position).getList().getBargainPrice()+"");
        myHolder.groupName.setText("商店名:"+child.get(position).getName());
        myHolder.childCount.setText("数量:"+child.get(position).getList().getNum()+"");
        myHolder.childName.setText("商品名:"+child.get(position).getList().getTitle());
        return convertView;
    }

    class MyHolder{
        TextView groupName;
        TextView childName;
        TextView childPrice;
        TextView childCount;
    }

    public int getPrice(){
        return price;
    };

}
