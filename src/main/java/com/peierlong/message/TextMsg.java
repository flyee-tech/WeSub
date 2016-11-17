package com.peierlong.message;

/**
 * 包名: com.peierlong.entity
 * 创建人 : Elong
 * 时间: 11/5/16 5:23 PM
 * 描述 : 文本消息实体类
 */
public class TextMsg extends BaseMsg{
    /*
     * 内容
     */
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
