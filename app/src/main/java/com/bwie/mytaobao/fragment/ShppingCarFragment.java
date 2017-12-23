package com.bwie.mytaobao.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.mytaobao.LoginActivity;
import com.bwie.mytaobao.MainActivity;
import com.bwie.mytaobao.R;
import com.bwie.mytaobao.adapter.ShopingCarAdapter;
import com.bwie.mytaobao.bean.ShopingCar;
import com.bwie.mytaobao.payment.PayDemoActivity;
import com.bwie.mytaobao.utils.OKhttpUtils;
import com.bwie.mytaobao.utils.Utils;
import com.bwie.mytaobao.utils.WebSiteUtils;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by DELL on 2017/9/29.
 */

public class ShppingCarFragment extends Fragment {
    private TextView mTitleShopingcar;
    private ListView mListviewShopingcar;
    private CheckBox mQuanxuanShopingcar;
    private TextView mSumpriceShopingcar;
    private boolean checkBoxStie = false;
    private ShopingCarAdapter shopingCarAdapter;
    private Button mJiesuanShopingcar;
    private int sumPrice = 0;
    private int goodCount = 0;
    private ShopingCar shopingCar;
    private boolean banben = true;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                String delePath = (String) msg.obj;

            }
            String str = (String) msg.obj;
            Gson gson = new Gson();
            shopingCar = gson.fromJson(str, ShopingCar.class);
            shopingCarAdapter = new ShopingCarAdapter(shopingCar,getActivity(),checkBoxStie);
            mListviewShopingcar.setAdapter(shopingCarAdapter);
            shopingCarAdapter.setData(new ShopingCarAdapter.UpdataView() {
                @Override
                public void setData(String price) {
                    mSumpriceShopingcar.setText("总价:"+price);
                }
            });
            shopingCarAdapter.setData2(new ShopingCarAdapter.UpdataView2() {
                @Override
                public void setData2(String price) {
                    mSumpriceShopingcar.setText("总价:"+price);
                }
            });
        }
    };
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shoppingcar, null);
        initView(view);
        SharedPreferences sp = Utils.loginState(getActivity());
        if(sp.getBoolean("logintruefalse",true) == false){
            loadData();
        }
        mJiesuanShopingcar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), PayDemoActivity.class));
            }
        });
        return view;
    }

    private void loadData() {
        //得到key值 和网址
        String key = WebSiteUtils.lzUserInfoBean.getDatas().getKey();
        String shopingcarWebsite = WebSiteUtils.SHOPINGCAR_WEBSITE;
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("key", key);
        OKhttpUtils.getInstance().doPost(shopingcarWebsite, hashMap, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Message msg = Message.obtain();
                String string = response.body().string();
                msg.obj = string;
                handler.sendMessage(msg);
            }
        });
    }

    private void initView(View itemView) {
        mTitleShopingcar = (TextView) itemView.findViewById(R.id.shopingcar_title);
        mListviewShopingcar = (ListView) itemView.findViewById(R.id.shopingcar_listview);
        mQuanxuanShopingcar = (CheckBox) itemView.findViewById(R.id.shopingcar_quanxuan);
        mSumpriceShopingcar = (TextView) itemView.findViewById(R.id.shopingcar_sumprice);
        mJiesuanShopingcar = (Button) itemView.findViewById(R.id.shopingcar_jiesuan);
        mListviewShopingcar.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setMessage("是否删除商品");
                builder.setNegativeButton("取消",null);
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, final int i) {
                        String deleteshopWebsite = WebSiteUtils.DELETESHOP_WEBSITE;
                        HashMap<String,String> hashMap = new HashMap<String, String>();
                        hashMap.put("key",WebSiteUtils.lzUserInfoBean.getDatas().getKey());
                        hashMap.put("cart_id",shopingCar.getDatas().getCart_list().get(0).getGoods().get(i+1).getCart_id());
                        OKhttpUtils.getInstance().doPost(deleteshopWebsite, hashMap, new Callback() {
                            @Override
                            public void onFailure(Call call, IOException e) {
                                Toast.makeText(getActivity(), "购物车删除失败", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onResponse(Call call, Response response) throws IOException {
                                String string = response.body().string();
                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        shopingCar.getDatas().getCart_list().get(0).getGoods().remove(i+1);
                                        shopingCarAdapter.notifyDataSetChanged();
                                    }
                                });
                            }
                        });
                    }
                });
                builder.create().show();
                return true;
            }
        });
        mQuanxuanShopingcar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    checkBoxStie = true;
                    mSumpriceShopingcar.setText("总价:"+shopingCar.getDatas().getSum());
                }else{
                    checkBoxStie = false;
                    shopingCarAdapter.clearSumPrice();
                    mSumpriceShopingcar.setText("总价:0");
                }
                shopingCarAdapter = new ShopingCarAdapter(shopingCar,getActivity(),checkBoxStie);
                mListviewShopingcar.setAdapter(shopingCarAdapter);
                shopingCarAdapter.setData(new ShopingCarAdapter.UpdataView() {
                    @Override
                    public void setData(String price) {
                        mSumpriceShopingcar.setText("总价:"+price);
                    }
                });
                shopingCarAdapter.setData2(new ShopingCarAdapter.UpdataView2() {
                    @Override
                    public void setData2(String price) {
                        mSumpriceShopingcar.setText("总价:"+price);
                    }
                });
            }
        });
    }
}
