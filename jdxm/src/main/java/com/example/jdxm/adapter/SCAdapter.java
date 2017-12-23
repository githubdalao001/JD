package com.example.jdxm.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.jdxm.R;
import com.example.jdxm.base.EventMessageBean;
import com.example.jdxm.bean.DDBean;
import com.example.jdxm.bean.EventMessageFL;
import com.example.jdxm.bean.GBean;
import com.example.jdxm.bean.ShowCarBean;
import com.example.jdxm.utils.ImageUtils;
import com.example.jdxm.utils.OKhttpUtils;
import com.example.jdxm.utils.Utils;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 2017/12/20.
 */

public class SCAdapter extends BaseExpandableListAdapter {

    private List<GBean> groupNames;
    private List<List<ShowCarBean.DataBean.ListBean>> childGoods;
    private Context context;
    private int num;
    private int oldnum;

    public SCAdapter(List<GBean> groupNames, List<List<ShowCarBean.DataBean.ListBean>> childGoods, Context context) {
        this.groupNames = groupNames;
        this.childGoods = childGoods;
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return groupNames.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return childGoods.get(groupPosition).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupNames.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childGoods.get(groupPosition).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(final int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        GroupViewHolder groupViewHolder = null;
        final GBean gBean = groupNames.get(groupPosition);

        if (convertView == null) {
            convertView = View.inflate(context,R.layout.itme_group,null);
            groupViewHolder = new GroupViewHolder();
            groupViewHolder.mExpand1_CheckCart = (CheckBox) convertView.findViewById(R.id.cart_expand_1_check);
            groupViewHolder.mExpand1_ShopnameCart = (TextView) convertView.findViewById(R.id.cart_expand_1_shopname);
            groupViewHolder.mExpand1_BianjiCart = (TextView) convertView.findViewById(R.id.cart_expand_1_bianji);
            convertView.setTag(groupViewHolder);
        } else {
            groupViewHolder = (GroupViewHolder) convertView.getTag();
        }
        final GroupViewHolder groupViewHolder2 = groupViewHolder;
        groupViewHolder.mExpand1_ShopnameCart.setText(gBean.getName());
        final CheckBox checkBox = groupViewHolder.mExpand1_CheckCart;
        checkBox.setChecked(gBean.isCheck());

        //点击大哥的checkbox
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gBean.setCheck(checkBox.isChecked());
                selectAllChild(groupPosition,checkBox.isChecked());
                selectAll(selectAllGroup());
                EventBus.getDefault().post(getSum());
                notifyDataSetChanged();
            }
        });

        //点击编辑
        final TextView bainji = groupViewHolder.mExpand1_BianjiCart;
        bainji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bainji.getText().toString().equals("编辑")){
                    bainji.setText("取消");
                    changeChildView(groupPosition,true);
                }else{
                    bainji.setText("编辑");
                    changeChildView(groupPosition,false);
                }
                notifyDataSetChanged();
            }
        });

        return convertView;
    }

    private void selectAll(boolean b) {
        EventBus.getDefault().post(new EventMessageFL(b));
    }

    //选中当前大哥下的小弟
    private void selectAllChild(int groupPosition, boolean checked) {
        List<ShowCarBean.DataBean.ListBean> listBeans = childGoods.get(groupPosition);
        for (int i = 0; i < listBeans.size(); i++) {
            listBeans.get(i).setCheck(checked);
        }
    }
    //计算总价  总数
    private EventMessageBean getSum() {
        int sum = 0;
        int price = 0;
        for (int i = 0; i < groupNames.size(); i++) {
            List<ShowCarBean.DataBean.ListBean> listBeans = childGoods.get(i);
            for (int j = 0; j < listBeans.size(); j++) {
                if(listBeans.get(j).isCheck()){
                    sum += listBeans.get(j).getNum();
                    price += listBeans.get(j).getNum() * listBeans.get(j).getBargainPrice();
                }
            }
        }
        return new EventMessageBean(sum,price);
    }

    private boolean selectAllGroup() {
        for (int i = 0; i < groupNames.size(); i++) {
            if(!groupNames.get(i).isCheck()){
                return false;
            }
        }
        return true;
    }

    //控制更改二级类表的布局
    private void changeChildView(int i,boolean flag) {
        List<ShowCarBean.DataBean.ListBean> listBeans = childGoods.get(i);
        for (int j = 0; j < listBeans.size(); j++) {
            listBeans.get(j).setViewisshow(flag);
        }
    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildViewHolder childViewHolder = null;
        final ShowCarBean.DataBean.ListBean listBean = childGoods.get(groupPosition).get(childPosition);
        if (convertView == null) {
            convertView = View.inflate(context,R.layout.itme_child,null);
            childViewHolder = new ChildViewHolder();
            childViewHolder.mExpand2_CheckCart = (CheckBox) convertView.findViewById(R.id.cart_expand_2_check);
            childViewHolder.mExpand2_ImageCart = (ImageView) convertView.findViewById(R.id.cart_expand_2_image);
            childViewHolder.mExpand2_TitleCart = (TextView) convertView.findViewById(R.id.cart_expand_2_title);
            childViewHolder.mExpand2_PriceCart = (TextView) convertView.findViewById(R.id.cart_expand_2_price);
            childViewHolder.mExpand2_SalenumCart = (TextView) convertView.findViewById(R.id.cart_expand_2_salenum);
            childViewHolder.mExpand2_RelativeCart = (RelativeLayout) convertView.findViewById(R.id.cart_expand_2_relative);
            childViewHolder.mExpand2_AddCart = (Button) convertView.findViewById(R.id.cart_expand_2_add);
            childViewHolder.mExpand2_NumCart = (TextView) convertView.findViewById(R.id.cart_expand_2_num);
            childViewHolder.mExpand2_JianCart = (Button) convertView.findViewById(R.id.cart_expand_2_jian);
            childViewHolder.mExpand2_DelGoodCart = (Button) convertView.findViewById(R.id.cart_expand_2_del_good);
            childViewHolder.mExpand2_LinearCart = (LinearLayout) convertView.findViewById(R.id.cart_expand_2_linear);
            childViewHolder.mExpand2RelativeCart = (RelativeLayout) convertView.findViewById(R.id.cart_expand_2_relative);
            convertView.setTag(childViewHolder);
        } else {
            childViewHolder = (ChildViewHolder) convertView.getTag();
        }
        childViewHolder.mExpand2_CheckCart.setChecked(listBean.isCheck());
        String[] strings = Utils.splitStr(listBean.getImages());
        ImageUtils.imageLoad(context,strings[0],childViewHolder.mExpand2_ImageCart);
        childViewHolder.mExpand2_TitleCart.setText(listBean.getTitle());
        num = listBean.getNum();
        oldnum = num;
        final TextView mExpand2_salenumCart = childViewHolder.mExpand2_SalenumCart;
        mExpand2_salenumCart.setText("X " + num);
        childViewHolder.mExpand2_PriceCart.setText("¥" + listBean.getBargainPrice());
        childViewHolder.mExpand2_NumCart.setText(listBean.getNum()+"");
        //编辑选项
        if(listBean.isViewisshow()){
            childViewHolder.mExpand2RelativeCart.setVisibility(View.GONE);
            childViewHolder.mExpand2_LinearCart.setVisibility(View.VISIBLE);
        }else{
            childViewHolder.mExpand2RelativeCart.setVisibility(View.VISIBLE);
            childViewHolder.mExpand2_LinearCart.setVisibility(View.GONE);
        }
        final CheckBox checkBox = childViewHolder.mExpand2_CheckCart;

        //加
        childViewHolder.mExpand2_AddCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num++;
                listBean.setNum(num);
                mExpand2_salenumCart.setText("X " + num);
                if(listBean.isCheck()){
                    EventBus.getDefault().post(getSum());
                }
                notifyDataSetChanged();
            }
        });
        //减
        Button mExpand2_jianCart = childViewHolder.mExpand2_JianCart;
        mExpand2_jianCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(num == 1){
                    Toast.makeText(context, "你过分了啊", Toast.LENGTH_SHORT).show();
                    return;
                }
                num--;
                listBean.setNum(num);
                mExpand2_salenumCart.setText("X " + num);
                if(listBean.isCheck()){
                    EventBus.getDefault().post(getSum());
                }
                notifyDataSetChanged();
            }
        });

        childViewHolder.mExpand2_DelGoodCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<ShowCarBean.DataBean.ListBean> datas = childGoods.get(groupPosition);
                ShowCarBean.DataBean.ListBean remove = datas.remove(childPosition);
                if(datas.size() == 0){
                    childGoods.remove(groupPosition);
                    groupNames.remove(groupPosition);
                }
                EventBus.getDefault().post(getSum());
                notifyDataSetChanged();


            }
        });

        //多选框
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listBean.setCheck(checkBox.isChecked());
                EventBus.getDefault().post(getSum());
                if(checkBox.isChecked()){
                    if(selectGChild(groupPosition)){
                        selectGroup(groupPosition,true);
                        selectAll(selectAllGroup());
                    }
                }else{
                    selectGroup(groupPosition,false);
                    selectAll(selectAllGroup());
                }
                notifyDataSetChanged();
            }
        });


        return convertView;
    }

    private void selectGroup(int groupPosition, boolean b) {
        groupNames.get(groupPosition).setCheck(b);
    }

    private boolean selectGChild(int groupPosition) {
        List<ShowCarBean.DataBean.ListBean> listBeans = childGoods.get(groupPosition);
        for (int i = 0; i < listBeans.size(); i++) {
            if(!listBeans.get(i).isCheck()){
                return false;
            }
        }
        return true;
    }

    public void changAllCK(boolean b){
        for (int i = 0; i < groupNames.size(); i++) {
            selectAllChild(i,b);
            selectGroup(i,b);
        }
        EventBus.getDefault().post(getSum());
        notifyDataSetChanged();
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }



    class GroupViewHolder {
        CheckBox mExpand1_CheckCart;
        TextView mExpand1_ShopnameCart;
        TextView mExpand1_BianjiCart;
    }

    class ChildViewHolder {
        CheckBox mExpand2_CheckCart;
        ImageView mExpand2_ImageCart;
        TextView mExpand2_TitleCart;
        TextView mExpand2_PriceCart;
        TextView mExpand2_SalenumCart;
        RelativeLayout mExpand2_RelativeCart;
        Button mExpand2_AddCart;
        TextView mExpand2_NumCart;
        Button mExpand2_JianCart;
        Button mExpand2_DelGoodCart;
        LinearLayout mExpand2_LinearCart;
        RelativeLayout mExpand2RelativeCart;
    }


    public List<DDBean>  getChild(){
        ArrayList<DDBean> list = new ArrayList<>();

        for (int i = 0; i < groupNames.size(); i++) {
            List<ShowCarBean.DataBean.ListBean> listBeans = childGoods.get(i);
            for (int j = 0; j < listBeans.size(); j++) {
                if(listBeans.get(j).isCheck()){
                    list.add(new DDBean(groupNames.get(i).getName(),listBeans.get(j)));
                }
            }
        }


        return list;
    }

}
