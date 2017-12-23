package com.bwie.mytaobao;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.bwie.mytaobao.adapter.SaveAdapter;
import com.bwie.mytaobao.bean.SaveBean;
import com.bwie.mytaobao.presenter.MySavePresenter;
import com.bwie.mytaobao.view.ISaceView;

import java.util.List;


public class SaveActivity extends AppCompatActivity implements ISaceView {

    private ListView mLv;
    private List<SaveBean.DatasBean.FavoritesListBean> favorites_list1;
    private MySavePresenter mySavePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);
        initView();
        mySavePresenter = new MySavePresenter(this);
        mySavePresenter.loadData();
    }

    private void initView() {
        mLv = (ListView) findViewById(R.id.lv);
        mLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String goods_id = favorites_list1.get(i).getGoods_id();
                Intent intent = new Intent(SaveActivity.this,GoodInfoActivity.class);
                intent.putExtra("goods_id","goods_id="+goods_id);
                startActivity(intent);
            }
        });
    }

    @Override
    public void setData(List<SaveBean.DatasBean.FavoritesListBean> favorites_list) {
        favorites_list1 = favorites_list;
        if(favorites_list1.size() > 0){
            mLv.setAdapter(new SaveAdapter(favorites_list1,SaveActivity.this));
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mySavePresenter.deTouch();
    }
}
