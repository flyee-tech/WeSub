package com.peierlong.utils;

import com.peierlong.message.TextMsg;

import java.util.Date;

/**
 * 包名: com.peierlong.utils
 * 创建人 : Elong
 * 时间: 2016/12/9 下午5:03
 * 描述 : 消息工具类
 */
public class MsgUtil {

    public static TextMsg getTextMsg(String fromUserName, String toUserName, String content){
        TextMsg msg = new TextMsg();
        msg.setCreateTime(new Date().getTime());
        msg.setMsgType(GlobalConstant.MESSAGE_TYPE_TEXT);
        msg.setFromUserName(fromUserName);
        msg.setToUserName(toUserName);
        msg.setContent(content);
        return msg;
    }

}
