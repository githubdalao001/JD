package com.bwie.mytaobao.bean;

/**
 * Created by DELL on 2017/11/14.
 */

public class EventBusMessage {
    private String key;
    private String true_name;
    private String mob_phone;
    private String city_id;
    private String area_id;
    private String address;
    private String area_info;
    private String is_default;
    private String address_id;
    private int position;
    private boolean flag;
    public EventBusMessage(String key, String true_name, String mob_phone, String city_id, String area_id, String address, String area_info, String is_default, String address_id,int position,boolean flag) {
        this.key = key;
        this.true_name = true_name;
        this.mob_phone = mob_phone;
        this.city_id = city_id;
        this.area_id = area_id;
        this.address = address;
        this.area_info = area_info;
        this.is_default = is_default;
        this.address_id = address_id;
        this.position = position;
        this.flag = flag;
    }

    public EventBusMessage(int position, boolean flag) {
        this.position = position;
        this.flag = flag;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTrue_name() {
        return true_name;
    }

    public void setTrue_name(String true_name) {
        this.true_name = true_name;
    }

    public String getMob_phone() {
        return mob_phone;
    }

    public void setMob_phone(String mob_phone) {
        this.mob_phone = mob_phone;
    }

    public String getCity_id() {
        return city_id;
    }

    public void setCity_id(String city_id) {
        this.city_id = city_id;
    }

    public String getArea_id() {
        return area_id;
    }

    public void setArea_id(String area_id) {
        this.area_id = area_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getArea_info() {
        return area_info;
    }

    public void setArea_info(String area_info) {
        this.area_info = area_info;
    }

    public String getIs_default() {
        return is_default;
    }

    public void setIs_default(String is_default) {
        this.is_default = is_default;
    }

    public String getAddress_id() {
        return address_id;
    }

    public void setAddress_id(String address_id) {
        this.address_id = address_id;
    }
}
