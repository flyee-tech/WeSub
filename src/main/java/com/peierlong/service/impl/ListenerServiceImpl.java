package com.peierlong.service.impl;

import com.peierlong.service.ListenerService;
import com.peierlong.utils.GlobalConstant;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 包名: com.peierlong.service.impl
 * 创建人 : Elong
 * 时间: 2016/11/17 下午6:36
 * 描述 : 业务处理层
 */
@Service
public class ListenerServiceImpl implements ListenerService {

    @Override
    public String processListenerContent(Map<String, String> map) {

        String openId = map.get("FromUserName");
        String devWeId = map.get("ToUserName");

        switch (map.get("msgType")) {
            case GlobalConstant.REQ_MESSAGE_TYPE_EVENT: // 事件
                break;
            case GlobalConstant.REQ_MESSAGE_TYPE_TEXT:  // 文本
                break;
            case GlobalConstant.REQ_MESSAGE_TYPE_IMAGE: // 图片
                break;
            case GlobalConstant.REQ_MESSAGE_TYPE_VOICE: // 音频
                break;
            case GlobalConstant.REQ_MESSAGE_TYPE_LINK: //链接
                break;
            case GlobalConstant.REQ_MESSAGE_TYPE_LOCATION: // 地理位置
                break;
        }

        return null;
    }

}
