package com.android.WorkOutDay23.bean;

public class SportBean {
    private int imgId;
    private String name;
    private String linkUrl;
    private String desc;

    public int getImg() {
        return imgId;
    }

    public void setImg(int img) {
        this.imgId = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
