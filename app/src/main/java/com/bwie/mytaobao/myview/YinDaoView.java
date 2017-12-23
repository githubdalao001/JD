package com.bwie.mytaobao.myview;

import android.content.Context;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by DELL on 2017/11/15.
 */

public class YinDaoView extends View{

    private Paint paint;

    private void init(){
        paint = new Paint();

    }

    public YinDaoView(Context context) {
        super(context);
    }

    public YinDaoView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public YinDaoView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
