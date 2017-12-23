package com.example.jdxm.base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jdxm.R;
import com.example.jdxm.presenter.IPresenter;

public abstract class BaseActivity<T extends IPresenter> extends AppCompatActivity {

    public T p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        create();
    }

    public abstract void create();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(p != null){
            p.deTouch();
        }
    }
}
