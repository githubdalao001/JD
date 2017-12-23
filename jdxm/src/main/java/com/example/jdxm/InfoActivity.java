package com.example.jdxm;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jdxm.base.BaseActivity;
import com.example.jdxm.bean.HomeBean;
import com.example.jdxm.bean.InfoBean;
import com.example.jdxm.presenter.InPresenter;
import com.example.jdxm.utils.ImageUtils;
import com.example.jdxm.utils.Utils;
import com.example.jdxm.view.IIView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class InfoActivity extends BaseActivity<InPresenter> implements View.OnClickListener,IIView {
    private int ncount = 1;
    private ImageView mImageInfo;
    private Button mAddShopingCar;
    private int pid;
    private InfoBean goodinfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        initView();
        EventBus.getDefault().register(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void getData(HomeBean.TuijianBean.ListBean listBean){
        Toast.makeText(this, "ssssss", Toast.LENGTH_SHORT).show();
        //加载图片
        String[] strings = Utils.splitStr(listBean.getImages());
        ImageUtils.imageLoad(this,strings[0],mImageInfo);
        //获得pid
        pid = listBean.getPid();
        p.loadData();
    }

    @Override
    public void create() {
        p = new InPresenter(this);
    }

    private void initView() {
        mImageInfo = (ImageView) findViewById(R.id.info_image);
        mAddShopingCar = (Button) findViewById(R.id.addShopingCar);
        mAddShopingCar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addShopingCar:
                showPopWindow();
                break;
            default:
                break;
        }
    }

    private void showPopWindow() {
        View view = getLayoutInflater().inflate(R.layout.popupwindow, null);
        Button button = view.findViewById(R.id.queding);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(InfoActivity.this, "点击确定", Toast.LENGTH_SHORT).show();
                addCar();
            }
        });
        TextView good = view.findViewById(R.id.good);
        TextView jia = view.findViewById(R.id.jia);
        TextView jian = view.findViewById(R.id.jian);
        final TextView count = view.findViewById(R.id.count);
        count.setText(ncount+"");
        good.setText(goodinfo.getData().getTitle()+","+goodinfo.getData().getPrice());
        jia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ncount++;
                count.setText(ncount+"");
            }
        });
        jian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ncount > 1){
                    ncount--;
                    count.setText(ncount+"");
                }
            }
        });
        //设置高度
        WindowManager wm = this.getWindowManager();
        int width = wm.getDefaultDisplay().getWidth();
        PopupWindow popWindow = new PopupWindow(view, LinearLayout.LayoutParams.MATCH_PARENT, width, true);
        //让PopupWindow点击空白处可以消失
        popWindow.setOutsideTouchable(true);
        popWindow.setBackgroundDrawable(new BitmapDrawable());
        //设置PopupWindow的动画
        popWindow.setAnimationStyle(R.style.mypopwindow_anim_style);
        //设置view的弹出位置在屏幕下方
        popWindow.showAtLocation(view, Gravity.BOTTOM, 0, 0);
    }

    private void addCar() {
        p.loadCData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void setData(InfoBean infoBean) {
        goodinfo = infoBean;
        Log.i("===", "setData: "+infoBean.getData().getPid());
    }

    @Override
    public void setCData() {
        Toast.makeText(this, "添加成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public int getPid() {
        return pid;
    }
}
