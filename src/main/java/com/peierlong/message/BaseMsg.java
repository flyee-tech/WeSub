package com.peierlong.message;

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
    private String ToUserName;
    /*
     * 开发者微信号, 公众号的id
     */
    private String FromUserName;
    /*
     * 消息创建时间 （整型）
     */
    private Long CreateTime;
    /*
     * 消息类型: text, image, voice, video, shortvideo, location, link, event
     */
    private String MsgType;
    /*
     * 消息id，64位整型
     */
    private Long MsgId;

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        this.ToUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.FromUserName = fromUserName;
    }

    public Long getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(Long createTime) {
        this.CreateTime = createTime;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        this.MsgType = msgType;
    }

    public Long getMsgId() {
        return MsgId;
    }

    public void setMsgId(Long msgId) {
        this.MsgId = msgId;
    }
}