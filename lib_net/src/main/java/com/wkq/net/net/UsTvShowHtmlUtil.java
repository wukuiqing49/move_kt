package com.wkq.net.net;


import com.wkq.net.site.USTVShowSite;

/**
 * 作者:吴奎庆
 * <p>
 * 时间:2020/5/17
 * <p>
 * 用途:
 */


public class UsTvShowHtmlUtil {

    public static <T> void getHomeUsTvShowData(UsTvShowDataCallBack<T> callBack) {
        USTVShowSite.getHomeInfo(callBack);
    };

}