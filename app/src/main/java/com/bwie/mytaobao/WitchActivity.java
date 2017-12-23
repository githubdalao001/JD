package com.bwie.mytaobao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.bwie.mytaobao.adapter.Search_listview_adapter;
import com.bwie.mytaobao.bean.LaolishiBean;
import com.bwie.mytaobao.presenter.MyWitchPresenter;
import com.bwie.mytaobao.view.IWitchView;

import java.util.List;

public class WitchActivity extends AppCompatActivity implements IWitchView{

    private ListView witch_listview;
    private MyWitchPresenter myWitchPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_witch);
        //得到控件
        EditText editText = (EditText) findViewById(R.id.witch_edittext);
        witch_listview = (ListView) findViewById(R.id.witch_listView);

        myWitchPresenter = new MyWitchPresenter(this,this);
        myWitchPresenter.loadData();

    }

    public void search_back(View view){
        finish();
    }

    @Override
    public void setNewData(final List<LaolishiBean.DatasBean.GoodsListBean> data) {
        if(data != null){
            if(witch_listview != null){
                witch_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        String goods_id = data.get(i).getGoods_id();
                        Intent intent = new Intent(WitchActivity.this,GoodInfoActivity.class);
                        intent.putExtra("goods_id","goods_id="+goods_id);
                        startActivity(intent);
                    }
                });
                witch_listview.setAdapter(new Search_listview_adapter(data,WitchActivity.this));
            }else{
                System.out.println("nulnulnmulnuil");
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myWitchPresenter.deTouch();
    }
}
