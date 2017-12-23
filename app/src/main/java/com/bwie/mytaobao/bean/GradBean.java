package com.bwie.mytaobao.bean;

/**
 * Created by DELL on 2017/10/12.
 */

public class GradBean {
    private int imageId;
    private String textContent;

    public GradBean(int imageId, String textContent) {
        this.imageId = imageId;
        this.textContent = textContent;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }
}
