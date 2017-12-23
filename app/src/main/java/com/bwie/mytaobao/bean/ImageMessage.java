package com.bwie.mytaobao.bean;

import android.graphics.Bitmap;

/**
 * Created by DELL on 2017/11/15.
 */

public class ImageMessage {
    private Bitmap bitmap;

    public ImageMessage(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}
