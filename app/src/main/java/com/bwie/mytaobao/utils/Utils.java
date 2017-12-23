package com.bwie.mytaobao.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.bwie.mytaobao.R;
import com.bwie.mytaobao.adapter.HomePager_GvAdapter;
import com.bwie.mytaobao.bean.GradBean;
import com.youth.banner.Banner;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 2017/10/8.
 */

public class Utils {

    public static void loadImageView(Context context , String imagePath , final ImageView imageView){
        Glide.with(context)
                //加载图片
                .load(imagePath)
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        if (imageView == null) {
                            return false;
                        }
                        if (imageView.getScaleType() != ImageView.ScaleType.FIT_XY) {
                            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        }
                        ViewGroup.LayoutParams params = imageView.getLayoutParams();
                        int vw = imageView.getWidth() - imageView.getPaddingLeft() - imageView.getPaddingRight();
                        float scale = (float) vw / (float) resource.getIntrinsicWidth();
                        int vh = Math.round(resource.getIntrinsicHeight() * scale);
                        params.height = 200;
                        imageView.setLayoutParams(params);
                        return false;
                    }
                })
                //在imageview上显示
                .into(imageView);
    }

    public static SharedPreferences loginState(Context context){
        SharedPreferences sp = context.getSharedPreferences("logintf",context.MODE_PRIVATE);
        return sp;
    };
    public static  SharedPreferences headImageSP(Context context){
        SharedPreferences headimage = context.getSharedPreferences("headimage", context.MODE_PRIVATE);
        return headimage;
    }
    public static String FromIOtoStr(InputStream is){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            int len;
            byte[] b = new byte[1024];
            while( (len = is.read(b)) != -1 ){
                baos.write(b,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return baos.toString();
    }
}
