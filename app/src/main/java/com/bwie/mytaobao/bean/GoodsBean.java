package com.bwie.mytaobao.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by DELL on 2017/10/17.
 */

public class GoodsBean {

    /**
     * code : 200
     * datas : {"IsHaveBuy":0,"gift_array":[],"goods_commend_list":[{"goods_id":"100008","goods_image_url":"http://169.254.177.190/data/upload/shop/store/goods/1/1_04752627931531971_240.jpg","goods_name":"劳力士Rolex 宇宙计型迪通拿 自动机械皮带男表 正品116519 CR.TB","goods_promotion_price":"188550.00"},{"goods_id":"100001","goods_image_url":"http://169.254.177.190/data/upload/shop/store/goods/1/1_04752627707766698_240.png","goods_name":"劳力士Rolex 深海系列 自动机械钢带男士表 联保正品116660 98210","goods_promotion_price":"87500.00"},{"goods_id":"100003","goods_image_url":"http://169.254.177.190/data/upload/shop/store/goods/1/1_04752627769865296_240.jpg","goods_name":"劳力士Rolex 日志型系列 自动机械钢带男士表 联保正品 116333","goods_promotion_price":"89200.00"},{"goods_id":"100002","goods_image_url":"http://169.254.177.190/data/upload/shop/store/goods/1/1_04752627750479728_240.png","goods_name":"劳力士Rolex MILGAUSS 116400GV-72400 自动机械钢带男表联保正品","goods_promotion_price":"63200.00"},{"goods_id":"100007","goods_image_url":"http://169.254.177.190/data/upload/shop/store/goods/1/1_04752627900055146_240.png","goods_name":"劳力士Rolex 蚝式恒动系列自动机械钢带男表正品116523-8DI-78593","goods_promotion_price":"146300.00"},{"goods_id":"100000","goods_image_url":"http://169.254.177.190/data/upload/shop/store/goods/1/1_04752627678636481_240.jpg","goods_name":"劳力士ROLEX-潜航者型 116610-LV-97200自动机械钢带男表联保正品","goods_promotion_price":"70000.00"},{"goods_id":"100006","goods_image_url":"http://169.254.177.190/data/upload/shop/store/goods/1/1_04752627871532105_240.png","goods_name":"劳力士Rolex 蚝式恒动系列 自动机械钢带男表 正品116231-G-63201","goods_promotion_price":"100500.00"},{"goods_id":"100004","goods_image_url":"http://169.254.177.190/data/upload/shop/store/goods/1/1_04752627799921979_240.jpg","goods_name":"劳力士Rolex 日志型系列 自动机械钢带男表 联保正品 116233","goods_promotion_price":"97800.00"}],"goods_eval_list":[],"goods_evaluate_info":{"all":0,"bad":0,"bad_percent":0,"good":0,"good_percent":100,"good_star":5,"img":0,"normal":0,"normal_percent":0,"star_average":5},"goods_hair_info":{"area_name":"全国","content":"免运费","if_store":true,"if_store_cn":"有货"},"goods_image":"http://169.254.177.190/data/upload/shop/store/goods/1/1_04752627958339099_360.jpg","goods_info":{"areaid_1":"0","areaid_2":"0","book_buyers":"0","book_down_payment":"0.00","book_down_time":"0","book_final_payment":"0.00","buynow":1,"cart":1,"color_id":"0","contract_1":"0","contract_10":"0","contract_2":"0","contract_3":"0","contract_4":"0","contract_5":"0","contract_6":"0","contract_7":"0","contract_8":"0","contract_9":"0","contractlist":[],"evaluation_count":"0","evaluation_good_star":"5","gc_id_1":"530","gc_id_2":"540","gc_id_3":"587","goods_attr":"","goods_barcode":"","goods_click":23,"goods_collect":"0","goods_costprice":"0.00","goods_custom":"","goods_discount":"0","goods_freight":"0.00","goods_id":"100009","goods_jingle":"【雅欧国际】：所有商品全新原装正品　　","goods_marketprice":"52800.00","goods_name":"劳力士Rolex 日志型系列 116200 63200 自动机械钢带男表联保正品","goods_price":"52800.00","goods_promotion_price":"42800.00","goods_promotion_type":"1","goods_salenum":"0","goods_serial":"","goods_stcids":"","goods_storage":"100","goods_storage_alarm":"0","goods_url":"http://169.254.177.190/index.php?act=goods&op=index&goods_id=100009","goods_vat":"0","have_gift":"0","invite_rate":"0.00","is_book":"0","is_chain":"0","is_fcode":"0","is_own_shop":"1","is_presell":"0","is_virtual":"0","mobile_body":"","plateid_bottom":"0","plateid_top":"0","presell_deliverdate":"0","sole_info":[],"sup_id":"0","transport_id":"0","transport_title":"","virtual_indate":"0","virtual_invalid_refund":"0","virtual_limit":"0"},"spec_image":["http://169.254.177.190/data/upload/shop/store/goods/1/1_04752627958339099_60.jpg"],"spec_list":{"":"100009"},"store_info":{"goods_count":"10","is_own_shop":"1","member_id":"1","member_name":"admin","store_credit":{"store_deliverycredit":{"credit":"5.0","text":"物流"},"store_desccredit":{"credit":"5.0","text":"描述"},"store_servicecredit":{"credit":"5.0","text":"服务"}},"store_id":"1","store_name":"好商城V5"}}
     */

