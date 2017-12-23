package com.bwie.mytaobao.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.mytaobao.R;
import com.bwie.mytaobao.bean.ShopingCar;
import com.bwie.mytaobao.fragment.ShppingCarFragment;
import com.bwie.mytaobao.utils.Utils;

import java.util.List;

/**
 * Created by DELL on 2017/10/19.
 */

public class ShopingCarAdapter extends BaseAdapter {

    private ShopingCar shopingCar;
    private Context context;
    private final List<ShopingCar.DatasBean.CartListBean> cart_list;
    private boolean checkBoxStie;
    private final int cart_count;
    private final String sum;
    private float sumPrice = 0;
    private final ShopingCar.DatasBean datas;

    public void clearSumPrice(){
        sumPrice = 0;
    }

    public interface UpdataView{
        void setData(String price);
    }
    public UpdataView updataView;
    public void setData(UpdataView updataView){
        this.updataView = updataView;
    }

    public interface UpdataView2{
        void setData2(String price);
    }
    public UpdataView2 updataView2;
    public void setData2(UpdataView2 updataView2){
        this.updataView2 = updataView2;
    }

    public interface DeleteData{
        void deleteData(String cartid);
    }
    public DeleteData deleteData;
    public void setDeleteData(DeleteData deleteData){
        this.deleteData = deleteData;
    }


    public ShopingCarAdapter(ShopingCar shopingCar, Context context,boolean checkBoxStie) {
        this.checkBoxStie = checkBoxStie;
        this.shopingCar = shopingCar;
        this.context = context;
        datas = shopingCar.getDatas();
        cart_list = datas.getCart_list();
        cart_count = datas.getCart_count();
        sum = datas.getSum();
    }

    @Override
    public int getCount() {
        List<ShopingCar.DatasBean.CartListBean> cart_list = datas.getCart_list();
        if(cart_list.size() == 0){
            return 0;
        }
        return this.cart_list.get(0).getGoods().size();
    }

    @Override
    public Object getItem(int i) {
        return cart_list.get(i);
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
            view = View.inflate(context, R.layout.shopingcaritem,null);
            holder.shopingcar_checebox = view.findViewById(R.id.shopingcar_checebox);
            holder.shopingcar_goodcount = view.findViewById(R.id.shopingcar_goodcount);
            holder.shopingcar_goodname = view.findViewById(R.id.shopingcar_goodname);
            holder.shopingcar_goodprice = view.findViewById(R.id.shopingcar_goodprice);
            holder.shopingcar_image = view.findViewById(R.id.shopingcar_image);
            holder.shopingcar_storename = view.findViewById(R.id.shopingcar_storename);
            view.setTag(holder);
        }else{
            holder = (Holder) view.getTag();
        }
        holder.shopingcar_storename.setText(cart_list.get(0).getStore_name());
        Utils.loadImageView(context,cart_list.get(0).getGoods().get(i).getGoods_image_url(),holder.shopingcar_image);
        holder.shopingcar_goodprice.setText(cart_list.get(0).getGoods().get(i).getGoods_price());
        holder.shopingcar_goodname.setText(cart_list.get(0).getGoods().get(i).getGoods_name());
        holder.shopingcar_goodcount.setText("X"+cart_list.get(0).getGoods().get(i).getGoods_num());
        holder.shopingcar_checebox.setChecked(checkBoxStie);

        holder.shopingcar_checebox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
               if(b){
                   String goods_price = cart_list.get(0).getGoods().get(i).getGoods_price();
                   String goods_count = cart_list.get(0).getGoods().get(i).getGoods_num();
                   float v = Float.parseFloat(goods_price);
                   int sun = Integer.parseInt(goods_count);
                   sumPrice+=(v*sun);
                   updataView.setData(sumPrice+"");
               }else{
                   String goods_price = cart_list.get(0).getGoods().get(i).getGoods_price();
                   String goods_count = cart_list.get(0).getGoods().get(i).getGoods_num();
                   int sun = Integer.parseInt(goods_count);
                   float v = Float.parseFloat(goods_price);
                   sumPrice-=(v*sun);
                   updataView2.setData2(sumPrice+"");
               }
            }
        });
        return view;
    }

    class Holder{
        CheckBox shopingcar_checebox;
        ImageView shopingcar_image;
        TextView shopingcar_storename;
        TextView shopingcar_goodname;
        TextView shopingcar_goodprice;
        TextView shopingcar_goodcount;
    }

}
