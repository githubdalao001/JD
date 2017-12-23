package com.bwie.mytaobao.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bwie.mytaobao.R;
import com.bwie.mytaobao.bean.SanJILeiBiaoBean;

import java.util.List;

/**
 * Created by DELL on 2017/10/20.
 */

public class MyGridViewSanAdapter extends BaseAdapter {

    private SanJILeiBiaoBean sanJILeiBiaoBean;
    private Context context;
    private final List<SanJILeiBiaoBean.DatasBean.ClassListBean> class_list;

    public MyGridViewSanAdapter(SanJILeiBiaoBean sanJILeiBiaoBean, Context context) {
        this.sanJILeiBiaoBean = sanJILeiBiaoBean;
        class_list = sanJILeiBiaoBean.getDatas().getClass_list();
        this.context = context;
    }

    @Override
    public int getCount() {
        return class_list.size();
    }

    @Override
    public Object getItem(int i) {
        return class_list.get(i);
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
            view = View.inflate(context, R.layout.mygridviewsan,null);
            holder.sanji_text = view.findViewById(R.id.sanji_text);
            view.setTag(holder);
        }else{
            holder = (Holder) view.getTag();
        }
        holder.sanji_text.setText(class_list.get(i).getGc_name());
        Log.i("xx",class_list.get(i).getGc_name());
        return view;
    }

    class Holder{
        TextView sanji_text;
    }

}