    private int code;
    private DatasBean datas;

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

    public static class DatasBean {
        /**
         * IsHaveBuy : 0
         * gift_array : []
         * goods_commend_list : [{"goods_id":"100008","goods_image_url":"http://169.254.177.190/data/upload/shop/store/goods/1/1_04752627931531971_240.jpg","goods_name":"劳力士Rolex 宇宙计型迪通拿 自动机械皮带男表 正品116519 CR.TB","goods_promotion_price":"188550.00"},{"goods_id":"100001","goods_image_url":"http://169.254.177.190/data/upload/shop/store/goods/1/1_04752627707766698_240.png","goods_name":"劳力士Rolex 深海系列 自动机械钢带男士表 联保正品116660 98210","goods_promotion_price":"87500.00"},{"goods_id":"100003","goods_image_url":"http://169.254.177.190/data/upload/shop/store/goods/1/1_04752627769865296_240.jpg","goods_name":"劳力士Rolex 日志型系列 自动机械钢带男士表 联保正品 116333","goods_promotion_price":"89200.00"},{"goods_id":"100002","goods_image_url":"http://169.254.177.190/data/upload/shop/store/goods/1/1_04752627750479728_240.png","goods_name":"劳力士Rolex MILGAUSS 116400GV-72400 自动机械钢带男表联保正品","goods_promotion_price":"63200.00"},{"goods_id":"100007","goods_image_url":"http://169.254.177.190/data/upload/shop/store/goods/1/1_04752627900055146_240.png","goods_name":"劳力士Rolex 蚝式恒动系列自动机械钢带男表正品116523-8DI-78593","goods_promotion_price":"146300.00"},{"goods_id":"100000","goods_image_url":"http://169.254.177.190/data/upload/shop/store/goods/1/1_04752627678636481_240.jpg","goods_name":"劳力士ROLEX-潜航者型 116610-LV-97200自动机械钢带男表联保正品","goods_promotion_price":"70000.00"},{"goods_id":"100006","goods_image_url":"http://169.254.177.190/data/upload/shop/store/goods/1/1_04752627871532105_240.png","goods_name":"劳力士Rolex 蚝式恒动系列 自动机械钢带男表 正品116231-G-63201","goods_promotion_price":"100500.00"},{"goods_id":"100004","goods_image_url":"http://169.254.177.190/data/upload/shop/store/goods/1/1_04752627799921979_240.jpg","goods_name":"劳力士Rolex 日志型系列 自动机械钢带男表 联保正品 116233","goods_promotion_price":"97800.00"}]
         * goods_eval_list : []
         * goods_evaluate_info : {"all":0,"bad":0,"bad_percent":0,"good":0,"good_percent":100,"good_star":5,"img":0,"normal":0,"normal_percent":0,"star_average":5}
         * goods_hair_info : {"area_name":"全国","content":"免运费","if_store":true,"if_store_cn":"有货"}
         * goods_image : http://169.254.177.190/data/upload/shop/store/goods/1/1_04752627958339099_360.jpg
         * goods_info : {"areaid_1":"0","areaid_2":"0","book_buyers":"0","book_down_payment":"0.00","book_down_time":"0","book_final_payment":"0.00","buynow":1,"cart":1,"color_id":"0","contract_1":"0","contract_10":"0","contract_2":"0","contract_3":"0","contract_4":"0","contract_5":"0","contract_6":"0","contract_7":"0","contract_8":"0","contract_9":"0","contractlist":[],"evaluation_count":"0","evaluation_good_star":"5","gc_id_1":"530","gc_id_2":"540","gc_id_3":"587","goods_attr":"","goods_barcode":"","goods_click":23,"goods_collect":"0","goods_costprice":"0.00","goods_custom":"","goods_discount":"0","goods_freight":"0.00","goods_id":"100009","goods_jingle":"【雅欧国际】：所有商品全新原装正品　　","goods_marketprice":"52800.00","goods_name":"劳力士Rolex 日志型系列 116200 63200 自动机械钢带男表联保正品","goods_price":"52800.00","goods_promotion_price":"42800.00","goods_promotion_type":"1","goods_salenum":"0","goods_serial":"","goods_stcids":"","goods_storage":"100","goods_storage_alarm":"0","goods_url":"http://169.254.177.190/index.php?act=goods&op=index&goods_id=100009","goods_vat":"0","have_gift":"0","invite_rate":"0.00","is_book":"0","is_chain":"0","is_fcode":"0","is_own_shop":"1","is_presell":"0","is_virtual":"0","mobile_body":"","plateid_bottom":"0","plateid_top":"0","presell_deliverdate":"0","sole_info":[],"sup_id":"0","transport_id":"0","transport_title":"","virtual_indate":"0","virtual_invalid_refund":"0","virtual_limit":"0"}
         * spec_image : ["http://169.254.177.190/data/upload/shop/store/goods/1/1_04752627958339099_60.jpg"]
         * spec_list : {"":"100009"}
         * store_info : {"goods_count":"10","is_own_shop":"1","member_id":"1","member_name":"admin","store_credit":{"store_deliverycredit":{"credit":"5.0","text":"物流"},"store_desccredit":{"credit":"5.0","text":"描述"},"store_servicecredit":{"credit":"5.0","text":"服务"}},"store_id":"1","store_name":"好商城V5"}
         */

