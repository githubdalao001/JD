package com.bwie.mytaobao.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bwie.mytaobao.R;
import com.bwie.mytaobao.bean.CityBean;

import java.util.List;

/**
 * Created by DELL on 2017/11/10.
 */

public class CityLVAdapter extends BaseAdapter {

    private Context context;

    public CityLVAdapter(Context context, List<CityBean.DatasBean.AreaListBean> area_list) {
        this.context = context;
        this.area_list = area_list;
    }

    private List<CityBean.DatasBean.AreaListBean> area_list;


    @Override
    public int getCount() {
        return area_list.size();
    }

    @Override
    public Object getItem(int i) {
        return area_list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Holder holder;
        if(view == null){
            View inflate = View.inflate(context, R.layout.citylv_item, null);
            view = inflate;
            holder = new Holder();
            holder.text = inflate.findViewById(R.id.city_name);
            view.setTag(holder);
        }else{
            holder = (Holder) view.getTag();
        }
        holder.text.setText(area_list.get(i).getArea_name());
        return view;
    }

    class Holder{
        TextView text;
    }

}
