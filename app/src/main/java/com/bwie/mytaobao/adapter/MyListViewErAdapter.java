package com.bwie.mytaobao.adapter;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.mytaobao.R;
import com.bwie.mytaobao.bean.ErJiLeiBiaoBean;
import com.bwie.mytaobao.bean.SanJILeiBiaoBean;
import com.bwie.mytaobao.myview.MyGridView2;
import com.bwie.mytaobao.presenter.MySanjiPresenter;
import com.bwie.mytaobao.utils.WebSiteUtils;
import com.bwie.mytaobao.view.ISanjiView;

import java.util.List;

/**
 * Created by DELL on 2017/10/20.
 */

public class MyListViewErAdapter extends BaseAdapter implements ISanjiView{

    private ErJiLeiBiaoBean erJiLeiBiaoBean;
    private Context context;
    private final List<ErJiLeiBiaoBean.DatasBean.ClassListBean> class_list;
    private MyGridView2 gridView;
    private int flag = 0;

    public MyListViewErAdapter(ErJiLeiBiaoBean erJiLeiBiaoBean, Context context) {
        this.erJiLeiBiaoBean = erJiLeiBiaoBean;
        class_list = erJiLeiBiaoBean.getDatas().getClass_list();
        this.context = context;
    }

    @Override
    public int getCount() {
        return class_list.size();
    }

    @Override
    public Object getItem(int i) {
        return class_list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        final Holder holder;
        if(view == null){
            holder = new Holder();
            view = View.inflate(context, R.layout.mylistviewer_item,null);
            holder.textView = view.findViewById(R.id.erji_text);
            holder.gridView = view.findViewById(R.id.erji_grid);
            view.setTag(holder);
        }else{
            holder = (Holder) view.getTag();
        }
        holder.textView.setText(class_list.get(i).getGc_name());
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gridView = holder.gridView;
                MySanjiPresenter mySanjiPresenter = new MySanjiPresenter(context,MyListViewErAdapter.this);
                String sanjiPath = WebSiteUtils.YIJILEIBIAO_WEBSITE;
                mySanjiPresenter.LoadData(sanjiPath+"&gc_id="+class_list.get(i).getGc_id());
            }
        });
        return view;
    }

    @Override
    public void setSanjiBean(SanJILeiBiaoBean sanjiBean) {
        Log.i("======================", "setSanjiBean: 1");
        if(gridView != null){
            Log.i("======================", "setSanjiBean: 4");
            gridView.setAdapter(new MyGridViewSanAdapter(sanjiBean,context));
        }else{
            Toast.makeText(context, "三级列表gridview=null", Toast.LENGTH_SHORT).show();
        }
    }

    class Holder{
        TextView textView;
        MyGridView2 gridView;
    }

}