        private int IsHaveBuy;
        private GoodsEvaluateInfoBean goods_evaluate_info;
        private GoodsHairInfoBean goods_hair_info;
        private String goods_image;
        private GoodsInfoBean goods_info;
        private SpecListBean spec_list;
        private StoreInfoBean store_info;
        private List<?> gift_array;
        private List<GoodsCommendListBean> goods_commend_list;
        private List<?> goods_eval_list;
        private List<String> spec_image;

        public int getIsHaveBuy() {
            return IsHaveBuy;
        }

        public void setIsHaveBuy(int IsHaveBuy) {
            this.IsHaveBuy = IsHaveBuy;
        }

        public GoodsEvaluateInfoBean getGoods_evaluate_info() {
            return goods_evaluate_info;
        }

        public void setGoods_evaluate_info(GoodsEvaluateInfoBean goods_evaluate_info) {
            this.goods_evaluate_info = goods_evaluate_info;
        }

        public GoodsHairInfoBean getGoods_hair_info() {
            return goods_hair_info;
        }

        public void setGoods_hair_info(GoodsHairInfoBean goods_hair_info) {
            this.goods_hair_info = goods_hair_info;
        }

        public String getGoods_image() {
            return goods_image;
        }

        public void setGoods_image(String goods_image) {
            this.goods_image = goods_image;
        }

        public GoodsInfoBean getGoods_info() {
            return goods_info;
        }

        public void setGoods_info(GoodsInfoBean goods_info) {
            this.goods_info = goods_info;
        }

        public SpecListBean getSpec_list() {
            return spec_list;
        }

        public void setSpec_list(SpecListBean spec_list) {
            this.spec_list = spec_list;
        }

        public StoreInfoBean getStore_info() {
            return store_info;
        }

        public void setStore_info(StoreInfoBean store_info) {
            this.store_info = store_info;
        }

        public List<?> getGift_array() {
            return gift_array;
        }

        public void setGift_array(List<?> gift_array) {
            this.gift_array = gift_array;
        }

        public List<GoodsCommendListBean> getGoods_commend_list() {
            return goods_commend_list;
        }

