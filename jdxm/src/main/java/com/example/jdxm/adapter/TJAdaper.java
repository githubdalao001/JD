package com.example.jdxm.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.jdxm.InfoActivity;
import com.example.jdxm.R;
import com.example.jdxm.bean.HomeBean;
import com.example.jdxm.utils.ImageUtils;
import com.example.jdxm.utils.Utils;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

/**
 * Created by DELL on 2017/12/19.
 */

public class TJAdaper extends RecyclerView.Adapter<TJAdaper.MyHolder> {

    private Context context;
    private List<HomeBean.TuijianBean.ListBean> list;

    public TJAdaper(Context context, List<HomeBean.TuijianBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyHolder(View.inflate(context,R.layout.item_home_tuijian,null));
    }

    @Override
    public void onBindViewHolder(MyHolder holder, final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeBean.TuijianBean.ListBean listBean = list.get(position);
                EventBus.getDefault().postSticky(listBean);
                context.startActivity(new Intent(context, InfoActivity.class));
            }
        });
        String[] strings = Utils.splitStr(list.get(position).getImages());
        holder.text.setText(list.get(position).getTitle());
        ImageUtils.imageLoad(context,strings[0],holder.image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView text;
        public MyHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.home_item_image);
            text = itemView.findViewById(R.id.home_item_text);
        }
    }

}
