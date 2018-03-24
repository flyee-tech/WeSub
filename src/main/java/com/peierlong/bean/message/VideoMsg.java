package com.peierlong.bean.message;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 包名: com.peierlong.entity
 * 创建人 : Elong
 * 时间: 11/15/16 3:43 PM
 * 描述 : 视频消息(包含小视频消息)
 * @author elong
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class VideoMsg extends BaseMsg {
    /**
     * 视频消息媒体id，可以调用多媒体文件下载接口拉取数据。
     */
    private String mediaId;
    /**
     * 视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。
     */
    private String thumbMediaId;

}
