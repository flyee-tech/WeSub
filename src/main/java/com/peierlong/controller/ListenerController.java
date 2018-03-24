package com.peierlong.controller;

import com.alibaba.fastjson.JSON;
import com.peierlong.service.ListenerService;
import com.peierlong.utils.GlobalConstant;
import com.peierlong.utils.XmlUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 包名: com.peierlong.controller
 * 创建人 : Elong
 * 时间: 2016/11/17 下午5:23
 * 描述 : 事件监听Controller类
 */
@Controller
public class ListenerController extends BaseController{
    private static Logger logger = LoggerFactory.getLogger(ListenerController.class);
    @Autowired
    @Qualifier("event")
    private ListenerService eventListenerService;
    @Autowired
    @Qualifier("image")
    private ListenerService imageListenerService;
    @Autowired
    @Qualifier("link")
    private ListenerService linkListenerService;
    @Autowired
    @Qualifier("location")
    private ListenerService locationListenerService;
    @Autowired
    @Qualifier("text")
    private ListenerService textListenerService;
    @Autowired
    @Qualifier("voice")
    private ListenerService voiceListenerService;

    /**
     * 开启开发者模式时, 微信回调GET方法, 暂不进行加密校验, 直接返回参数表示成功
     *
     * @param echostr 验证串
     * @return 验证串
     */
    @ResponseBody
    @RequestMapping(value = "/listener", method = {RequestMethod.GET})
    public String listener(String echostr) {
        logger.info("GET请求 > listener() > 参数:echostr = {}", echostr);
        return echostr;
    }

    @ResponseBody
    @RequestMapping(value = "/listener", method = {RequestMethod.POST})
    public String listener(HttpServletRequest request) {
        Map<String, String> requestContent = null;
        try {
            requestContent = XmlUtil.parseXml(request.getInputStream());
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        if (requestContent == null) {
            return GlobalConstant.SUCCESS;
        }
        logger.info("POST请求 > listener() > 参数: request = {}", JSON.toJSONString(requestContent));
        String result = GlobalConstant.SUCCESS;
        switch (requestContent.get("MsgType")) {
            case GlobalConstant.MESSAGE_TYPE_EVENT: // 事件
                result = eventListenerService.processListenerContent(requestContent);
                break;
            case GlobalConstant.MESSAGE_TYPE_TEXT:  // 文本
                result = textListenerService.processListenerContent(requestContent);
                break;
            case GlobalConstant.MESSAGE_TYPE_IMAGE: // 图片
                result = imageListenerService.processListenerContent(requestContent);
                break;
            case GlobalConstant.MESSAGE_TYPE_VOICE: // 音频
                result = voiceListenerService.processListenerContent(requestContent);
                break;
            case GlobalConstant.MESSAGE_TYPE_LINK: //链接
                result = linkListenerService.processListenerContent(requestContent);
                break;
            case GlobalConstant.MESSAGE_TYPE_LOCATION: // 地理位置
                result = locationListenerService.processListenerContent(requestContent);
                break;
        }

        logger.info(result);

        return result;
    }

}