        public void setGoods_commend_list(List<GoodsCommendListBean> goods_commend_list) {
            this.goods_commend_list = goods_commend_list;
        }

        public List<?> getGoods_eval_list() {
            return goods_eval_list;
        }

        public void setGoods_eval_list(List<?> goods_eval_list) {
            this.goods_eval_list = goods_eval_list;
        }

        public List<String> getSpec_image() {
            return spec_image;
        }

        public void setSpec_image(List<String> spec_image) {
            this.spec_image = spec_image;
        }

        public static class GoodsEvaluateInfoBean {
            /**
             * all : 0
             * bad : 0
             * bad_percent : 0
             * good : 0
             * good_percent : 100
             * good_star : 5
             * img : 0
             * normal : 0
             * normal_percent : 0
             * star_average : 5
             */

            private int all;
            private int bad;
            private int bad_percent;
            private int good;
            private int good_percent;
            private int good_star;
            private int img;
            private int normal;
            private int normal_percent;
            private int star_average;

            public int getAll() {
                return all;
            }

            public void setAll(int all) {
                this.all = all;
            }

            public int getBad() {
                return bad;
            }

            public void setBad(int bad) {
                this.bad = bad;
            }

            public int getBad_percent() {
                return bad_percent;
            }

            public void setBad_percent(int bad_percent) {
                this.bad_percent = bad_percent;
            }

            public int getGood() {
                return good;
            }

            public void setGood(int good) {
                this.good = good;
            }

            public int getGood_percent() {
                return good_percent;
            }

            public void setGood_percent(int good_percent) {
                this.good_percent = good_percent;
            }

            public int getGood_star() {
                return good_star;
            }

            public void setGood_star(int good_star) {
                this.good_star = good_star;
            }

            public int getImg() {
                return img;
            }

            public void setImg(int img) {
                this.img = img;
            }

            public int getNormal() {
                return normal;
            }

            public void setNormal(int normal) {
                this.normal = normal;
            }

            public int getNormal_percent() {
                return normal_percent;
            }

            public void setNormal_percent(int normal_percent) {
                this.normal_percent = normal_percent;
            }

            public int getStar_average() {
                return star_average;
            }

            public void setStar_average(int star_average) {
                this.star_average = star_average;
            }
        }

        public static class GoodsHairInfoBean {
            /**
             * area_name : 全国
             * content : 免运费
             * if_store : true
             * if_store_cn : 有货
             */

            private String area_name;
            private String content;
            private boolean if_store;
            private String if_store_cn;

            public String getArea_name() {
                return area_name;
            }

            public void setArea_name(String area_name) {
                this.area_name = area_name;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public boolean isIf_store() {
                return if_store;
            }

            public void setIf_store(boolean if_store) {
                this.if_store = if_store;
            }

            public String getIf_store_cn() {
                return if_store_cn;
            }

            public void setIf_store_cn(String if_store_cn) {
                this.if_store_cn = if_store_cn;
            }
        }

        public static class GoodsInfoBean {
            /**
             * areaid_1 : 0
             * areaid_2 : 0
             * book_buyers : 0
             * book_down_payment : 0.00
             * book_down_time : 0
             * book_final_payment : 0.00
             * buynow : 1
             * cart : 1
             * color_id : 0
             * contract_1 : 0
             * contract_10 : 0
             * contract_2 : 0
             * contract_3 : 0
             * contract_4 : 0
             * contract_5 : 0
             * contract_6 : 0
             * contract_7 : 0
             * contract_8 : 0
             * contract_9 : 0
             * contractlist : []
             * evaluation_count : 0
             * evaluation_good_star : 5
             * gc_id_1 : 530
             * gc_id_2 : 540
             * gc_id_3 : 587
             * goods_attr :
             * goods_barcode :
             * goods_click : 23
             * goods_collect : 0
             * goods_costprice : 0.00
             * goods_custom :
             * goods_discount : 0
             * goods_freight : 0.00
             * goods_id : 100009
             * goods_jingle : 【雅欧国际】：所有商品全新原装正品　　
             * goods_marketprice : 52800.00
             * goods_name : 劳力士Rolex 日志型系列 116200 63200 自动机械钢带男表联保正品
             * goods_price : 52800.00
             * goods_promotion_price : 42800.00
             * goods_promotion_type : 1
             * goods_salenum : 0
             * goods_serial :
             * goods_stcids :
             * goods_storage : 100
             * goods_storage_alarm : 0
             * goods_url : http://169.254.177.190/index.php?act=goods&op=index&goods_id=100009
             * goods_vat : 0
             * have_gift : 0
             * invite_rate : 0.00
             * is_book : 0
             * is_chain : 0
             * is_fcode : 0
             * is_own_shop : 1
             * is_presell : 0
             * is_virtual : 0
             * mobile_body :
             * plateid_bottom : 0
             * plateid_top : 0
             * presell_deliverdate : 0
             * sole_info : []
             * sup_id : 0
             * transport_id : 0
             * transport_title :
             * virtual_indate : 0
             * virtual_invalid_refund : 0
             * virtual_limit : 0
             */

