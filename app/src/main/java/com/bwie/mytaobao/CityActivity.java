package com.bwie.mytaobao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.bwie.mytaobao.adapter.CityLVAdapter;
import com.bwie.mytaobao.bean.CityBean;
import com.bwie.mytaobao.bean.EventMessage;
import com.bwie.mytaobao.presenter.MyCityPresenter;
import com.bwie.mytaobao.view.ICityVIew;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

public class CityActivity extends AppCompatActivity implements ICityVIew{

    private ListView mLvCity;
    private MyCityPresenter myCityPresenter;
    private List<CityBean.DatasBean.AreaListBean> area_list1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);
        initView();
        myCityPresenter = new MyCityPresenter(this);
        myCityPresenter.loadData();
    }

    private void initView() {
        mLvCity = (ListView) findViewById(R.id.city_lv);
        mLvCity.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                CityBean.DatasBean.AreaListBean areaListBean = area_list1.get(i);
                String area_id = areaListBean.getArea_id();
                String area_name = areaListBean.getArea_name();
                EventBus.getDefault().post(new EventMessage(area_name,area_id));
                EventBus.getDefault().unregister(this);
                finish();
            }
        });
    }



    @Override
    public void setData(List<CityBean.DatasBean.AreaListBean> area_list) {
        area_list1 = area_list;
        mLvCity.setAdapter(new CityLVAdapter(CityActivity.this,area_list1));
    }

    //释放内存
    @Override
    protected void onDestroy() {
        super.onDestroy();
        myCityPresenter.deTouch();
    }
}
