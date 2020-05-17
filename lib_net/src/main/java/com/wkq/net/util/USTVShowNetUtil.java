package com.wkq.net.util;

import com.wkq.net.net.USTVShowNet;

import java.io.IOException;
import java.util.Map;

import okhttp3.RequestBody;

/**
 * 作者:吴奎庆
 * <p>
 * 时间:2020/5/17
 * <p>
 * 用途:
 */


public class USTVShowNetUtil {

    private static USTVShowNet net = new USTVShowNet();
    /**
     * 同步获取html文件，默认编码gbk
     */
    public static String getHtml(String url) throws IOException {
        return net.getHtml(url, "gbk");
    }

    public static String getHtml(String url, String encodeType) throws IOException {
        return net.getHtml(url, null, null, encodeType);
    }

    public static String getHtml(String url, RequestBody requestBody, String encodeType) throws IOException {
        return net.getHtml(url, null, requestBody, encodeType);
    }

    public static String getHtml(String url, Map<String, String> header, RequestBody requestBody, String encodeType) throws IOException {
        return net.getHtml(url, header, requestBody, encodeType);
    }

}
