package com.peierlong.message;

/**
 * 包名: com.peierlong.entity
 * 创建人 : Elong
 * 时间: 11/15/16 3:43 PM
 * 描述 : 视频消息(包含小视频消息)
 */
public class VideoMsg extends BaseMsg {
    /*
     * 视频消息媒体id，可以调用多媒体文件下载接口拉取数据。
     */
    private String mediaId;
    /*
     * 视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。
     */
    private String thumbMediaId;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }

}
