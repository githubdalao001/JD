package com.example.jdxm.adapter;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.jdxm.R;
import com.example.jdxm.bean.AddressBean;
import com.example.jdxm.utils.OKhttpUtils;
import com.example.jdxm.utils.StaticUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by DELL on 2017/12/22.
 */

public class ALAdapter extends BaseAdapter {

    private List<AddressBean.DataBean> data;
    private Context content;
    private List<Boolean> list = new ArrayList<>();
    public ALAdapter(List<AddressBean.DataBean> data, Context content) {
        this.data = data;
        this.content = content;
        for (int i = 0; i < data.size(); i++) {
            if(data.get(i).getStatus() != 1){
                list.add(false);
            }else{
                list.add(true);
            }
        }
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        final MyHolder myHolder;
        if(convertView == null){
            myHolder = new MyHolder();
            convertView = View.inflate(content, R.layout.item_address,null);
            myHolder.user_name = convertView.findViewById(R.id.user_name);
            myHolder.user_address = convertView.findViewById(R.id.user_address);
            myHolder.user_mobie = convertView.findViewById(R.id.user_mobie);
            myHolder.checkBox = convertView.findViewById(R.id.user_delfalt);
            convertView.setTag(myHolder);
        }else{
            myHolder = (MyHolder) convertView.getTag();
        }
        myHolder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(myHolder.checkBox.isChecked()){
                    for (int i = 0; i < list.size(); i++) {
                        if (i == position){
                           list.set(i,true);
                        }else{
                            list.set(i,false);
                        }
                    }
                    HashMap<String,String> map = new HashMap<>();
                    map.put("uid", StaticUtils.USER_INFO.getData().getUid()+"");
                    map.put("addrid",data.get(position).getAddrid()+"");
                    OKhttpUtils.getInstance().doPost("https://www.zhaoapi.cn/user/setAddr", map, new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {

                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                        }
                    });
                    notifyDataSetChanged();
                }
            }
        });
        myHolder.user_name.setText(data.get(position).getName()+"");
        myHolder.user_address.setText(data.get(position).getAddr()+"");
        myHolder.user_mobie.setText(data.get(position).getMobile()+"");
        myHolder.checkBox.setChecked(list.get(position));
        return convertView;
    }

    class MyHolder{
        CheckBox checkBox;
        TextView user_name;
        TextView user_address;
        TextView user_mobie;
    }


}
