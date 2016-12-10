package com.peierlong.utils.http;

import org.apache.http.HeaderElement;
import org.apache.http.ParseException;

/**
 * 包名: com.peierlong.utils.http
 * 创建人 : Elong
 * 时间: 2016/12/9 下午6:08
 */
public class Header implements org.apache.http.Header{
    private final String name;
    private final String value;

    public Header(String name, String value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public HeaderElement[] getElements() throws ParseException {
        return new HeaderElement[0];
    }
}
