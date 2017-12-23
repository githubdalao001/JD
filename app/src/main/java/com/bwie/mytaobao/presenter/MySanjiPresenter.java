package com.bwie.mytaobao.presenter;

import android.content.Context;
import android.os.AsyncTask;

import com.bwie.mytaobao.bean.SanJILeiBiaoBean;
import com.bwie.mytaobao.model.ISanjiModel;
import com.bwie.mytaobao.model.MySanJiModel;
import com.bwie.mytaobao.view.ISanjiView;
import com.google.gson.Gson;

/**
 * Created by DELL on 2017/10/20.
 */

public class MySanjiPresenter implements IPresenter{
    private Context context;
    private ISanjiModel iSanjiModel;
    private ISanjiView iSanjiViewl;

    public MySanjiPresenter(Context context,ISanjiView iSanjiViewl) {
        this.context = context;
        this.iSanjiViewl = iSanjiViewl;
        iSanjiModel = new MySanJiModel();
    }

    public void LoadData(final String path){
        new AsyncTask<String,Void,String>(){
            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                if(s==null){
                    return;
                }
                Gson gson = new Gson();
                SanJILeiBiaoBean sanJILeiBiaoBean = gson.fromJson(s, SanJILeiBiaoBean.class);
                iSanjiViewl.setSanjiBean(sanJILeiBiaoBean);
                iSanjiViewl=null;
            }
            @Override
            protected String doInBackground(String... strings) {
                String s = iSanjiModel.loadDat(context, path);
                return s;
            }
        }.execute();
    }

    @Override
    public void deTouch() {
        iSanjiViewl = null;
    }
}
