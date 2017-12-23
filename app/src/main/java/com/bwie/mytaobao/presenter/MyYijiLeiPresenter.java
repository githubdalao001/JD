package com.bwie.mytaobao.presenter;

import android.content.Context;
import android.os.AsyncTask;

import com.bwie.mytaobao.bean.YijiLeiBiaoBean;
import com.bwie.mytaobao.model.IYiJiLeiModel;
import com.bwie.mytaobao.model.MyYijiLeiModel;
import com.bwie.mytaobao.utils.WebSiteUtils;
import com.bwie.mytaobao.view.IYijiLeibiaoVIew;
import com.google.gson.Gson;

/**
 * Created by DELL on 2017/10/19.
 */

public class MyYijiLeiPresenter implements IPresenter{
    private Context context;
    private IYijiLeibiaoVIew iYijiLeibiaoVIew;
    private IYiJiLeiModel iYiJiLeiModel;

    public MyYijiLeiPresenter(Context context, IYijiLeibiaoVIew iYijiLeibiaoVIew) {
        this.context = context;
        this.iYijiLeibiaoVIew = iYijiLeibiaoVIew;
        iYiJiLeiModel = new MyYijiLeiModel();
    }

    public void loadData(){
        new AsyncTask<String,Void,String>(){
            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                if(s == null){
                    return;
                }
                Gson gson = new Gson();
                YijiLeiBiaoBean yijiLeiBiaoBean = gson.fromJson(s, YijiLeiBiaoBean.class);
                iYijiLeibiaoVIew.setDataBean(yijiLeiBiaoBean);
            }

            @Override
            protected String doInBackground(String... strings) {
                String s = iYiJiLeiModel.loadDataM(context, WebSiteUtils.YIJILEIBIAO_WEBSITE);
                return s;
            }
        }.execute();
    }

    @Override
    public void deTouch() {
        iYijiLeibiaoVIew = null;
    }
}
