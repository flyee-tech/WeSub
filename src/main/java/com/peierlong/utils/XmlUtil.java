package com.peierlong.utils;

import com.peierlong.message.TextMsg;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

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

    public static String textMsgToXml(TextMsg textMsg) {
        xStream.alias("xml", textMsg.getClass());
        return xStream.toXML(textMsg);
    }

    private static XStream xStream = new XStream(new XppDriver() {
        @Override
        public HierarchicalStreamWriter createWriter(Writer out) {
            return new PrettyPrintWriter(out) {

                @Override
                public void startNode(String name, Class clazz) {
                    super.startNode(name, clazz);
                }

                @Override
                protected void writeText(QuickWriter writer, String text) {
                    if (isNeedCDATA(text)) {
                        writer.write("<![CDATA[");
                        writer.write(text);
                        writer.write("]]>");
                    } else {
                        writer.write(text);
                    }
                }

            };
        }
    }
    );

    private static boolean isNeedCDATA(String text) {
        if (text == null) return false;
        Pattern pattern = Pattern.compile("^[+-]?\\d+(\\.\\d+)?$");
        return !pattern.matcher(text).matches();
    }

}
