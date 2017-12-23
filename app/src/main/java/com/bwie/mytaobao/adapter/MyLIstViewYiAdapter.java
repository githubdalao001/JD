package com.bwie.mytaobao.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.mytaobao.R;
import com.bwie.mytaobao.bean.YijiLeiBiaoBean;
import com.bwie.mytaobao.utils.Utils;
import com.bwie.mytaobao.utils.ViewUtils;

import java.util.List;

/**
 * Created by DELL on 2017/10/20.
 */

public class MyLIstViewYiAdapter extends BaseAdapter {
    private List<YijiLeiBiaoBean.DatasBean.ClassListBean> list;
    private Context context;

    public MyLIstViewYiAdapter(YijiLeiBiaoBean yijiLeiBiaoBean , Context context) {
        if(yijiLeiBiaoBean == null){
            return;
        }
        list = yijiLeiBiaoBean.getDatas().getClass_list();
        this.context = context;
    }

    @Override
    public int getCount() {
        return list==null?0:list.size();
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
            view = View.inflate(context,R.layout.mylistviewyi_item,null);
            holder.yiji_name = view.findViewById(R.id.yiji_name);
            holder.yiji_image = view.findViewById(R.id.yiji_image);
            view.setTag(holder);
        }else{
            holder = (Holder) view.getTag();
        }
        if(!list.get(i).getGc_name().trim().equals("")){
            holder.yiji_name.setText(list.get(i).getGc_name());
        }
        if(!list.get(i).getImage().trim().equals("")){
            Utils.loadImageView(context,list.get(i).getImage(),holder.yiji_image);
        }else{
            holder.yiji_image.setImageResource(R.mipmap.ic_launcher);
        }
        return view;
    }

    class Holder{
        TextView yiji_name;
        ImageView yiji_image;
    }

}
