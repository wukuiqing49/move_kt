package com.wkq.net.site;

import android.text.TextUtils;
import android.util.Log;

import com.wkq.net.model.USTVShowInfo;
import com.wkq.net.net.UsTvShowDataCallBack;
import com.wkq.net.util.USTVShowNetUtil;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者:吴奎庆
 * <p>
 * 时间:2020/5/17
 * <p>
 * 用途:
 */


public class USTVShowSite {

    public static void getHomeInfo(UsTvShowDataCallBack callBack) {
        Observable.create(new ObservableOnSubscribe<List<USTVShowInfo>>() {
            @Override
            public void subscribe(ObservableEmitter<List<USTVShowInfo>> emitter) throws Exception {

                String html = USTVShowNetUtil.getHtml("http://www.yyetss.com/", "UTF-8");

                if (!TextUtils.isEmpty(html)) {
                    Document document = Jsoup.parse(html);
                    if (document.select("#index-content > div:nth-child(2)") == null && document.select("#index-content > div:nth-child(2)").first() == null) {
                        emitter.onError(new Throwable("数据异常"));
                    }
                    List<Element> element = document.select("#index-content > div:nth-child(2)").first().children();
                    List<USTVShowInfo> lists = new ArrayList<>();
                    for (Element el : element) {
                        USTVShowInfo info = new USTVShowInfo();
                        String title = el.select("a").first().attr("title");
                        String href = el.select("a").first().attr("href");
                        String src = el.select("a").first().select("img").attr("src");
                        String state = el.select("a").get(1).select("span").first().text();
                        String time = el.select("a").get(1).select("p").get(1).text();

                        info.setTvName(title);
                        info.setTvTime(time);
                        info.setTvPoster(src);
                        info.setTvSite(href);
                        info.setTvState(state);
                        lists.add(info);

                    }

                    emitter.onNext(lists);
                } else {
                    emitter.onError(new Throwable("数据异常"));
                }


            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<USTVShowInfo>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<USTVShowInfo> lists) {
                        callBack.onSuccess(lists);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