            private String areaid_1;
            private String areaid_2;
            private String book_buyers;
            private String book_down_payment;
            private String book_down_time;
            private String book_final_payment;
            private int buynow;
            private int cart;
            private String color_id;
            private String contract_1;
            private String contract_10;
            private String contract_2;
            private String contract_3;
            private String contract_4;
            private String contract_5;
            private String contract_6;
            private String contract_7;
            private String contract_8;
            private String contract_9;
            private String evaluation_count;
            private String evaluation_good_star;
            private String gc_id_1;
            private String gc_id_2;
            private String gc_id_3;
            private String goods_attr;
            private String goods_barcode;
            private int goods_click;
            private String goods_collect;
            private String goods_costprice;
            private String goods_custom;
            private String goods_discount;
            private String goods_freight;
            private String goods_id;
            private String goods_jingle;
            private String goods_marketprice;
            private String goods_name;
            private String goods_price;
            private String goods_promotion_price;
            private String goods_promotion_type;
            private String goods_salenum;
            private String goods_serial;
            private String goods_stcids;
            private String goods_storage;
            private String goods_storage_alarm;
            private String goods_url;
            private String goods_vat;
            private String have_gift;
            private String invite_rate;
            private String is_book;
            private String is_chain;
            private String is_fcode;
            private String is_own_shop;
            private String is_presell;
            private String is_virtual;
            private String mobile_body;
            private String plateid_bottom;
            private String plateid_top;
            private String presell_deliverdate;
            private String sup_id;
            private String transport_id;
            private String transport_title;
            private String virtual_indate;
            private String virtual_invalid_refund;
            private String virtual_limit;
            private List<?> contractlist;
            private List<?> sole_info;

            public String getAreaid_1() {
                return areaid_1;
            }

            public void setAreaid_1(String areaid_1) {
                this.areaid_1 = areaid_1;
            }

            public String getAreaid_2() {
                return areaid_2;
            }

            public void setAreaid_2(String areaid_2) {
                this.areaid_2 = areaid_2;
            }

            public String getBook_buyers() {
                return book_buyers;
            }

            public void setBook_buyers(String book_buyers) {
                this.book_buyers = book_buyers;
            }

            public String getBook_down_payment() {
                return book_down_payment;
            }

            public void setBook_down_payment(String book_down_payment) {
                this.book_down_payment = book_down_payment;
            }

            public String getBook_down_time() {
                return book_down_time;
            }

            public void setBook_down_time(String book_down_time) {
                this.book_down_time = book_down_time;
            }

            public String getBook_final_payment() {
                return book_final_payment;
            }

            public void setBook_final_payment(String book_final_payment) {
                this.book_final_payment = book_final_payment;
            }

            public int getBuynow() {
                return buynow;
            }

            public void setBuynow(int buynow) {
                this.buynow = buynow;
            }

            public int getCart() {
                return cart;
            }

            public void setCart(int cart) {
                this.cart = cart;
            }

            public String getColor_id() {
                return color_id;
            }

            public void setColor_id(String color_id) {
                this.color_id = color_id;
            }

            public String getContract_1() {
                return contract_1;
            }

            public void setContract_1(String contract_1) {
                this.contract_1 = contract_1;
            }

            public String getContract_10() {
                return contract_10;
            }

            public void setContract_10(String contract_10) {
                this.contract_10 = contract_10;
            }

            public String getContract_2() {
                return contract_2;
            }

