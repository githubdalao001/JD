package com.example.jdxm.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by DELL on 2017/12/20.
 */

public class ImageUtils {
    public static void imageLoad(Context context , String url ,ImageView imageView){
        Glide.with(context).load(url).into(imageView);
    }
}
