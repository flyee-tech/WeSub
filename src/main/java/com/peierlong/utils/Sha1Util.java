
package com.peierlong.utils;

import java.security.MessageDigest;
import java.util.*;

public class Sha1Util {

    //微信公众号开发的随机字串
    public static String getNonceStr() {
        MD5 m = new MD5();
        return m.getMD5ofStr(String.valueOf(new Random().nextInt(10000)));
    }

    //微信公众号开发的获取时间戳
    public static String getTimeStamp() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    //创建签名SHA1
    public static String createSHA1Sign(Map<String, String> map) throws Exception {
        SortedMap<String, String> signParams = new TreeMap<>();
        signParams.putAll(map);
        StringBuilder sb = new StringBuilder();
        Set es = signParams.entrySet();
        for (Object e : es) {
            Map.Entry entry = (Map.Entry) e;
            String k = (String) entry.getKey();
            String v = (String) entry.getValue();
            sb.append(k).append("=").append(v).append("&");
            //要采用URLENCODER的原始值！
        }
        String params = sb.substring(0, sb.lastIndexOf("&"));

        return getSha1(params);
    }

    //Sha1签名
    private static String getSha1(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f'};

        try {
            MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
            mdTemp.update(str.getBytes("UTF-8"));

            byte[] md = mdTemp.digest();
            int j = md.length;
            char buf[] = new char[j * 2];
            int k = 0;
            for (byte byte0 : md) {
                buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
                buf[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(buf);
        } catch (Exception e) {
            return null;
        }
    }
}
