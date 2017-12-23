package com.bwie.mytaobao.bean;

/**
 * Created by DELL on 2017/10/18.
 */

public class LZUserInfoBean {

    /**
     * code : 200
     * datas : {"username":"123456789a","userid":"15","key":"1eb97fd8e10cdbe6acb6b4950e59fbb5"}
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
         * username : 123456789a
         * userid : 15
         * key : 1eb97fd8e10cdbe6acb6b4950e59fbb5
         */

        private String username;
        private String userid;
        private String key;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getUserid() {
            return userid;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }
    }
}
