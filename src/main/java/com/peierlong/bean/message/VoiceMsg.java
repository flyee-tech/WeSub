package com.peierlong.bean.message;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 包名: com.peierlong.entity
 * 创建人 : Elong
 * 时间: 11/15/16 3:37 PM
 * 描述 : 语音消息
 * @author elong
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class VoiceMsg extends BaseMsg {
    /**
     * 语音消息媒体id，可以调用多媒体文件下载接口拉取数据。
     */
    private String mediaId;
    /**
     * 语音格式，如amr，speex等
     */
    private String format;
    /**
     * 语音识别结果，UTF8编码,开启语音识别后使用此字段
     */
    private String recognition;

}
