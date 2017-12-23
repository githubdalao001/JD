package com.bwie.mytaobao.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.mytaobao.BianjiActivity;
import com.bwie.mytaobao.R;
import com.bwie.mytaobao.bean.DeleteBean;
import com.bwie.mytaobao.bean.EventBusMessage;
import com.bwie.mytaobao.bean.ShouHuoBean;
import com.bwie.mytaobao.retorfit.RertofitUtils;
import com.bwie.mytaobao.utils.WebSiteUtils;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by DELL on 2017/11/13.
 */

public class MyShouHuoAdapter extends BaseAdapter{
    private List<ShouHuoBean.DatasBean.AddressListBean> address_list;
    private Context context;
    private Subscription subscription;

    public MyShouHuoAdapter(List<ShouHuoBean.DatasBean.AddressListBean> address_list, Context context) {
        this.address_list = address_list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return address_list.size();
    }

    @Override
    public Object getItem(int i) {
        return address_list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        Holder holder;
        if(view == null){
            holder = new Holder();
            view = View.inflate(context, R.layout.shouhuadizhi_item,null);
            holder.userName = view.findViewById(R.id.dizhi_UserName);
            holder.userPhone = view.findViewById(R.id.dizhi_UserPhone);
            holder.userAddress = view.findViewById(R.id.dizhi_DiZhi);
            holder.isDefault = view.findViewById(R.id.dizhi_isDefault);
            holder.delete = view.findViewById(R.id.dizhi_Delete);
            holder.updata = view.findViewById(R.id.dizhi_updata);
            view.setTag(holder);
        }else{
            holder = (Holder) view.getTag();
        }
        //数据赋值
        holder.userName.setText(address_list.get(i).getTrue_name());
        holder.userPhone.setText(address_list.get(i).getTel_phone());
        holder.userAddress.setText(address_list.get(i).getArea_info()+address_list.get(i).getAddress());
        final String is_default = address_list.get(i).getIs_default();
        //单选框是否选中
        if("1".equals(is_default)){
            holder.isDefault.setChecked(true);
        }else{
            holder.isDefault.setChecked(false);
        }

        //点击编辑图片
        holder.updata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //得到当前要编辑的对象
                ShouHuoBean.DatasBean.AddressListBean addressListBean = address_list.get(i);
                //得到对象的属性
                String key = WebSiteUtils.lzUserInfoBean.getDatas().getKey();
                String true_name = addressListBean.getTrue_name();
                String tel_phone = addressListBean.getMob_phone();
                String area_id = addressListBean.getArea_id();
                String area_info = addressListBean.getArea_info();
                String city_id = addressListBean.getCity_id();
                String address = addressListBean.getAddress();
                String address_id = addressListBean.getAddress_id();
                System.out.println("phone="+tel_phone);
                //使用EventBus发送一个粘性事件
                EventBusMessage eventBusMessage = new EventBusMessage(key,true_name,tel_phone,city_id,area_id,address,area_info,is_default,address_id,i,false);
                EventBus.getDefault().postSticky(eventBusMessage);
                //跳转界面
                context.startActivity(new Intent(context, BianjiActivity.class));
            }
        });

        //点击删除图片
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("确定删除吗?")
                        .setNegativeButton("取消",null)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int a) {
                                shanchu(i);
                            }
                        })
                        .create()
                        .show();

            }
        });

        return view;
    }
    //删除方法
    private void shanchu(final int i) {
        String key = WebSiteUtils.lzUserInfoBean.getDatas().getKey();
        final String address_id = address_list.get(i).getAddress_id();
        //调用删除方法得到被观察者
        subscription = RertofitUtils.getAPIService().getDelete(key, address_id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<DeleteBean>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(DeleteBean deleteBean) {
                        int code = deleteBean.getCode();
                        String datas = deleteBean.getDatas();
                        if (code == 200) {
                            address_list.remove(i);
                            notifyDataSetChanged();
                        }
                    }
                });
    }

    class Holder{
        TextView userName,userPhone,userAddress;
        CheckBox isDefault;
        ImageView updata,delete;
    }
}
