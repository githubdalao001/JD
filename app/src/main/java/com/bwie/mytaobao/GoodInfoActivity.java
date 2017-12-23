package com.bwie.mytaobao;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.mytaobao.bean.AddShopCar;
import com.bwie.mytaobao.bean.GoodsBean;
import com.bwie.mytaobao.presenter.MyGoodsDataPresenter;
import com.bwie.mytaobao.utils.OKhttpUtils;
import com.bwie.mytaobao.utils.Utils;
import com.bwie.mytaobao.utils.WebSiteUtils;
import com.bwie.mytaobao.view.IGoodsInfo;
import com.google.gson.Gson;
import com.youth.banner.Banner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class GoodInfoActivity extends AppCompatActivity implements IGoodsInfo{

    private String goodsUrl;
    private List<GoodsBean.DatasBean.GoodsCommendListBean> goods_commend_list;
    private List<String> list;
    private Banner banner;
    private TextView goods_info_goodname,goods_info_hair,goods_info_count,goods_info_store,goods_info_goodprice;
    private GoodsBean.DatasBean.GoodsInfoBean goods_info;
    private GoodsBean.DatasBean.StoreInfoBean store_info;
    private int goodsCount = 1;
    private String goods_image;
    private AddShopCar addShopCar;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String str = (String) msg.obj;
            if(str != null){
                Gson gson  = new Gson();
                AddShopCar lzUserInfoBean = gson.fromJson(str, AddShopCar.class);
                if(lzUserInfoBean.getCode() == 200){
                }else{
                    Toast.makeText(GoodInfoActivity.this, "购物车添加失败", Toast.LENGTH_SHORT).show();
                }
            }
        }
    };
    private MyGoodsDataPresenter myGoodsDataPresenter;
    private String goods_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_good_info);
        banner = (Banner) findViewById(R.id.goods_info_banner);
        goods_info_goodname = (TextView) findViewById(R.id.goods_info_goodname);
        goods_info_hair = (TextView) findViewById(R.id.goods_info_hair);
        goods_info_count = (TextView) findViewById(R.id.goods_info_count);
        goods_info_store = (TextView) findViewById(R.id.goods_info_store);
        goods_info_goodprice = (TextView) findViewById(R.id.goods_info_goodprice);
        goods_id = getIntent().getStringExtra("goods_id");
        goodsUrl = WebSiteUtils.GOODSINFO_WEBSITE + goods_id;
        System.out.println("goods_info = "+goodsUrl);
        myGoodsDataPresenter = new MyGoodsDataPresenter(this,this);
        myGoodsDataPresenter.LodaDat(goodsUrl);
    }

    //收藏商品
    public void saveGoods(View view){

    }

    public void shopCar(View v){
        //PopupWindow的布局
        View view = getLayoutInflater().inflate(R.layout.popup_window, null);
        //得到控件
        ImageView pop_goodiamge = view.findViewById(R.id.pop_goodiamge);
        ImageView pop_jian = view.findViewById(R.id.pop_jian);
        ImageView pop_jia = view.findViewById(R.id.pop_jia);
        TextView goods_price = view.findViewById(R.id.goods_price);
        TextView goods_count = view.findViewById(R.id.goods_count);
        TextView good_totalprice = view.findViewById(R.id.good_totalprice);
        final TextView pop_goodcount = view.findViewById(R.id.pop_goodcount);
        Button pop_quding = view.findViewById(R.id.pop_quding);
        //控件赋值
        Utils.loadImageView(GoodInfoActivity.this,goods_image,pop_goodiamge);
        goods_price.setText(goods_info.getGoods_price()+"");
        goods_count.setText("库存"+store_info.getGoods_count()+"件");
        pop_goodcount.setText(""+goodsCount);
        good_totalprice.setText(store_info.getStore_name());
        //增加购买数量
        pop_jia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //重新给textview赋值
                goodsCount++;
                pop_goodcount.setText(""+goodsCount);
            }
        });
        //减少购买数量
        pop_jian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(goodsCount>1){
                    //重新给textview赋值
                    goodsCount--;
                    pop_goodcount.setText(""+goodsCount);
                }
            }
        });

        //确定购买
        pop_quding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(WebSiteUtils.lzUserInfoBean == null){
                    startActivity(new Intent(GoodInfoActivity.this,LoginActivity.class));
                }else{
                    //得到要用的key
                    String key = WebSiteUtils.lzUserInfoBean.getDatas().getKey();
                    //得到要用的goods_id
                    String goods_id = goods_info.getGoods_id();
                    //得到添加购物车的网址前部分
                    String shopCarPath = WebSiteUtils.SHOPCAR_WENSITE;
                    shopCarPath+="&quantity="+goodsCount;
                    //使用map集合存储用到的参数
                    HashMap<String, String> hashMap = new HashMap<String, String>();
                    hashMap.put("key",key);
                    System.out.println("我的key="+key);
                    hashMap.put("goods_id",goods_id);
                    hashMap.put("quantity",goodsCount+"");
                    OKhttpUtils.getInstance().doPost(shopCarPath, hashMap, new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                            Toast.makeText(GoodInfoActivity.this, "购物车添加网络请求失败", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            String string = response.body().string();
                            Message msg = Message.obtain();
                            msg.obj = string;
                            handler.sendMessage(msg);
                        }
                    });
                }
            }
        });
        PopupWindow popWindow = new PopupWindow(view, LinearLayout.LayoutParams.MATCH_PARENT, 800, true);
        //让PopupWindow点击空白处可以消失
        popWindow.setOutsideTouchable(true);
        popWindow.setBackgroundDrawable(new BitmapDrawable());
        //设置PopupWindow的动画
        popWindow.setAnimationStyle(R.style.popwin_anim_style);
        //设置view的弹出位置在屏幕下方
        popWindow.showAtLocation(view, Gravity.BOTTOM, 0, 0);
    }

    private void banderAutoPlay() {
        list = new ArrayList<>();
        for (GoodsBean.DatasBean.GoodsCommendListBean db: goods_commend_list) {
            list.add(db.getGoods_image_url());
        }
        banner.setImages(list);
        banner.setDelayTime(500000);
        banner.isAutoPlay(false);
        banner.setBannerStyle(Banner.ACCESSIBILITY_LIVE_REGION_ASSERTIVE);
    }

    @Override
    public void setGoodsData(GoodsBean.DatasBean data) {
        if(data != null){
            goods_image = data.getGoods_image();
            goods_commend_list = data.getGoods_commend_list();
            goods_info = data.getGoods_info();
            store_info = data.getStore_info();
            banderAutoPlay();
            //商品姓名
            goods_info_goodname.setText(data.getGoods_info().getGoods_name());
            //快递
            goods_info_hair.setText(data.getGoods_hair_info().getArea_name()+" "+data.getGoods_hair_info().getContent());
            //库存
            goods_info_count.setText("库存"+data.getStore_info().getGoods_count());
            //商店
            goods_info_store.setText(data.getStore_info().getStore_name());
            //商品价格
            goods_info_goodprice.setText(data.getGoods_info().getGoods_promotion_price());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myGoodsDataPresenter.deTouch();
    }
}
