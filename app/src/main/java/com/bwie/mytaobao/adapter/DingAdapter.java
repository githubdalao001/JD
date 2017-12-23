package com.bwie.mytaobao.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.bwie.mytaobao.R;
import com.bwie.mytaobao.bean.DingBean;
import com.bwie.mytaobao.myview.MyListView;

import java.util.List;

/**
 * Created by DELL on 2017/11/16.
 */

public class DingAdapter extends BaseAdapter{

    private List<DingBean.DatasBean.OrderGroupListBean> order_group_list;
    private Context context;

    public DingAdapter(List<DingBean.DatasBean.OrderGroupListBean> order_group_list, Context context) {
        this.order_group_list = order_group_list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return order_group_list.size();
    }

    @Override
    public Object getItem(int i) {
        return order_group_list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        DingBean.DatasBean.OrderGroupListBean orderGroupListBean = order_group_list.get(i);
        Holder holder;
        if (view == null) {
            holder = new Holder();
            view = View.inflate(context, R.layout.dingitem, null);
            holder.ding_zaixian = view.findViewById(R.id.ding_zaixian);
            holder.ding_pay_anount = view.findViewById(R.id.ding_pay_anount);
            holder.ding_state_desc = view.findViewById(R.id.ding_state_desc);
            holder.ding_order_sn =  view.findViewById(R.id.ding_order_sn);
            holder.ding_store_name = view.findViewById(R.id.ding_store_name);
            holder.ding_order_goods =  view.findViewById(R.id.ding_order_goods);
            view.setTag(holder);
        }else{
            holder = (Holder) view.getTag();
        }

        holder.ding_zaixian.setText("在线支付金额:");
        holder.ding_pay_anount.setText(orderGroupListBean.getPay_amount()+"");
        holder.ding_order_sn.setText(orderGroupListBean.getPay_sn());
        holder.ding_store_name.setText(orderGroupListBean.getOrder_list().get(0).getStore_name());
        holder.ding_state_desc.setText(orderGroupListBean.getOrder_list().get(0).getState_desc());
        List<DingBean.DatasBean.OrderGroupListBean.OrderListBean.ExtendOrderGoodsBean> extend_order_goods = orderGroupListBean.getOrder_list().get(0).getExtend_order_goods();
        holder.ding_order_goods.setAdapter(new DingItemAdapter(context,extend_order_goods));
        return view;
    }

    class Holder {
        private TextView ding_zaixian;
        private TextView ding_pay_anount;
        private Button ding_state_desc;
        private TextView ding_order_sn;
        private TextView ding_store_name;
        private MyListView ding_order_goods;
    }

}
