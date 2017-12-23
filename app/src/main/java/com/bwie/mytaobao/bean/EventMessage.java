package com.bwie.mytaobao.bean;

import android.graphics.Bitmap;

/**
 * Created by DELL on 2017/11/10.
 */

public class EventMessage {
    private String area_name;
    private String area_id;
    private int address_id;
    private boolean flag;
    private Bitmap bitmap;
    private String isMain;
    public EventMessage(Bitmap bitmap,String string) {
        this.bitmap = bitmap;
        this.isMain = isMain;
    }

    public String getIsMain() {
        return isMain;
    }

    public void setIsMain(String isMain) {
        this.isMain = isMain;
    }

    public EventMessage(String area_name, String area_id) {
        this.area_name = area_name;
        this.area_id = area_id;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public EventMessage(int address_id, boolean flag) {
        this.address_id = address_id;
        this.flag = flag;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public String getArea_name() {
        return area_name;
    }

    public void setArea_name(String area_name) {
        this.area_name = area_name;
    }

    public String getArea_id() {
        return area_id;
    }

    public void setArea_id(String area_id) {
        this.area_id = area_id;
    }
}
