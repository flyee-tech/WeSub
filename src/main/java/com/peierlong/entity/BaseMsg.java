package com.peierlong.entity;

/**
 * 包名: com.peierlong.entity
 * 创建人 : Elong
 * 时间: 11/5/16 4:11 PM
 * 描述 : 消息基础类
 */
public class BaseMsg {
    /*
     * 加密后的微信号，每个用户对每个公众号的OpenID是唯一的
     */
    private String openId;
    /*
     * 开发者微信号, 公众号的id
     */
    private String devWeId;
    /*
     * 消息创建时间 （整型）
     */
    private Long createTime;
    /*
     * 消息类型: text, image, voice, video, shortvideo, location, link, event
     */
    private String type;
    /*
     * 消息id，64位整型
     */
    private Long msgId;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getDevWeId() {
        return devWeId;
    }

    public void setDevWeId(String devWeId) {
        this.devWeId = devWeId;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getMsgId() {
        return msgId;
    }

    public void setMsgId(Long msgId) {
        this.msgId = msgId;
    }
}