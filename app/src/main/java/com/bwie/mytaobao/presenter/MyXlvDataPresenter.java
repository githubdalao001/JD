package com.bwie.mytaobao.presenter;

import android.content.Context;
import android.os.AsyncTask;

import com.bwie.mytaobao.bean.XlvDataBean;
import com.bwie.mytaobao.model.IXlvDataModel;
import com.bwie.mytaobao.model.MyXlvDataModel;
import com.bwie.mytaobao.utils.WebSiteUtils;
import com.bwie.mytaobao.view.IXlvDataView;
import com.google.gson.Gson;

/**
 * Created by DELL on 2017/10/10.
 */

public class MyXlvDataPresenter implements IPresenter{

    private Context context;
    private IXlvDataView iXlvDataView;
    private IXlvDataModel iXlvDataModel;
    public MyXlvDataPresenter(Context context, IXlvDataView iXlvDataView) {
        this.context = context;
        this.iXlvDataView = iXlvDataView;
        iXlvDataModel = new MyXlvDataModel();
    }
    //加载网络数据
    public void loadData(){
        new AsyncTask<String,Void,String>(){

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                if(s != null){
                    Gson gson = new Gson();
                    XlvDataBean xlvDataBean = gson.fromJson(s, XlvDataBean.class);
                    iXlvDataView.setData(xlvDataBean);
                }
            }

            @Override
            protected String doInBackground(String... strings) {
                String s = iXlvDataModel.loadDataFromNet(context, WebSiteUtils.HOMEPAGER_WEBSITE);
                return s;
            }
        }.execute();
    }

    @Override
    public void deTouch() {
        iXlvDataView = null;
    }
}
