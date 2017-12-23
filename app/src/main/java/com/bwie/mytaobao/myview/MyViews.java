package com.bwie.mytaobao.myview;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwie.mytaobao.R;

/**
 * Created by DELL on 2017/9/29.
 */

public class MyViews extends LinearLayout {

    private View view;
    private ImageView image;
    private TextView text;
    private interface  myViewClick{
        public void click();
    }

    public void init(Context context){
        view = View.inflate(context, R.layout.myviews,this);
        image = view.findViewById(R.id.myviews_iamgeview);
        text = view.findViewById(R.id.myviews_textview);
        text.setGravity(Gravity.CENTER_HORIZONTAL);
    };

    public MyViews(Context context) {
        this(context,null);
    }

    public MyViews(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
        TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.MyViews);
        setView(typedArray);
    }

    public void setView(TypedArray typedArray) {
        if(typedArray != null){
            String string = typedArray.getString(R.styleable.MyViews_text);
            int id = typedArray.getResourceId(R.styleable.MyViews_iamge,R.mipmap.ic_launcher_round);
            text.setText(string);
            text.setGravity(Gravity.CENTER_HORIZONTAL);
            image.setImageResource(id);
        }
    }

    public MyViews(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }
}
