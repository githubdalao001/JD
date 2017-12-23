package com.example.jdxm.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jdxm.R;
import com.example.jdxm.ReadDingActivity;
import com.example.jdxm.adapter.SCAdapter;
import com.example.jdxm.base.BaseFragment;
import com.example.jdxm.base.EventMessageBean;
import com.example.jdxm.bean.DDBean;
import com.example.jdxm.bean.EventMessageFL;
import com.example.jdxm.bean.GBean;
import com.example.jdxm.bean.ShowCarBean;
import com.example.jdxm.presenter.CPresenter;
import com.example.jdxm.view.ISVIew;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShopCarFragment extends BaseFragment<CPresenter> implements ISVIew {

    private List<GBean> groupNames;
    private List<List<ShowCarBean.DataBean.ListBean>> childGoods;
    private TextView mTopbarGouwuche;
    private CheckBox mFooterCheckGouwuche;
    private TextView mFooterJiesuanGouwuche;
    private TextView mFooterPriceGouwuche;
    private TextView mFooterHejiGouwuche;
    private RelativeLayout mFooterGouwuche;
    private ExpandableListView mExpandedGouwuche;
    private TextView mTvGouwuche;
    private SCAdapter scAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shop_car, null);
        initView(view);
        EventBus.getDefault().register(this);
        p.loadData();
        return view;
    }

    private void initView(View itemView) {
        mTopbarGouwuche = (TextView) itemView.findViewById(R.id.gouwuche_topbar);
        mFooterCheckGouwuche = (CheckBox) itemView.findViewById(R.id.gouwuche_footer_check);
        mFooterCheckGouwuche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scAdapter.changAllCK(mFooterCheckGouwuche.isChecked());
            }
        });
        mFooterJiesuanGouwuche = (TextView) itemView.findViewById(R.id.gouwuche_footer_jiesuan);
        mFooterJiesuanGouwuche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<DDBean> child = scAdapter.getChild();
                EventBus.getDefault().postSticky(child);
                startActivity(new Intent(getActivity(), ReadDingActivity.class));
            }
        });
        mFooterPriceGouwuche = (TextView) itemView.findViewById(R.id.gouwuche_footer_price);
        mFooterHejiGouwuche = (TextView) itemView.findViewById(R.id.gouwuche_footer_heji);
        mFooterGouwuche = (RelativeLayout) itemView.findViewById(R.id.gouwuche_footer);
        mExpandedGouwuche = (ExpandableListView) itemView.findViewById(R.id.gouwuche_expanded);
        mExpandedGouwuche.setGroupIndicator(null);
        mTvGouwuche = (TextView) itemView.findViewById(R.id.gouwuche_tv);
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void EventMethodO(EventMessageBean bean){
        mFooterJiesuanGouwuche.setText("结算("+bean.getSum()+")");
        mFooterPriceGouwuche.setText("￥"+bean.getSumPrice());
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void EventMethodT(EventMessageFL fl){
        mFooterCheckGouwuche.setChecked(fl.isFlag());
    }
    @Override
    public void create() {
        p = new CPresenter(this);
    }
    @Override
    public void setData(ShowCarBean showCarBean) {
        List<ShowCarBean.DataBean> data = showCarBean.getData();
        childGoods = new ArrayList<>();
        groupNames = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            groupNames.add(new GBean(data.get(i).getSellerName(),false));
            childGoods.add(data.get(i).getList());
        }
        scAdapter = new SCAdapter(groupNames, childGoods, getActivity());
        mExpandedGouwuche.setAdapter(scAdapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