            public void setContract_2(String contract_2) {
                this.contract_2 = contract_2;
            }

            public String getContract_3() {
                return contract_3;
            }

            public void setContract_3(String contract_3) {
                this.contract_3 = contract_3;
            }

            public String getContract_4() {
                return contract_4;
            }

            public void setContract_4(String contract_4) {
                this.contract_4 = contract_4;
            }

            public String getContract_5() {
                return contract_5;
            }

            public void setContract_5(String contract_5) {
                this.contract_5 = contract_5;
            }

            public String getContract_6() {
                return contract_6;
            }

            public void setContract_6(String contract_6) {
                this.contract_6 = contract_6;
            }

            public String getContract_7() {
                return contract_7;
            }

            public void setContract_7(String contract_7) {
                this.contract_7 = contract_7;
            }

            public String getContract_8() {
                return contract_8;
            }

            public void setContract_8(String contract_8) {
                this.contract_8 = contract_8;
            }

            public String getContract_9() {
                return contract_9;
            }

            public void setContract_9(String contract_9) {
                this.contract_9 = contract_9;
            }

            public String getEvaluation_count() {
                return evaluation_count;
            }

            public void setEvaluation_count(String evaluation_count) {
                this.evaluation_count = evaluation_count;
            }

            public String getEvaluation_good_star() {
                return evaluation_good_star;
            }

