package com.example.jdxm.base;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jdxm.R;
import com.example.jdxm.presenter.IPresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseFragment<T extends IPresenter> extends Fragment {

    public T p;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        create();
    }

    public abstract void create();
    @Override
    public void onDetach() {
        super.onDetach();
        p.deTouch();
    }
}
