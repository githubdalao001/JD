package com.bwie.mytaobao.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bwie.mytaobao.DingDanActivity;
import com.bwie.mytaobao.R;
import com.bwie.mytaobao.SaveActivity;
import com.bwie.mytaobao.ZuJiActivity;
import com.bwie.mytaobao.bean.ZuJiBean;
import com.bwie.mytaobao.presenter.MySelfPresenter;
import com.bwie.mytaobao.transform.GlideCircleTransform;
import com.bwie.mytaobao.utils.Utils;
import com.bwie.mytaobao.utils.WebSiteUtils;
import com.bwie.mytaobao.view.IMySelfeView;

import org.greenrobot.eventbus.EventBus;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * Created by DELL on 2017/9/29.
 */

public class MySelfFragment extends Fragment implements IMySelfeView {

    private ImageView mImageUser;
    private TextView mNameUser;
    private MySelfPresenter mySelfPresenter;
    private PopupWindow popupWindow;
    private SharedPreferences sp;
    private TextView mDingdan;
    private LinearLayout mWodell;
    private TextView mZuji;
    private TextView mWodezuju;
    private TextView mWodeshoucang;
    private TextView mZhuxiao;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_myself, null);
        initView(view);
        //创建P层对象
        mySelfPresenter = new MySelfPresenter(this);
        //显示用户信息
        mySelfPresenter.showUserInfo();
        return view;
    }

    private void initView(View itemView) {
        sp = Utils.headImageSP(getActivity());
        mImageUser = (ImageView) itemView.findViewById(R.id.user_image);
        mNameUser = (TextView) itemView.findViewById(R.id.user_name);
        String imagepath = sp.getString("imagepath", "");
        if (!"".equals(imagepath)) {
            Bitmap bitmap = getBitmap(imagepath);
            mImageUser.setImageBitmap(bitmap);
        }
        //进入设置界面
        Button but = itemView.findViewById(R.id.meself_shezhi);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mySelfPresenter.shezhiOnClick();
            }
        });
        mImageUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View popview = View.inflate(getActivity(), R.layout.headiamge, null);
                popupWindow = new PopupWindow(popview, LinearLayout.LayoutParams.MATCH_PARENT, 400);
                //控件的监听
                TextView text = popview.findViewById(R.id.popHead);
                text.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popupWindow.dismiss();
                    }
                });
                //点击相册
                ImageView xiangce = popview.findViewById(R.id.xiangce);
                xiangce.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // 激活系统图库，选择一张图片
                        Intent intent = new Intent(Intent.ACTION_PICK);
                        intent.setType("image/*");
                        // 开启一个带有返回值的Activity，请求码为PHOTO_REQUEST_GALLERY
                        getActivity().startActivityForResult(intent, 2);
                    }
                });

                //点击拍照
                ImageView paizhao = popview.findViewById(R.id.paizhao);
                paizhao.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");//开始拍照
                            String mPhotoPath = getSDPath() + "/" + getPhotoFileName();//设置图片文件路
                            WebSiteUtils.MyPhotoPath = mPhotoPath;
                            File mPhotoFile = new File(mPhotoPath);
                            if (!mPhotoFile.exists()) {
                                mPhotoFile.createNewFile();//创建新文件
                            }
                            intent.putExtra(MediaStore.EXTRA_OUTPUT,//Intent有了图片的信息
                                    Uri.fromFile(mPhotoFile));
                            getActivity().startActivityForResult(intent, 1);//跳转界面传回拍照所得数据
                        } catch (Exception e) {
                        }
                    }
                });
                popupWindow.setAnimationStyle(R.style.popwin_anim_style_head);
                //点击空白消失
                popupWindow.setFocusable(true);
                popupWindow.setOutsideTouchable(true);
                //不设置背景就不能点外边
                popupWindow.setBackgroundDrawable(new BitmapDrawable());
                //设置背景
                setBackgroundAlpha(0.5f);
                //显示的位置
                popupWindow.showAtLocation(mImageUser, Gravity.CENTER, 0, 0);
                //消失的监听
                popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        setBackgroundAlpha(1f);
                    }
                });
            }
        });
        mDingdan = (TextView) itemView.findViewById(R.id.dingdan);
        mDingdan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), DingDanActivity.class));
            }
        });
        mWodell = (LinearLayout) itemView.findViewById(R.id.wodell);
        mZuji = (TextView) itemView.findViewById(R.id.zuji);
        //我的足迹
        mWodezuju = (TextView) itemView.findViewById(R.id.wodezuju);
        mWodezuju.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mySelfPresenter.showZuJi();
            }
        });
        //我的收藏
        mWodeshoucang = (TextView) itemView.findViewById(R.id.wodeshoucang);
        mWodeshoucang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), SaveActivity.class));
            }
        });
        mZhuxiao = (TextView) itemView.findViewById(R.id.zhuxiao);
    }

    //得到字符串转换Bitmap
    private Bitmap getBitmap(String ImagePath) {
        Bitmap bitmap = BitmapFactory.decodeFile(ImagePath);
        return bitmap;
    }

    //得到SD卡路径
    public String getSDPath() {
        File sdDir = null;
        boolean sdCardExist = Environment.getExternalStorageState()
                .equals(Environment.MEDIA_MOUNTED);   //判断sd卡是否存在
        if (sdCardExist) {
            sdDir = Environment.getExternalStorageDirectory();//获取跟目录
        }
        return sdDir.toString();

    }

    //得到文件名字
    private String getPhotoFileName() {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "'IMG'_yyyyMMdd_HHmmss");
        return dateFormat.format(date) + ".jpg";
    }

    //显示图片
    public void setImagePath(String imagePath) {
        sp.edit().putString("imagepath", imagePath).commit();
        Bitmap bitmap = getBitmap(imagePath);
        //bitmap转为byte数组
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] bytes = baos.toByteArray();

        popupWindow.dismiss();
        Glide.with(getActivity()).load(bytes).bitmapTransform(new GlideCircleTransform(getActivity())).into(mImageUser);
    }

    //设置popupwindow背景透明
    public void setBackgroundAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp = getActivity().getWindow()
                .getAttributes();
        lp.alpha = bgAlpha;
        getActivity().getWindow().setAttributes(lp);
    }

    //显示用户信息 V层
    @Override
    public void showUserInfo(int url, String name) {
        Glide.with(getActivity()).load(url).bitmapTransform(new GlideCircleTransform(getActivity())).into(mImageUser);
        mNameUser.setText(name);
    }

    //点击设置
    @Override
    public void shezhiOnClick(Class a) {
        startActivity(new Intent(getActivity(), a));
        //界面跳转动画
        getActivity().overridePendingTransition(R.anim.activityin, R.anim.activityout);
    }
    //我的足迹
    @Override
    public void setZuJiData(List<ZuJiBean.DatasBean.GoodsbrowseListBean> goodsbrowse_list) {
        EventBus.getDefault().postSticky(goodsbrowse_list);
        startActivity(new Intent(getActivity(), ZuJiActivity.class));
    }

    //解除绑定
    @Override
    public void onDetach() {
        super.onDetach();
        if(null != mySelfPresenter){
            mySelfPresenter.deTouch();
        }
    }
}
