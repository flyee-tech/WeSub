package com.peierlong.bean.message;

import lombok.Data;

/**
 * 包名: com.peierlong.entity
 * 创建人 : Elong
 * 时间: 11/5/16 5:25 PM
 * 描述 : 图片消息实体类
 * @author elong
 */
@Data
public class PicMsg extends BaseMsg {
    /**
     * 图片链接
     */
    private String picUrl;
    /**
     * 图片消息媒体id
     */
    private String mediaId;

}
