package com.peierlong.utils;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 包名: com.peierlong.utils
 * 创建人 : Elong
 * 时间: 2016/11/17 下午6:00
 * 描述 : xml 工具类
 */
public class XmlUtil {

    public static Map<String, String> parseXml(InputStream in) throws Exception {
        Map<String, String> map = new HashMap<>();
        for (Element e : getChildNodes(in)) {
            map.put(e.getName(), e.getText());
        }
        return map;
    }

    private static List<Element> getChildNodes(InputStream in) throws Exception {
        Document document = new SAXReader().read(in);
        if (in != null) in.close();
        return document.getRootElement().elements(); //获取根元素的所有子节点
    }

}
