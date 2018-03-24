package com.peierlong.bean.message;

import lombok.Data;

/**
 * 包名: com.peierlong.entity
 * 创建人 : Elong
 * 时间: 11/5/16 4:11 PM
 * 描述 : 消息基础类
 * @author elong
 */
@Data
public class BaseMsg {
    /**
     * 加密后的微信号，每个用户对每个公众号的OpenID是唯一的
     */
    private String ToUserName;
    /**
     * 开发者微信号, 公众号的id
     */
    private String FromUserName;
    /**
     * 消息创建时间 （整型）
     */
    private Long CreateTime;
    /**
     * 消息类型: text, image, voice, video, shortvideo, location, link, event
     */
    private String MsgType;
    /**
     * 消息id，64位整型
     */
    private Long MsgId;

}