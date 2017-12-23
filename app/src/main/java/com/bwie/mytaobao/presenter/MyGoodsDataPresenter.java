package com.bwie.mytaobao.presenter;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.bwie.mytaobao.bean.GoodsBean;
import com.bwie.mytaobao.model.IGoodsInfoModel;
import com.bwie.mytaobao.model.MyGoodsModel;
import com.bwie.mytaobao.view.IGoodsInfo;
import com.google.gson.Gson;

/**
 * Created by DELL on 2017/10/17.
 */

public class MyGoodsDataPresenter implements IPresenter{
    private Context context;
    private IGoodsInfo iGoodsInfo;
    private IGoodsInfoModel iGoodsInfoModel;

    public MyGoodsDataPresenter(Context context, IGoodsInfo iGoodsInfo) {
        this.context = context;
        this.iGoodsInfo = iGoodsInfo;
        iGoodsInfoModel = new MyGoodsModel();
    }

    public void LodaDat(final String url){
       new AsyncTask<String,Void,String>(){
           @Override
           protected void onPostExecute(String s) {
               super.onPostExecute(s);
               Gson gson = new Gson();
               GoodsBean goodsBean = gson.fromJson(s, GoodsBean.class);
               if(goodsBean.getCode() == 200){
                   iGoodsInfo.setGoodsData(goodsBean.getDatas());
               }else{
                   Toast.makeText(context, "网络请求失败了", Toast.LENGTH_SHORT).show();
               }
           }

           @Override
           protected String doInBackground(String... strings) {
               String jsonStr = iGoodsInfoModel.LoadData(context, url);
               return jsonStr;
           }
       }.execute();
    }

    @Override
    public void deTouch() {
        iGoodsInfo = null;
    }
}
