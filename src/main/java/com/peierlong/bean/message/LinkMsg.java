package com.peierlong.bean.message;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 包名: com.peierlong.entity
 * 创建人 : Elong
 * 时间: 11/15/16 3:50 PM
 * 描述 : 链接消息
 * @author elong
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class LinkMsg extends BaseMsg{
    /**
     * 消息标题
     */
    private String title;
    /**
     * 消息描述
     */
    private String description;
    /**
     * 消息链接
     */
    private String url;

}
