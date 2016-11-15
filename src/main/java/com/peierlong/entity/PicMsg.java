package com.peierlong.entity;

/**
 * 包名: com.peierlong.entity
 * 创建人 : Elong
 * 时间: 11/5/16 5:25 PM
 * 描述 : 图片消息实体类
 */
public class PicMsg extends BaseMsg {
    /*
     * 图片链接
     */
    private String picUrl;
    /*
     * 图片消息媒体id
     */
    private String mediaId;

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

}
