package com.peierlong.utils;

/**
 * 包名: com.peierlong.utils
 * 创建人 : Elong
 * 时间: 2016/11/17 下午11:14
 * 描述 : 全局常量类
 */
public interface GlobalConstant {
    /**
     * 对回调不处理默认返回串
     */
    String SUCCESS = "success";

    /**
     * 消息类型：文本
     */
    String MESSAGE_TYPE_TEXT = "text";

    /**
     * 消息类型：音乐
     */
    String MESSAGE_TYPE_MUSIC = "music";

    /**
     * 消息类型：图文
     */
    String MESSAGE_TYPE_NEWS = "news";

    /**
     * 消息类型：图片
     */
    String MESSAGE_TYPE_IMAGE = "image";

    /**
     * 消息类型：链接
     */
    String MESSAGE_TYPE_LINK = "link";

    /**
     * 消息类型：地理位置
     */
    String MESSAGE_TYPE_LOCATION = "location";

    /**
     * 消息类型：音频
     */
    String MESSAGE_TYPE_VOICE = "voice";

    /**
     * 消息类型：推送
     */
    String MESSAGE_TYPE_EVENT = "event";

    /**
     * 事件类型：subscribe(订阅)
     */
    String EVENT_TYPE_SUBSCRIBE = "subscribe";

    /**
     * 事件类型：unsubscribe(取消订阅)
     */
    String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";

    /**
     * 事件类型：CLICK(自定义菜单点击事件)
     */
    String EVENT_TYPE_CLICK = "CLICK";

    String REQUEST_FAILED = "请求失败, 系统异常";

}