            public void setEvaluation_good_star(String evaluation_good_star) {
                this.evaluation_good_star = evaluation_good_star;
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

            public String getGoods_attr() {
                return goods_attr;
            }

            public void setGoods_attr(String goods_attr) {
                this.goods_attr = goods_attr;
            }

            public String getGoods_barcode() {
                return goods_barcode;
            }

            public void setGoods_barcode(String goods_barcode) {
                this.goods_barcode = goods_barcode;
            }

            public int getGoods_click() {
                return goods_click;
            }

            public void setGoods_click(int goods_click) {
                this.goods_click = goods_click;
            }

            public String getGoods_collect() {
                return goods_collect;
            }

            public void setGoods_collect(String goods_collect) {
                this.goods_collect = goods_collect;
            }

            public String getGoods_costprice() {
                return goods_costprice;
            }

            public void setGoods_costprice(String goods_costprice) {
                this.goods_costprice = goods_costprice;
            }

            public String getGoods_custom() {
                return goods_custom;
            }

            public void setGoods_custom(String goods_custom) {
                this.goods_custom = goods_custom;
            }

            public String getGoods_discount() {
                return goods_discount;
            }

            public void setGoods_discount(String goods_discount) {
                this.goods_discount = goods_discount;
            }

            public String getGoods_freight() {
                return goods_freight;
            }

            public void setGoods_freight(String goods_freight) {
                this.goods_freight = goods_freight;
            }

            public String getGoods_id() {
                return goods_id;
            }

            public void setGoods_id(String goods_id) {
                this.goods_id = goods_id;
            }

            public String getGoods_jingle() {
                return goods_jingle;
            }

            public void setGoods_jingle(String goods_jingle) {
                this.goods_jingle = goods_jingle;
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

            public String getGoods_price() {
                return goods_price;
            }

            public void setGoods_price(String goods_price) {
                this.goods_price = goods_price;
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

            public String getGoods_salenum() {
                return goods_salenum;
            }

            public void setGoods_salenum(String goods_salenum) {
                this.goods_salenum = goods_salenum;
            }

            public String getGoods_serial() {
                return goods_serial;
            }

            public void setGoods_serial(String goods_serial) {
                this.goods_serial = goods_serial;
            }

            public String getGoods_stcids() {
                return goods_stcids;
            }

            public void setGoods_stcids(String goods_stcids) {
                this.goods_stcids = goods_stcids;
            }

            public String getGoods_storage() {
                return goods_storage;
            }

            public void setGoods_storage(String goods_storage) {
                this.goods_storage = goods_storage;
            }

            public String getGoods_storage_alarm() {
                return goods_storage_alarm;
            }

            public void setGoods_storage_alarm(String goods_storage_alarm) {
                this.goods_storage_alarm = goods_storage_alarm;
            }

            public String getGoods_url() {
                return goods_url;
            }

            public void setGoods_url(String goods_url) {
                this.goods_url = goods_url;
            }

            public String getGoods_vat() {
                return goods_vat;
            }

            public void setGoods_vat(String goods_vat) {
                this.goods_vat = goods_vat;
            }

            public String getHave_gift() {
                return have_gift;
            }

            public void setHave_gift(String have_gift) {
                this.have_gift = have_gift;
            }

            public String getInvite_rate() {
                return invite_rate;
            }

            public void setInvite_rate(String invite_rate) {
                this.invite_rate = invite_rate;
            }

            public String getIs_book() {
                return is_book;
            }

            public void setIs_book(String is_book) {
                this.is_book = is_book;
            }

            public String getIs_chain() {
                return is_chain;
            }

            public void setIs_chain(String is_chain) {
                this.is_chain = is_chain;
            }

            public String getIs_fcode() {
                return is_fcode;
            }

            public void setIs_fcode(String is_fcode) {
                this.is_fcode = is_fcode;
            }

            public String getIs_own_shop() {
                return is_own_shop;
            }

            public void setIs_own_shop(String is_own_shop) {
                this.is_own_shop = is_own_shop;
            }

            public String getIs_presell() {
                return is_presell;
            }

            public void setIs_presell(String is_presell) {
                this.is_presell = is_presell;
            }

            public String getIs_virtual() {
                return is_virtual;
            }

            public void setIs_virtual(String is_virtual) {
                this.is_virtual = is_virtual;
            }

            public String getMobile_body() {
                return mobile_body;
            }

            public void setMobile_body(String mobile_body) {
                this.mobile_body = mobile_body;
            }

            public String getPlateid_bottom() {
                return plateid_bottom;
            }

            public void setPlateid_bottom(String plateid_bottom) {
                this.plateid_bottom = plateid_bottom;
            }

            public String getPlateid_top() {
                return plateid_top;
            }

            public void setPlateid_top(String plateid_top) {
                this.plateid_top = plateid_top;
            }

            public String getPresell_deliverdate() {
                return presell_deliverdate;
            }

            public void setPresell_deliverdate(String presell_deliverdate) {
                this.presell_deliverdate = presell_deliverdate;
            }

            public String getSup_id() {
                return sup_id;
            }

            public void setSup_id(String sup_id) {
                this.sup_id = sup_id;
            }

            public String getTransport_id() {
                return transport_id;
            }

            public void setTransport_id(String transport_id) {
                this.transport_id = transport_id;
            }

            public String getTransport_title() {
                return transport_title;
            }

            public void setTransport_title(String transport_title) {
                this.transport_title = transport_title;
            }

            public String getVirtual_indate() {
                return virtual_indate;
            }

            public void setVirtual_indate(String virtual_indate) {
                this.virtual_indate = virtual_indate;
            }

            public String getVirtual_invalid_refund() {
                return virtual_invalid_refund;
            }

            public void setVirtual_invalid_refund(String virtual_invalid_refund) {
                this.virtual_invalid_refund = virtual_invalid_refund;
            }

            public String getVirtual_limit() {
                return virtual_limit;
            }

            public void setVirtual_limit(String virtual_limit) {
                this.virtual_limit = virtual_limit;
            }

            public List<?> getContractlist() {
                return contractlist;
            }

            public void setContractlist(List<?> contractlist) {
                this.contractlist = contractlist;
            }

            public List<?> getSole_info() {
                return sole_info;
            }

            public void setSole_info(List<?> sole_info) {
                this.sole_info = sole_info;
            }
        }

        public static class SpecListBean {
            /**
             *  : 100009
             */

            @SerializedName("")
            private String _$181; // FIXME check this code

            public String get_$181() {
                return _$181;
            }

            public void set_$181(String _$181) {
                this._$181 = _$181;
            }
        }

        public static class StoreInfoBean {
            /**
             * goods_count : 10
             * is_own_shop : 1
             * member_id : 1
             * member_name : admin
             * store_credit : {"store_deliverycredit":{"credit":"5.0","text":"物流"},"store_desccredit":{"credit":"5.0","text":"描述"},"store_servicecredit":{"credit":"5.0","text":"服务"}}
             * store_id : 1
             * store_name : 好商城V5
             */

            private String goods_count;
            private String is_own_shop;
            private String member_id;
            private String member_name;
            private StoreCreditBean store_credit;
            private String store_id;
            private String store_name;

            public String getGoods_count() {
                return goods_count;
            }

            public void setGoods_count(String goods_count) {
                this.goods_count = goods_count;
            }

            public String getIs_own_shop() {
                return is_own_shop;
            }

            public void setIs_own_shop(String is_own_shop) {
                this.is_own_shop = is_own_shop;
            }

            public String getMember_id() {
                return member_id;
            }

            public void setMember_id(String member_id) {
                this.member_id = member_id;
            }

            public String getMember_name() {
                return member_name;
            }

            public void setMember_name(String member_name) {
                this.member_name = member_name;
            }

            public StoreCreditBean getStore_credit() {
                return store_credit;
            }

            public void setStore_credit(StoreCreditBean store_credit) {
                this.store_credit = store_credit;
            }

            public String getStore_id() {
                return store_id;
            }

            public void setStore_id(String store_id) {
                this.store_id = store_id;
            }

            public String getStore_name() {
                return store_name;
            }

            public void setStore_name(String store_name) {
                this.store_name = store_name;
            }

            public static class StoreCreditBean {
                /**
                 * store_deliverycredit : {"credit":"5.0","text":"物流"}
                 * store_desccredit : {"credit":"5.0","text":"描述"}
                 * store_servicecredit : {"credit":"5.0","text":"服务"}
                 */

                private StoreDeliverycreditBean store_deliverycredit;
                private StoreDesccreditBean store_desccredit;
                private StoreServicecreditBean store_servicecredit;

                public StoreDeliverycreditBean getStore_deliverycredit() {
                    return store_deliverycredit;
                }

                public void setStore_deliverycredit(StoreDeliverycreditBean store_deliverycredit) {
                    this.store_deliverycredit = store_deliverycredit;
                }

                public StoreDesccreditBean getStore_desccredit() {
                    return store_desccredit;
                }

                public void setStore_desccredit(StoreDesccreditBean store_desccredit) {
                    this.store_desccredit = store_desccredit;
                }

                public StoreServicecreditBean getStore_servicecredit() {
                    return store_servicecredit;
                }

                public void setStore_servicecredit(StoreServicecreditBean store_servicecredit) {
                    this.store_servicecredit = store_servicecredit;
                }

                public static class StoreDeliverycreditBean {
                    /**
                     * credit : 5.0
                     * text : 物流
                     */

                    private String credit;
                    private String text;

                    public String getCredit() {
                        return credit;
                    }

                    public void setCredit(String credit) {
                        this.credit = credit;
                    }

                    public String getText() {
                        return text;
                    }

                    public void setText(String text) {
                        this.text = text;
                    }
                }

                public static class StoreDesccreditBean {
                    /**
                     * credit : 5.0
                     * text : 描述
                     */

                    private String credit;
                    private String text;

                    public String getCredit() {
                        return credit;
                    }

                    public void setCredit(String credit) {
                        this.credit = credit;
                    }

                    public String getText() {
                        return text;
                    }

                    public void setText(String text) {
                        this.text = text;
                    }
                }

                public static class StoreServicecreditBean {
                    /**
                     * credit : 5.0
                     * text : 服务
                     */

                    private String credit;
                    private String text;

                    public String getCredit() {
                        return credit;
                    }

                    public void setCredit(String credit) {
                        this.credit = credit;
                    }

                    public String getText() {
                        return text;
                    }

                    public void setText(String text) {
                        this.text = text;
                    }
                }
            }
        }

        public static class GoodsCommendListBean {
            /**
             * goods_id : 100008
             * goods_image_url : http://169.254.177.190/data/upload/shop/store/goods/1/1_04752627931531971_240.jpg
             * goods_name : 劳力士Rolex 宇宙计型迪通拿 自动机械皮带男表 正品116519 CR.TB
             * goods_promotion_price : 188550.00
             */

            private String goods_id;
            private String goods_image_url;
            private String goods_name;
            private String goods_promotion_price;

            public String getGoods_id() {
                return goods_id;
            }

            public void setGoods_id(String goods_id) {
                this.goods_id = goods_id;
            }

            public String getGoods_image_url() {
                return goods_image_url;
            }

            public void setGoods_image_url(String goods_image_url) {
                this.goods_image_url = goods_image_url;
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
        }
    }
}
