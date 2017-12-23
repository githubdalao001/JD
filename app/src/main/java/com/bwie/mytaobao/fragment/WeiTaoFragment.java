package com.bwie.mytaobao.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.bwie.mytaobao.R;
import com.bwie.mytaobao.adapter.MyLIstViewYiAdapter;
import com.bwie.mytaobao.adapter.MyListViewErAdapter;
import com.bwie.mytaobao.bean.ErJiLeiBiaoBean;
import com.bwie.mytaobao.bean.YijiLeiBiaoBean;
import com.bwie.mytaobao.presenter.MyErJiPresenter;
import com.bwie.mytaobao.presenter.MyYijiLeiPresenter;
import com.bwie.mytaobao.view.IErJiView;
import com.bwie.mytaobao.view.IYijiLeibiaoVIew;

import java.util.List;

/**
 * Created by DELL on 2017/9/29.
 */

public class WeiTaoFragment extends Fragment implements IYijiLeibiaoVIew,IErJiView{
    private ListView mListViewyi,mListViewer;
    private YijiLeiBiaoBean yijiLeiBiaoBean1;
    private ErJiLeiBiaoBean erJiLeiBiaoBean;
    private MyErJiPresenter myErJiPresenter;
    private MyYijiLeiPresenter myYijiLeiPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weitao, null);
        initView(view);
        //一级列表适配数据
        loadDatayiji();
        return view;
    }

    private void loadDataerji(String gc_id) {
        myErJiPresenter = new MyErJiPresenter(getActivity(),this);
        myErJiPresenter.loadData(gc_id);
    }

    private void loadDatayiji() {
        //一级列表请求数据
        myYijiLeiPresenter = new MyYijiLeiPresenter(getActivity(),this);
        myYijiLeiPresenter.loadData();
    }

    private void initView(View itemView) {
        mListViewyi = (ListView) itemView.findViewById(R.id.fanlei_listViewyi);
        mListViewer = (ListView) itemView.findViewById(R.id.fanlei_listViewer);
        //点击一级列表开始请求对应的二级列表数据
        mListViewyi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //得到参数gc_id
                List<YijiLeiBiaoBean.DatasBean.ClassListBean> class_list = yijiLeiBiaoBean1.getDatas().getClass_list();
                YijiLeiBiaoBean.DatasBean.ClassListBean classListBean = class_list.get(i);
                String gc_id = classListBean.getGc_id();
                //请求数据
                loadDataerji(gc_id);
            }
        });
    }

    @Override
    public void setDataBean(YijiLeiBiaoBean yijiLeiBiaoBean) {
        yijiLeiBiaoBean1 = yijiLeiBiaoBean;
        if(mListViewyi != null){
            //一级列表适配数据
            mListViewyi.setAdapter(new MyLIstViewYiAdapter(yijiLeiBiaoBean,getActivity()));
        }else{
            Toast.makeText(getActivity(), "mListViewyi=null", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void setErJIBean(ErJiLeiBiaoBean erJIBean) {
        erJiLeiBiaoBean = erJIBean;
        if(mListViewer != null){
           if(erJIBean != null){
               mListViewer.setAdapter(new MyListViewErAdapter(erJIBean,getActivity()));
           }
        }else{
            Toast.makeText(getActivity(), "mListViewer=null", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if(null != myErJiPresenter){
            myErJiPresenter.deTouch();
        }
        if(null != myYijiLeiPresenter){
            myYijiLeiPresenter.deTouch();
        }
    }
}
