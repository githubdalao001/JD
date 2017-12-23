package com.bwie.mytaobao.bean;

import java.util.List;

/**
 * Created by DELL on 2017/11/16.
 */

public class ZuJiBean {

    /**
     * code : 200
     * datas : {"goodsbrowse_list":[{"browsetime":"1510818807","browsetime_day":"今天","browsetime_text":"今天15:53","gc_id":"587","gc_id_1":"530","gc_id_2":"540","gc_id_3":"587","goods_id":"100004","goods_image":"1_04752627799921979.jpg","goods_image_url":"http://169.254.206.40/data/upload/shop/store/goods/1/1_04752627799921979_360.jpg","goods_marketprice":"97800.00","goods_name":"劳力士Rolex 日志型系列 自动机械钢带男表 联保正品 116233","goods_promotion_price":"97800.00","goods_promotion_type":"0","store_id":"1"},{"browsetime":"1510818802","browsetime_day":"今天","browsetime_text":"今天15:53","gc_id":"587","gc_id_1":"530","gc_id_2":"540","gc_id_3":"587","goods_id":"100000","goods_image":"1_04752627678636481.jpg","goods_image_url":"http://169.254.206.40/data/upload/shop/store/goods/1/1_04752627678636481_360.jpg","goods_marketprice":"70000.00","goods_name":"劳力士ROLEX-潜航者型 116610-LV-97200自动机械钢带男表联保正品","goods_promotion_price":"70000.00","goods_promotion_type":"0","store_id":"1"},{"browsetime":"1510818722","browsetime_day":"今天","browsetime_text":"今天15:52","gc_id":"587","gc_id_1":"530","gc_id_2":"540","gc_id_3":"587","goods_id":"100009","goods_image":"1_04752627958339099.jpg","goods_image_url":"http://169.254.206.40/data/upload/shop/store/goods/1/1_04752627958339099_360.jpg","goods_marketprice":"52800.00","goods_name":"劳力士Rolex 日志型系列 116200 63200 自动机械钢带男表联保正品","goods_promotion_price":"42800.00","goods_promotion_type":"1","store_id":"1"},{"browsetime":"1510818717","browsetime_day":"今天","browsetime_text":"今天15:51","gc_id":"587","gc_id_1":"530","gc_id_2":"540","gc_id_3":"587","goods_id":"100006","goods_image":"1_04752627871532105.png","goods_image_url":"http://169.254.206.40/data/upload/shop/store/goods/1/1_04752627871532105_360.png","goods_marketprice":"100500.00","goods_name":"劳力士Rolex 蚝式恒动系列 自动机械钢带男表 正品116231-G-63201","goods_promotion_price":"100500.00","goods_promotion_type":"0","store_id":"1"},{"browsetime":"1510818711","browsetime_day":"今天","browsetime_text":"今天15:51","gc_id":"587","gc_id_1":"530","gc_id_2":"540","gc_id_3":"587","goods_id":"100007","goods_image":"1_04752627900055146.png","goods_image_url":"http://169.254.206.40/data/upload/shop/store/goods/1/1_04752627900055146_360.png","goods_marketprice":"146300.00","goods_name":"劳力士Rolex 蚝式恒动系列自动机械钢带男表正品116523-8DI-78593","goods_promotion_price":"146300.00","goods_promotion_type":"0","store_id":"1"}]}
     * hasmore : false
     * page_total : 1
     */

    private int code;
    private DatasBean datas;
    private boolean hasmore;
    private int page_total;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DatasBean getDatas() {
        return datas;
    }

    public void setDatas(DatasBean datas) {
        this.datas = datas;
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

    public static class DatasBean {
        private List<GoodsbrowseListBean> goodsbrowse_list;

        public List<GoodsbrowseListBean> getGoodsbrowse_list() {
            return goodsbrowse_list;
        }

        public void setGoodsbrowse_list(List<GoodsbrowseListBean> goodsbrowse_list) {
            this.goodsbrowse_list = goodsbrowse_list;
        }

        public static class GoodsbrowseListBean {
            /**
             * browsetime : 1510818807
             * browsetime_day : 今天
             * browsetime_text : 今天15:53
             * gc_id : 587
             * gc_id_1 : 530
             * gc_id_2 : 540
             * gc_id_3 : 587
             * goods_id : 100004
             * goods_image : 1_04752627799921979.jpg
             * goods_image_url : http://169.254.206.40/data/upload/shop/store/goods/1/1_04752627799921979_360.jpg
             * goods_marketprice : 97800.00
             * goods_name : 劳力士Rolex 日志型系列 自动机械钢带男表 联保正品 116233
             * goods_promotion_price : 97800.00
             * goods_promotion_type : 0
             * store_id : 1
             */

            private String browsetime;
            private String browsetime_day;
            private String browsetime_text;
            private String gc_id;
            private String gc_id_1;
            private String gc_id_2;
            private String gc_id_3;
            private String goods_id;
            private String goods_image;
            private String goods_image_url;
            private String goods_marketprice;
            private String goods_name;
            private String goods_promotion_price;
            private String goods_promotion_type;
            private String store_id;

            public String getBrowsetime() {
                return browsetime;
            }

            public void setBrowsetime(String browsetime) {
                this.browsetime = browsetime;
            }

            public String getBrowsetime_day() {
                return browsetime_day;
            }

            public void setBrowsetime_day(String browsetime_day) {
                this.browsetime_day = browsetime_day;
            }

            public String getBrowsetime_text() {
                return browsetime_text;
            }

            public void setBrowsetime_text(String browsetime_text) {
                this.browsetime_text = browsetime_text;
            }

            public String getGc_id() {
                return gc_id;
            }

            public void setGc_id(String gc_id) {
                this.gc_id = gc_id;
            }

            public String getGc_id_1() {
                return gc_id_1;
            }

            public void setGc_id_1(String gc_id_1) {
                this.gc_id_1 = gc_id_1;
            }

            public String getGc_id_2() {
                return gc_id_2;
            }

            public void setGc_id_2(String gc_id_2) {
                this.gc_id_2 = gc_id_2;
            }

            public String getGc_id_3() {
                return gc_id_3;
            }

            public void setGc_id_3(String gc_id_3) {
                this.gc_id_3 = gc_id_3;
            }

            public String getGoods_id() {
                return goods_id;
            }

            public void setGoods_id(String goods_id) {
                this.goods_id = goods_id;
            }

            public String getGoods_image() {
                return goods_image;
            }

            public void setGoods_image(String goods_image) {
                this.goods_image = goods_image;
            }

            public String getGoods_image_url() {
                return goods_image_url;
            }

            public void setGoods_image_url(String goods_image_url) {
                this.goods_image_url = goods_image_url;
            }

            public String getGoods_marketprice() {
                return goods_marketprice;
            }

            public void setGoods_marketprice(String goods_marketprice) {
                this.goods_marketprice = goods_marketprice;
            }

            public String getGoods_name() {
                return goods_name;
            }

            public void setGoods_name(String goods_name) {
                this.goods_name = goods_name;
            }

            public String getGoods_promotion_price() {
                return goods_promotion_price;
            }

            public void setGoods_promotion_price(String goods_promotion_price) {
                this.goods_promotion_price = goods_promotion_price;
            }

            public String getGoods_promotion_type() {
                return goods_promotion_type;
            }

            public void setGoods_promotion_type(String goods_promotion_type) {
                this.goods_promotion_type = goods_promotion_type;
            }

            public String getStore_id() {
                return store_id;
            }

            public void setStore_id(String store_id) {
                this.store_id = store_id;
            }
        }
    }
}
