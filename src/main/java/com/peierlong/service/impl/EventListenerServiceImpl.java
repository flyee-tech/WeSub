package com.peierlong.service.impl;

import com.peierlong.message.TextMsg;
import com.peierlong.service.ListenerService;
import com.peierlong.utils.MsgUtil;
import com.peierlong.utils.XmlUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 处理事件Service
 */
@Service
@Qualifier("event")
public class EventListenerServiceImpl implements ListenerService {

    @Value("${subscribe}")
    private String subscribe;

    @Override
    public String processListenerContent(Map<String, String> map) {
        String fromUserName = map.get("FromUserName");
        String toUserName = map.get("ToUserName");
        String event = map.get("Event");
        switch (event) {
            case "subscribe":
                TextMsg textMsg = MsgUtil.getTextMsg(toUserName, fromUserName, subscribe);
                return XmlUtil.textMsgToXml(textMsg);
            default:
                break;
        }
        return null;
    }

}
