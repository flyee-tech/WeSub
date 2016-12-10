package com.peierlong.service.impl;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.peierlong.message.TextMsg;
import com.peierlong.service.ListenerService;
import com.peierlong.utils.GlobalConstant;
import com.peierlong.utils.MsgUtil;
import com.peierlong.utils.XmlUtil;
import com.peierlong.utils.http.Header;
import com.peierlong.utils.http.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@Service
@Qualifier("text")
public class TextListenerServiceImpl implements ListenerService {

    private static Logger logger = LoggerFactory.getLogger(TextListenerServiceImpl.class);

    @Value("${alicloudapi_iqa_url}")
    private String aliIqaUrl;
    @Value("${authorization}")
    private String authorization;

    @Override
    public String processListenerContent(Map<String, String> map) {
        String fromUserName = map.get("FromUserName");
        String toUserName = map.get("ToUserName");
        String content = map.get("Content");
        content = sendToAlicloudIqa(content);

        logger.info("Alicloud 返回内容: " + content);

        content = parseAlicloudReply(content);
        TextMsg textMsg = MsgUtil.getTextMsg(toUserName, fromUserName, content);
        String result = XmlUtil.textMsgToXml(textMsg);
        return result;
    }

    private String sendToAlicloudIqa(String content) {
        Header header = new Header("Authorization", authorization);
        Map<String, String> params = new HashMap<>();
        params.put("question", content);
        return HttpUtil.GET(aliIqaUrl, header, params);
    }

    private String parseAlicloudReply(String content){
        JSONObject object = JSON.parseObject(content);
        if (object.get("status").equals("0")) {
            JSONObject obj = object.getJSONObject("result");
            String result = obj.getString("content");
            if (result.contains("小i机器人")) {
                result = result.replace("小i机器人", "蓝胖");
            }
            return result;
        }
        return "嗯";
    }

}
