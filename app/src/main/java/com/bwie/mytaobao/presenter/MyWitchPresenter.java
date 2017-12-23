package com.bwie.mytaobao.presenter;

import android.content.Context;
import android.os.AsyncTask;

import com.bwie.mytaobao.bean.LaolishiBean;
import com.bwie.mytaobao.model.IWitchModel;
import com.bwie.mytaobao.model.MyWitchModel;
import com.bwie.mytaobao.utils.WebSiteUtils;
import com.bwie.mytaobao.view.IWitchView;
import com.google.gson.Gson;

import java.util.List;

/**
 * Created by DELL on 2017/10/13.
 */

public class MyWitchPresenter implements IPresenter{
    private Context context;
    private IWitchView iWitchView;
    private IWitchModel iWitchModel;

    public MyWitchPresenter(Context context, IWitchView iWitchView) {
        this.context = context;
        this.iWitchView = iWitchView;
        iWitchModel = new MyWitchModel();
    }

    public void loadData(){
        new AsyncTask<String,Void,String>(){
            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                if(s != null){
                    Gson gson = new Gson();
                    LaolishiBean laolishiBean = gson.fromJson(s, LaolishiBean.class);
                    LaolishiBean.DatasBean datas = laolishiBean.getDatas();
                    List<LaolishiBean.DatasBean.GoodsListBean> goods_list = datas.getGoods_list();
                    iWitchView.setNewData(goods_list);
                }
            }

            @Override
            protected String doInBackground(String... strings) {
                String str = iWitchModel.loadNewData(context, WebSiteUtils.SEARCHWITCH_WEBSITE);
                return str;
            }
        }.execute();
    }

    @Override
    public void deTouch() {
        iWitchView = null;
    }
}
