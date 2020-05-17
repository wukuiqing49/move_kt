package com.wkq.net.net;

/**
 * 作者:吴奎庆
 * <p>
 * 时间:2020-03-03
 * <p>
 * 用途:
 */


public interface UsTvShowDataCallBack<T> {
    void onFail(String message);

    void onSuccess(T t);

    void onLoading();

}
