package com.bwie.mytaobao.presenter;

import android.content.Context;
import android.os.AsyncTask;

import com.bwie.mytaobao.bean.ErJiLeiBiaoBean;
import com.bwie.mytaobao.model.IErJiModel;
import com.bwie.mytaobao.model.MyErJiModel;
import com.bwie.mytaobao.utils.WebSiteUtils;
import com.bwie.mytaobao.view.IErJiView;
import com.google.gson.Gson;

/**
 * Created by DELL on 2017/10/20.
 */

public class MyErJiPresenter implements IPresenter{
    private Context context;
    private IErJiView iErJiView;
    private IErJiModel iErJiModel;

    public MyErJiPresenter(Context context, IErJiView iErJiView) {
        this.context = context;
        this.iErJiView = iErJiView;
        iErJiModel = new MyErJiModel();
    }

    public void loadData(final String gc_id){
        new AsyncTask<String,Void,String>(){
            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                if(s == null){
                    return;
                }
                Gson gson = new Gson();
                ErJiLeiBiaoBean erJiLeiBiaoBean = gson.fromJson(s, ErJiLeiBiaoBean.class);
                iErJiView.setErJIBean(erJiLeiBiaoBean);
            }

            @Override
            protected String doInBackground(String... strings) {
                String s = iErJiModel.loadData(context, WebSiteUtils.YIJILEIBIAO_WEBSITE + "&gc_id=" + gc_id);
                return s;
            }
        }.execute();
    }

    @Override
    public void deTouch() {
        iErJiView = null;
    }
}
