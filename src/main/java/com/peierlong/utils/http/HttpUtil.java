package com.peierlong.utils.http;

import com.peierlong.utils.GlobalConstant;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 包名: com.peierlong.utils
 * 创建人 : Elong
 * 时间: 2016/12/9 下午5:32
 * 描述 : HTTP 工具类
 */
public class HttpUtil {

    private static CloseableHttpClient httpClient;

    public static String GET(String url, Map<String, String> params) {
        httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(buildGetParams(url, params));
        return sendGet(httpGet);
    }

    public static String GET(String url, Header header, Map<String, String> params) {
        httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(buildGetParams(url, params));
        httpGet.setHeader(header);
        return sendGet(httpGet);
    }

    private static String sendGet(HttpGet httpGet) {
        MyResponseHandler<String> responseHandler = new MyResponseHandler<>();
        try {
            return httpClient.execute(httpGet, responseHandler);
        } catch (IOException e) {
            e.printStackTrace();
            return GlobalConstant.REQUEST_FAILED;
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static String buildGetParams(String url, Map<String, String> params) {
        if (params == null || params.size() == 0)
            return url;
        StringBuilder sb = new StringBuilder();
        for (String key : params.keySet()) {
            String value = key == null ? "" : params.get(key);
            if (sb.length() == 0)
                sb.append(key).append("=").append(value);
            else
                sb.append("&").append(key).append("=").append(value);
        }
        return url + "?" + sb;
    }

    private static class MyResponseHandler<T> implements ResponseHandler<T> {
        @Override
        public T handleResponse(HttpResponse httpResponse) throws IOException {
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode >= 200 && statusCode < 300) {
                HttpEntity entity = httpResponse.getEntity();
                return entity != null ? (T) EntityUtils.toString(entity) : null;
            } else {
                throw new ClientProtocolException("Unexpected response status: " + statusCode);
            }
        }
    }

    public static String POST(String url, Map<String, String> params) {
        httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(buildPostParams(params)));
            CloseableHttpResponse response = httpClient.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode >= 200 && statusCode < 300) {
                HttpEntity entity = response.getEntity();
                return entity != null ? EntityUtils.toString(entity) : null;
            } else {
                return GlobalConstant.REQUEST_FAILED + " response status: " + statusCode;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return GlobalConstant.REQUEST_FAILED;
        }
    }

    private static List<NameValuePair> buildPostParams(Map<String, String> params) {
        List<NameValuePair> result = new ArrayList<>();
        for (String key : params.keySet())
            result.add(new BasicNameValuePair(key != null ? key : "", params.get(key)));
        return result;
    }


}
