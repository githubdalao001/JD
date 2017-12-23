package com.bwie.mytaobao.bean;

import java.util.List;

/**
 * Created by DELL on 2017/11/17.
 */

public class SaveBean {

    /**
     * code : 200
     * hasmore : false
     * page_total : 1
     * datas : {"favorites_list":[{"goods_id":"100002","goods_name":"劳力士Rolex MILGAUSS 116400GV-72400 自动机械钢带男表联保正品","goods_image":"1_04752627750479728.png","store_id":"1","fav_id":"100002","goods_image_url":"http://169.254.206.40/data/upload/shop/store/goods/1/1_04752627750479728_240.png","goods_price":"63200.00"},{"goods_id":"100003","goods_name":"劳力士Rolex 日志型系列 自动机械钢带男士表 联保正品 116333","goods_image":"1_04752627769865296.jpg","store_id":"1","fav_id":"100003","goods_image_url":"http://169.254.206.40/data/upload/shop/store/goods/1/1_04752627769865296_240.jpg","goods_price":"89200.00"},{"goods_id":"100006","goods_name":"劳力士Rolex 蚝式恒动系列 自动机械钢带男表 正品116231-G-63201","goods_image":"1_04752627871532105.png","store_id":"1","fav_id":"100006","goods_image_url":"http://169.254.206.40/data/upload/shop/store/goods/1/1_04752627871532105_240.png","goods_price":"100500.00"},{"goods_id":"100007","goods_name":"劳力士Rolex 蚝式恒动系列自动机械钢带男表正品116523-8DI-78593","goods_image":"1_04752627900055146.png","store_id":"1","fav_id":"100007","goods_image_url":"http://169.254.206.40/data/upload/shop/store/goods/1/1_04752627900055146_240.png","goods_price":"146300.00"},{"goods_id":"100009","goods_name":"劳力士Rolex 日志型系列 116200 63200 自动机械钢带男表联保正品","goods_image":"1_04752627958339099.jpg","store_id":"1","fav_id":"100009","goods_image_url":"http://169.254.206.40/data/upload/shop/store/goods/1/1_04752627958339099_240.jpg","goods_price":"42800.00"}]}
     */

    private int code;
    private boolean hasmore;
    private int page_total;
    private DatasBean datas;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isHasmore() {
        return hasmore;
    }

    public void setHasmore(boolean hasmore) {
        this.hasmore = hasmore;
    }

    public int getPage_total() {
        return page_total;
    }

    public void setPage_total(int page_total) {
        this.page_total = page_total;
    }

    public DatasBean getDatas() {
        return datas;
    }

    public void setDatas(DatasBean datas) {
        this.datas = datas;
    }

    public static class DatasBean {
        private List<FavoritesListBean> favorites_list;

        public List<FavoritesListBean> getFavorites_list() {
            return favorites_list;
        }

        public void setFavorites_list(List<FavoritesListBean> favorites_list) {
            this.favorites_list = favorites_list;
        }

        public static class FavoritesListBean {
            /**
             * goods_id : 100002
             * goods_name : 劳力士Rolex MILGAUSS 116400GV-72400 自动机械钢带男表联保正品
             * goods_image : 1_04752627750479728.png
             * store_id : 1
             * fav_id : 100002
             * goods_image_url : http://169.254.206.40/data/upload/shop/store/goods/1/1_04752627750479728_240.png
             * goods_price : 63200.00
             */

            private String goods_id;
            private String goods_name;
            private String goods_image;
            private String store_id;
            private String fav_id;
            private String goods_image_url;
            private String goods_price;

            public String getGoods_id() {
                return goods_id;
            }

            public void setGoods_id(String goods_id) {
                this.goods_id = goods_id;
            }

            public String getGoods_name() {
                return goods_name;
            }

            public void setGoods_name(String goods_name) {
                this.goods_name = goods_name;
            }

            public String getGoods_image() {
                return goods_image;
            }

            public void setGoods_image(String goods_image) {
                this.goods_image = goods_image;
            }

            public String getStore_id() {
                return store_id;
            }

            public void setStore_id(String store_id) {
                this.store_id = store_id;
            }

            public String getFav_id() {
                return fav_id;
            }

            public void setFav_id(String fav_id) {
                this.fav_id = fav_id;
            }

            public String getGoods_image_url() {
                return goods_image_url;
            }

            public void setGoods_image_url(String goods_image_url) {
                this.goods_image_url = goods_image_url;
            }

            public String getGoods_price() {
                return goods_price;
            }

            public void setGoods_price(String goods_price) {
                this.goods_price = goods_price;
            }
        }
    }
}
