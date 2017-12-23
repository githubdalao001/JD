package com.example.jdxm.presenter;

/**
 * Created by DELL on 2017/12/18.
 */

public interface IPresenter<T> {
    void atTouch(T view);
    void deTouch();
}
