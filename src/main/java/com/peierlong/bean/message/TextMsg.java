package com.peierlong.bean.message;

import lombok.Data;

/**
 * 包名: com.peierlong.entity
 * 创建人 : Elong
 * 时间: 11/5/16 5:23 PM
 * 描述 : 文本消息实体类
 */
@Data
public class TextMsg extends BaseMsg{
    /**
     * 内容
     */
    private String Content;

}
